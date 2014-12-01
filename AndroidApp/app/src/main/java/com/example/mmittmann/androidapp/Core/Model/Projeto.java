package com.example.mmittmann.androidapp.Core.Model;

/**
 * Created by murilo.mittmann on 12/1/2014.
 */
public class Projeto {
    private int projeto_id;
            private String nome;

    public int getProjeto_id() {
        return projeto_id;
    }

    public void setProjeto_id(int projeto_id) {
        this.projeto_id = projeto_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return getNome();
    }
}
