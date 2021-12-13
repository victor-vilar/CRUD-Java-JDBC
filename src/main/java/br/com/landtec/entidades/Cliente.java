/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.landtec.entidades;

/**
 * Classe cliente criada para poder manipular os dados e poder ser incluido no banco de dados
 * @since Dez 2021
 * @author Victor Hugo Santos Vilar
 */
public class Cliente {
    
    /**
     * atributo privado nome
     */
    private String nome;
    
    
    /**
     * id do cliente no banco de dados
     */
    private int id;
    
    /**
     * @since Dez 2021
     * @param nome variavel do tipo String que ira ser inserida no nome. 
     */
    public Cliente (String nome){
        this.nome = nome;
    }
    
    /**
     * setar o nome do cliente
     * @since Dez 2021
     * @param nome variavel do tipo string para ser armazenada na variavel nome
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * setar o id do cliente
     * @since Dez 2021
     * @param id id que o cliente possui no banco de dados, esse metodo somente será utilizado 
     * para armazenar o id que o cliente possui, não sendo utilizado pelo usuário decidir qual será o id
     */
    public void setId(int id){
        this.id = id;
    }
    
    
    /**
     * pegar o nome do cliente
     * @since Dez 2021
     * @return string contendo o nome do cliente
     */
    public String getNome(){
        return this.nome;
    }
    
    /**
     * retornar o id do cliente
     * @since Dez 2021
     * @return inteiro que representa o id do cliente
     */
    public int getId(){
        return this.id;
    }
    
}
