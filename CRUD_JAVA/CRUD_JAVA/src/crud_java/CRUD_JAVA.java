/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_java;

/**
 *
 * @author jjbov01
 */
public class CRUD_JAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona p = new Persona();
        System.out.println("El programa a iniciado.. ");

        /* p.nuevaPersona("JABO", "PRUEBA", "DE INSERT", "prueba@mail.com");
        p.conx.desconectar();*/
 /* Object [][] sc ;
        sc = p.getDatos();
        for(int i=0;i<sc.length ;i++){
            System.out.println("> " + sc[i][0] + " - " + sc[i][1]);            
        }   */
        p.conx.desconectar();

        System.out.println("El programa a finalizado.. ");
    }

}
