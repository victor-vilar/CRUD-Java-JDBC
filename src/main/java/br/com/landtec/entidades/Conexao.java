/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.landtec.entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    /**
     * Fecha a conexao com banco de dados
     * @param con varivavel do tipo Connection que represta a conexao com o banco d
     * dados
     */
    public static void FecharConexao(Connection con){
        
        try{
            if(con != null){
                con.close();
                System.out.println("Conexao Fechada");
            }   
        }
        catch(Exception e){
            System.out.println("Conexão não foi fechada: " + e.getMessage());
        }
    }
    
    /**
     * Fecha conexao com banco de dados
     * @param con varivavel do tipo Connection que represta a conexao com o banco de dados
     * @param pstm representa um preparedStatement
     */
    
    public static void FecharConexao(Connection con, PreparedStatement pstm){
        
        try{
            if(con != null){
                FecharConexao(con);   
            }   
            if(pstm != null){
                pstm.close();
                System.err.println("PreparedStatement fechado com sucesso !");
            }
        }
        catch(Exception e){
            System.out.println("Conexão não foi fechada: " + e.getMessage());
        }
    }
    
    /**
     * 
     * Fecha conexao com banco de dados
     * @param con varivavel do tipo Connection que represta a conexao com o banco de dados
     * @param pstm representa um preparedStatement
     * @param rs  representa um resultset
     */
    
    public static void FecharConexao(Connection con, PreparedStatement pstm, ResultSet rs){
        
        try{
            if(con != null && pstm != null){
                FecharConexao(con, pstm);   
            }   
            if(rs != null){
                rs.close();
                System.err.println("ResultSet fechado com sucesso !");
            }
        }
        catch(Exception e){
            System.out.println("Conexão não foi fechada: " + e.getMessage());
        }        
    }
}
