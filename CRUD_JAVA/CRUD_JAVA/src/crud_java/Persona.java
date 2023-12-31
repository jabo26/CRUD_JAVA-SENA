/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_java;

import java.sql.*;


/**
 *
 * @author jjbov01
 */
public class Persona {

    Conectate conx;

    public Persona() {
        conx = new Conectate();
    }

    public void nuevaPersona(String nombre, String apellidoPaterno, String apellidoMaterno, String correo) {
        try {            
            PreparedStatement pstm = conx.getConnection().prepareStatement("insert into "
                    + "persona(Nombre, appPaterno, appMaterno, mail) "
                    + " values(?,?,?,?)");
            pstm.setString(1, nombre);
            pstm.setString(2, apellidoPaterno);
            pstm.setString(3, apellidoMaterno);
            pstm.setString(4, correo);
            pstm.execute();
            pstm.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*obtenemos todos los datos de la tabla*/
    public Object[][] getDatos() {
        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = conx.getConnection().prepareStatement("SELECT count(1) as total FROM persona ");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][5];
        //realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement pstm = conx.getConnection().prepareStatement("SELECT "
                    + " id, Nombre, appPaterno, appMaterno, mail "
                    + " FROM persona"
                    + " ORDER BY id DESC");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                String estCodigo = res.getString("id");
                String estNombre = res.getString("nombre");
                String estpaterno = res.getString("appPaterno");
                String estmaterno = res.getString("appMaterno");
                String estmail = res.getString("mail");
                data[i][0] = estCodigo;
                data[i][1] = estNombre;
                data[i][2] = estpaterno;
                data[i][3] = estmaterno;
                data[i][4] = estmail;
                i++;
            }

            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return data;

    }

    public void deletePersona(String cod) {
        try {
            PreparedStatement pstm = conx.getConnection().prepareStatement("delete from persona where id = ?");
            pstm.setString(1, cod);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void updatePersona(String id, String name, String paterno, String materno, String mail){
       try {            
            PreparedStatement pstm = conx.getConnection().prepareStatement("update persona " +
            "set Nombre = ? ," +
            "appPaterno = ? ," +
            "appMaterno = ? ," +                    
            "mail = ? " +                    
            "where id = ? ");            
            pstm.setString(1, name);                   
            pstm.setString(2, paterno);
            pstm.setString(3, materno);
            pstm.setString(4, mail);
            pstm.setString(5, String.valueOf(id));
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }


}
