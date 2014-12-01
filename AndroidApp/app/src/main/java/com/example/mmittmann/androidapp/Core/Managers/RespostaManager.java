package com.example.mmittmann.androidapp.Core.Managers;

import android.content.Context;

import com.example.mmittmann.androidapp.Core.AsyncHttpPost;
import com.example.mmittmann.androidapp.Core.Model.Resposta;
import com.example.mmittmann.androidapp.Core.OurSettings;

/**
 * Created by murilo.mittmann on 12/1/2014.
 */
public class RespostaManager {
    Context _ctx;
    public RespostaManager(Context ctx){
         _ctx = ctx;
    }

public void inserirResposta(Resposta resposta){
    try {
        AsyncHttpPost asyncHttpPost = new AsyncHttpPost(_ctx);
        String urlApi = OurSettings.UrlApi + "respostas";
        String idPergunta = resposta.getPergunta().getPergunta_id() + "";
        String valorResposta = resposta.getValor_resposta();
        String hora = resposta.getData_hora().toString();
        String[] params = new String[]{urlApi, idPergunta, valorResposta, hora};
        asyncHttpPost.execute(params);
    }
    catch(Exception ex){}
}
}
