/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.landtec.entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public abstract class Conexao {
    
    
    public static Connection pegarConexao(){
        String url = "jdbc:postgresql://localhost/landtec?user=postgres&password=231090&ssl=false";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return conn;
    }
    
}
