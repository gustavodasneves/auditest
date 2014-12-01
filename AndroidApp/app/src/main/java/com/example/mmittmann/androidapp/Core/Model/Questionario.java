package com.example.mmittmann.androidapp.Core.Model;

/**
 * Created by murilo.mittmann on 12/1/2014.
 */
public class Questionario {
    private int questionario_id;
            private String nome;
    private Projeto projeto;

    public int getQuestionario_id() {
        return questionario_id;
    }

    public void setQuestionario_id(int questionario_id) {
        this.questionario_id = questionario_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    @Override
    public String toString(){
        return getNome();
    }
}
