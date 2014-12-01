package com.example.mmittmann.androidapp.Core.Managers;

import android.content.Context;

import com.example.mmittmann.androidapp.Core.AsynHttpClient;
import com.example.mmittmann.androidapp.Core.Model.Categoria;
import com.example.mmittmann.androidapp.Core.Model.Pergunta;
import com.example.mmittmann.androidapp.Core.OurSettings;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by murilo.mittmann on 12/1/2014.
 */
public class PerguntaManager {

    private HttpClient _httpClient = null;
    private HttpContext _httpContext = null;
    private Context _ctx = null;


    public PerguntaManager(Context ctx){
        _httpClient = new DefaultHttpClient();
        _httpContext = new BasicHttpContext();
        _ctx= ctx;
    }

    public ArrayList<Pergunta> retornarPerguntas() throws ExecutionException, InterruptedException, JSONException {
        AsynHttpClient asynHttpClient = new AsynHttpClient(_ctx);
        String jsonResult = asynHttpClient.execute(OurSettings.UrlApi + "perguntas").get();

        if(jsonResult == null || jsonResult == "")
            return new ArrayList<Pergunta>();

        JSONTokener tokener = new JSONTokener(jsonResult);
        JSONObject obj = (JSONObject)tokener.nextValue();
        JSONArray jsonArray = obj.getJSONArray("results");

        ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();

        for (int i=0; i<jsonArray.length(); i++) {
            JSONObject o = jsonArray.getJSONObject(i);

            Pergunta p = new Pergunta();
            p.setEnunciado(o.getString("enunciado"));
            p.setPergunta_id(o.getInt("pergunta_id"));


            String categoriaURL = o.getString("categoria");
            asynHttpClient = new AsynHttpClient(_ctx);
            String categoriaJsonResult = asynHttpClient.execute(categoriaURL).get();
            JSONTokener categoriaTokener = new JSONTokener(categoriaJsonResult);
            JSONObject categoriaObj = (JSONObject)categoriaTokener.nextValue();

            Categoria c = new Categoria();
            c.setNome(categoriaObj.getString("nome"));
            c.setCategoria_id(categoriaObj.getInt("categoria_id"));

            p.setCategoria(c);
            perguntas.add(p);
        }

        return perguntas;

    }
}
