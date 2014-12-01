package com.example.mmittmann.androidapp.Core.Managers;

import android.content.Context;

import com.example.mmittmann.androidapp.Core.AsynHttpClient;
import com.example.mmittmann.androidapp.Core.Model.Categoria;
import com.example.mmittmann.androidapp.Core.Model.Projeto;
import com.example.mmittmann.androidapp.Core.OurSettings;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by murilo.mittmann on 12/1/2014.
 */
public class ProjetoManager {

        private HttpClient _httpClient = null;
        private HttpContext _httpContext = null;
        private Context _ctx = null;


        public ProjetoManager(Context ctx){
            _httpClient = new DefaultHttpClient();
            _httpContext = new BasicHttpContext();
            _ctx= ctx;
        }

    public ArrayList<Projeto> retornarProjetos() throws ExecutionException, InterruptedException, JSONException {
            AsynHttpClient asynHttpClient = new AsynHttpClient(_ctx);
            String jsonResult = asynHttpClient.execute(OurSettings.UrlApi + "projetos").get();

            if(jsonResult == null || jsonResult == "")
                return new ArrayList<Projeto>();

            JSONTokener tokener = new JSONTokener(jsonResult);
            JSONObject obj = (JSONObject)tokener.nextValue();
            JSONArray jsonArray = obj.getJSONArray("results");

            ArrayList<Projeto> projetos = new ArrayList<Projeto>();

            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject o = jsonArray.getJSONObject(i);
                Projeto p = new Projeto();
                p.setNome(o.getString("nome"));
                p.setProjeto_id(o.getInt("projeto_id"));
                projetos.add(p);
            }

            return projetos;
    }
}
