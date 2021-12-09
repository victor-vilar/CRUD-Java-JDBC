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
     * @since Dez 2021
     * @author Victor Hugo Santos Vilar
     * @param nome variavel do tipo String que ira ser inserida no nome. 
     */
    public Cliente (String nome){
        this.nome = nome;
    }
    
    /**
     * setar o nome do cliente
     * @param nome variavel do tipo string para ser armazenada na variavel nome
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * pegar o nome do cliente
     * @return string contendo o nome do cliente
     */
    public String getNome(){
        return this.nome;
    }
    
}
