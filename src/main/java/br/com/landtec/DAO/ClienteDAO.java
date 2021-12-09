/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.landtec.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import br.com.landtec.entidades.Cliente;

/**
 * Classe para acessar e manipular a tabela <b>cliente</b> no banco de dados.
 * @author Victor Hugo Santos Vilar
 * @since Dez 2021
 * @version 1.0
 */


public class ClienteDAO {
    /**
     * Um Map para poder pegar o id do cliente e o seu nome. Serve para conseguir retornar
     */
    private Map<String, String> listaClientes = new HashMap<String,String>(); 
    
    /**
     * O metodo busca os clientes que estão em na tabela "Clientes" do banco de dados
     * da empresa. Retorna um HashMap com o Id e nome do cliente.
     * @author Victor Hugo Santos Vilar.
     * @since Dez 2021
     * @version 1.0
     * @param con objeto de conexao com o banco de dados.
     * @return 
     */
        
    public Map<String, String> buscarClientes(Connection con){
        

        Statement stt;
   
        try{
            
            stt = con.createStatement();
            ResultSet rst =  stt.executeQuery("SELECT * FROM clientes");
            while(rst.next()){ 
                listaClientes.put(rst.getString("id_cliente"),rst.getString("cliente_nome"));
            }
            stt.close();
            rst.close();
        }
        
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        
        return listaClientes;
    }
    
    public void cadastrarNovoCliente(Cliente cliente){
        
    }
    
    
    
    
    
}
