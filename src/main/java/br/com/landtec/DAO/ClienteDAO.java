/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.landtec.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import br.com.landtec.entidades.Cliente;
import br.com.landtec.entidades.Conexao;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;





/**
 * Classe para acessar e manipular a tabela <b>cliente</b> no banco de dados.
 * @author Victor Hugo Santos Vilar
 * @since Dez 2021
 * @version 1.0
 */

public class ClienteDAO {
    
    /**
     * constantes da classe
     */
    private static final String INSERIR = "INSERT INTO clientes(cliente_nome)VALUES(?)";
    private static final String DELETAR = "DELETE FROM clientes WHERE id_cliente = ?";
    private static final String ATUALIZAR = "UPDATE clientes SET cliente_nome = ? WHERE id_cliente = ?";
    private static final String LISTAR = "SELECT * FROM CLIENTES";
    private static final String BUSCAR_CLIENTE = "SELECT * FROM CLIENTES WHERE id_cliente = ?";
    
    /**
     * Um Map para poder pegar o id do cliente e o seu nome. Serve para conseguir retornar
     */
    private List<Cliente> listaClientes = new ArrayList<>(); 
    
    /**
     * O metodo busca os clientes que estão em na tabela "Clientes" do banco de dados
     * da empresa. 
     * @author Victor Hugo Santos Vilar.
     * @since Dez 2021
     * @version 1.1
     * @return Uma List de clientes contendo todos os clientes cadastrados no banco de dados
     */
        
    public List<Cliente> buscarClientes(){
         
        try{
            Connection con = Conexao.pegarConexao();
            PreparedStatement pstm = con.prepareStatement(LISTAR);
            ResultSet rst =  pstm.executeQuery();
            while(rst.next()){ 
                Cliente cliente = new Cliente(rst.getString("cliente_nome"));
                cliente.setId(rst.getInt("id_cliente"));
                listaClientes.add(cliente);
            }
            Conexao.FecharConexao(con, pstm, rst);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        
        return listaClientes;
    }
    
    /**
     * Cadastrar novo cliente no banco de dados
     * @param cliente variavel que representa um objeto do tipo cliente.
     * @since Dez 2021.
     */
    
    public void cadastrarNovoCliente(Cliente cliente){
        PreparedStatement pstm;
        try{
            Connection con = Conexao.pegarConexao();
            pstm = con.prepareStatement(INSERIR);
            pstm.setString(1, cliente.getNome());
            pstm.execute();
            Conexao.FecharConexao(con, pstm);
            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * metodo para deletar o cliente pelo id
     * @author Victor Hugo Santos Vilar
     * @since Dez 2021
     * @param cliente um cliente que esta no banco de dados
     * @return inteiro que representa a quantidade de linhas afetadas
     */
    public int deletarCliente(Cliente cliente){
        int numeroDeLinhasAfetadas = 0;
        try{
            Connection con = Conexao.pegarConexao();
            PreparedStatement pstm = con.prepareStatement(DELETAR);
            pstm.setInt(1, cliente.getId());
            numeroDeLinhasAfetadas = pstm.executeUpdate();
            Conexao.FecharConexao(con, pstm);
        }      
        catch(SQLException e){
            System.out.println(e.getMessage());
        }   
        return numeroDeLinhasAfetadas;
    }
    /**
     * Metodo para atualizar dados do cliente no banco de dados
     * @param cliente no banco de dados
     * @return int que representa o numero de linhas que foram afetadas
     */
    public int atualizarInformacoesCliente(Cliente cliente){
        int numeroDeLinhasAfetadas = 0;
        try{
            Connection con = Conexao.pegarConexao();
            PreparedStatement pstm = con.prepareStatement(ATUALIZAR);
            pstm.setString(1,cliente.getNome());
            pstm.setInt(2, cliente.getId());
            numeroDeLinhasAfetadas = pstm.executeUpdate();
            Conexao.FecharConexao(con, pstm);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }   
        
        return numeroDeLinhasAfetadas; 
    }
    
    /**
     * Buscar um cliente especifico pelo id
     * @param id do cliente no banco de dados
     * @return um objeto do tipo cliente 
     */
    public Cliente buscarCliente(int id){
        Cliente cliente = null;
        try{
            Connection con = Conexao.pegarConexao();
            PreparedStatement pstm = con.prepareStatement(BUSCAR_CLIENTE);
            pstm.setInt(1,id);
            ResultSet rst = pstm.executeQuery();
            while(rst.next()){
                cliente = new Cliente(rst.getString("cliente_nome"));
                cliente.setId(rst.getInt("id_cliente"));
            }
            Conexao.FecharConexao(con,pstm,rst);
            
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return cliente;
        
    }
    
}
