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
import br.com.landtec.entidades.Conexao;
import java.sql.PreparedStatement;





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
     * @return Um HashMap contendo todos os clientes cadastrados no banco de dados
     */
        
    public Map<String, String> buscarClientes(){
        PreparedStatement pstm;
        try{
            Connection con = Conexao.pegarConexao();
            pstm = con.prepareStatement(LISTAR);
            ResultSet rst =  pstm.executeQuery();
            while(rst.next()){ 
                listaClientes.put(rst.getString("id_cliente"),rst.getString("cliente_nome"));
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
     * @param con conexão com o banco de dados.
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
     * @param idCliente inteiro que representa o id do cliente no banco de dados
     * @param con conexao com o banco de datos
     * @return inteiro que representa a quantidade de linhas afetadas
     */
    public int deletarCliente(int idCliente){
        int numeroDeLinhasAfetadas = 0;
        try{
            Connection con = Conexao.pegarConexao();
            PreparedStatement pstm = con.prepareStatement(DELETAR);
            pstm.setInt(1, idCliente);
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
     * @param idCliente int que representa o id do cliente
     * @param clienteNome String que será o novo nome que será atualizar
     * @param con conexao com o banco de dados
     * @return int que representa o numero de linhas que foram afetadas
     */
    public int atualizarInformacoesCliente(int idCliente, String clienteNome){
        int numeroDeLinhasAfetadas = 0;
        try{
            Connection con = Conexao.pegarConexao();
            PreparedStatement pstm = con.prepareStatement(ATUALIZAR);
            pstm.setString(1,clienteNome);
            pstm.setInt(2, idCliente);
            numeroDeLinhasAfetadas = pstm.executeUpdate();
            Conexao.FecharConexao(con, pstm);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }   
        
        return numeroDeLinhasAfetadas; 
    }
    
    
    
    
}
