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
        
        System.out.println("Buscar Clientes");
        listaClientes = clienteDao.buscarClientes();
        listaClientes.forEach((chave,valor) -> System.out.println("Chave:" + chave + ", Valor: " + valor ));
        System.out.println("----------");
        
        System.out.println("Atualizar");
         int numeroDeLinhasAfetada = clienteDao.atualizarInformacoesCliente(17, "Gregorio");
        System.out.println("Total de Linhas Atualizadas: " + numeroDeLinhasAfetada);
        listaClientes.clear();
        listaClientes = clienteDao.buscarClientes();
        listaClientes.forEach((chave,valor) -> System.out.println("Chave:" + chave + ", Valor: " + valor ));
        System.out.println("----------");
        
        
        System.out.println("Deletar");
        clienteDao.deletarCliente(17);
        listaClientes.clear();
        listaClientes = clienteDao.buscarClientes();
        listaClientes.forEach((chave,valor) -> System.out.println("Chave:" + chave + ", Valor: " + valor ));
        System.out.println("----------");
        
        
        
        
    }
    
}
