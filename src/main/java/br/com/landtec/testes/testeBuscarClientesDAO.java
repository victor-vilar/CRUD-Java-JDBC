/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.landtec.testes;

import br.com.landtec.DAO.ClienteDAO;
import br.com.landtec.entidades.Cliente;
import br.com.landtec.entidades.Conexao;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Victor
 */
public class testeBuscarClientesDAO {
    
    public static void main(String[] args){
        
        ClienteDAO clienteDao = new ClienteDAO();
        Map<String,String> listaClientes = new HashMap<String,String>();
        listaClientes = clienteDao.buscarClientes(Conexao.pegarConexao());
        listaClientes.forEach((chave,valor) -> System.out.println("Chave:" + chave + ", Valor: " + valor ));
    
        Cliente cliente = new Cliente("Testezinho");
        clienteDao.cadastrarNovoCliente(cliente, Conexao.pegarConexao());
        listaClientes.clear();
        System.out.println("--------");
        listaClientes = clienteDao.buscarClientes(Conexao.pegarConexao());
        listaClientes.forEach((chave,valor) -> System.out.println("Chave:" + chave + ", Valor: " + valor ));
        
        
        int numeroDeLinhas = clienteDao.deletarCliente(15, Conexao.pegarConexao());
        listaClientes.clear();
        System.out.println("--------\n total de linhas deletadas = " + numeroDeLinhas);
        
        listaClientes = clienteDao.buscarClientes(Conexao.pegarConexao());
        listaClientes.forEach((chave,valor) -> System.out.println("Chave:" + chave + ", Valor: " + valor ));
        
        
    
    }
    
}
