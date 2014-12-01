package com.example.mmittmann.androidapp.Core.Model;

import java.util.Date;

/**
 * Created by murilo.mittmann on 12/1/2014.
 */
public class Resposta {
  private int  resposta_id;
  private Pergunta  pergunta;
  private Usuarios  usuario;
  private String  valor_resposta;
  private Date data_hora;

    public int getResposta_id() {
        return resposta_id;
    }

    public void setResposta_id(int resposta_id) {
        this.resposta_id = resposta_id;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getValor_resposta() {
        return valor_resposta;
    }

    public void setValor_resposta(String valor_resposta) {
        this.valor_resposta = valor_resposta;
    }

    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

    @Override
    public String toString(){
        return getValor_resposta();
    }
}
