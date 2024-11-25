package CadastroPOO.model;

import java.io.Serializable;

public class Pessoa implements Serializable  {
    private int id;
    private String nome;
    
    //metodo exibir
    public void exibir() {
        System.out.println("ID: " + id + "\nNome: " + nome);
    }
    
    //construtor
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    //getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
