/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpharmacie;

/**
 *
 * @author MT98
 */
import java.sql.*;
public class connexionToDatabase {
    String urlPilote="com.mysql.jdbc.Driver";
    String urlDatabase="jdbc:mysql://localhost:3306/gestionpharmacie";
    Connection con;
    public connexionToDatabase()
    {
       try
       {
         Class.forName(urlPilote);
       }
       catch(ClassNotFoundException ex)
       {
           System.out.println(ex);
       }
       
       try 
       {
          con = DriverManager.getConnection(urlDatabase,"root",""); 
          System.out.println("connexion à la base de données réussie");
       }
       catch(SQLException ex)
       {
           System.out.println(ex);
       }
    }
    Connection getConnexionFromDatabase()
    {
        return con;
    }
}
 