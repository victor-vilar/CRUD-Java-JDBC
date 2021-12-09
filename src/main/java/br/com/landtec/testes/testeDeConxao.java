/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.landtec.testes;
import br.com.landtec.entidades.Conexao;
import java.sql.Connection;

/**
 *
 * @author Victor
 * 
 */
public class testeDeConxao {
    
    public static void main(String[] args){
        
        Connection conn = Conexao.pegarConexao();   
        
        
    }
}
