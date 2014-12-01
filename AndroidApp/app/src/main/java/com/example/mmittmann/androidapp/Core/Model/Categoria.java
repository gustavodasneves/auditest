package com.example.mmittmann.androidapp.Core.Model;

/**
 * Created by murilo.mittmann on 11/22/2014.
 */
public class Categoria {
    private int categoria_id;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    @Override
    public String toString(){
        return getNome();
    }
}
