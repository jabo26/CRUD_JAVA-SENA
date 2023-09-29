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
public class Conectate {

    static String bd = "dbcontactos";
    static String login = "root";
    static String password = "Colombia2023++";
    static String url = "jdbc:mysql://127.0.0.1:3306/" + bd;

    Connection conn = null;

    /**
     * Constructor de DbConnection
     */
    public Conectate() {
        try {           
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtenemos la conexión
            conn = DriverManager.getConnection(url, login, password);
            if (conn != null) {
                System.out.println("Conección a base de datos " + bd + ". listo");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    /**
     * Permite retornar la conexión
     */
    public Connection getConnection() {
        return conn;
    }

    public void desconectar() {
        conn = null;
        System.out.println("La conexion a la  base de datos " + bd + " a terminado");
    }

}
