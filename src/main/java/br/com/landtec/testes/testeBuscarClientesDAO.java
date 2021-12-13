/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.landtec.testes;

import br.com.landtec.DAO.ClienteDAO;
import br.com.landtec.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 */
public class testeBuscarClientesDAO {
    
    public static void main(String[] args){
        
        ClienteDAO clienteDao = new ClienteDAO();
        List<Cliente> listaClientes;
        Cliente cliente1 = new Cliente("Joares");
        
        //EXIBIR
        System.out.println("Buscar Clientes");
        listaClientes = clienteDao.buscarClientes();
        listaClientes.forEach(obj -> System.out.println("Id: " + obj.getId() + " - Nome: " + obj.getNome() ));
        System.out.println("----------");
        
        
        //INSERIR
        System.out.println("Inserir");
        clienteDao.cadastrarNovoCliente(cliente1);
        listaClientes.clear();
        listaClientes = clienteDao.buscarClientes();
        listaClientes.forEach(obj -> System.out.println("Id: " + obj.getId() + " - Nome: " + obj.getNome() ));
        System.out.println("----------");
        
        
        //ATUALIZAR
        System.out.println("Atualizar");
        cliente1.setNome("Marcondes");
        int numeroDeLinhasAfetada = clienteDao.atualizarInformacoesCliente(cliente1);
        System.out.println("Total de Linhas Atualizadas: " + numeroDeLinhasAfetada);
        listaClientes.clear();
        listaClientes = clienteDao.buscarClientes();
        listaClientes.forEach(obj -> System.out.println("Id: " + obj.getId() + " - Nome: " + obj.getNome() ));
        System.out.println("----------");
        
        
        //DELETAR
        System.out.println("Deletar");
        clienteDao.deletarCliente(cliente1);
        listaClientes.clear();
        listaClientes = clienteDao.buscarClientes();
        listaClientes.forEach(obj -> System.out.println("Id: " + obj.getId() + " - Nome: " + obj.getNome() ));
        System.out.println("----------");
        
        
        
        
    }
    
}
