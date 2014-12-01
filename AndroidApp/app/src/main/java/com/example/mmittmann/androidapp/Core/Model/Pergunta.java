package com.example.mmittmann.androidapp.Core.Model;

/**
 * Created by murilo.mittmann on 12/1/2014.
 */
public class Pergunta {
    private int  pergunta_id;
    private String enunciado;
    private Categoria categoria;

    public int getPergunta_id() {
        return pergunta_id;
    }

    public void setPergunta_id(int pergunta_id) {
        this.pergunta_id = pergunta_id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString(){
        return getEnunciado();
    }
}
