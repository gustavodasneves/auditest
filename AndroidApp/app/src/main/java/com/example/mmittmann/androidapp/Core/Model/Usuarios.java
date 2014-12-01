package com.example.mmittmann.androidapp.Core.Model;

/**
 * Created by murilo.mittmann on 12/1/2014.
 */
public class Usuarios {
    private int usuario_id;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    @Override
    public String toString(){
        return getNome();
    }
}
