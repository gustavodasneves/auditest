package com.example.mmittmann.androidapp.Core.Managers;

import android.content.Context;

import com.example.mmittmann.androidapp.Core.AsynHttpClient;
import com.example.mmittmann.androidapp.Core.Model.Categoria;
import com.example.mmittmann.androidapp.Core.Model.Pergunta;
import com.example.mmittmann.androidapp.Core.Model.Projeto;
import com.example.mmittmann.androidapp.Core.Model.Questionario;
import com.example.mmittmann.androidapp.Core.OurSettings;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by murilo.mittmann on 12/1/2014.
 */
public class QuestionarioManager {

    private HttpClient _httpClient = null;
    private HttpContext _httpContext = null;
    private Context _ctx = null;


    public QuestionarioManager(Context ctx){
        _httpClient = new DefaultHttpClient();
        _httpContext = new BasicHttpContext();
        _ctx= ctx;
    }
    public ArrayList<Questionario> retornarQuestionarios() throws ExecutionException, InterruptedException, JSONException {

        AsynHttpClient asynHttpClient = new AsynHttpClient(_ctx);
        String jsonResult = asynHttpClient.execute(OurSettings.UrlApi + "questionarios").get();

        if(jsonResult == null || jsonResult == "")
            return new ArrayList<Questionario>();

        JSONTokener tokener = new JSONTokener(jsonResult);
        JSONObject obj = (JSONObject)tokener.nextValue();
        JSONArray jsonArray = obj.getJSONArray("results");

        ArrayList<Questionario> questionarios = new ArrayList<Questionario>();

        for (int i=0; i<jsonArray.length(); i++) {
            JSONObject o = jsonArray.getJSONObject(i);

            Questionario q = new Questionario();
            q.setNome(o.getString("nome"));
            q.setQuestionario_id(o.getInt("questionario_id"));

            String projetoURL = o.getString("projeto_id");
            asynHttpClient = new AsynHttpClient(_ctx);
            String projetoJsonResult = asynHttpClient.execute(projetoURL).get();
            JSONTokener projetoTokener = new JSONTokener(projetoJsonResult);
            JSONObject projetoObj = (JSONObject)projetoTokener.nextValue();

            Projeto p = new Projeto();
            p.setNome(projetoObj.getString("nome"));
            p.setProjeto_id(projetoObj.getInt("projeto_id"));

            q.setProjeto(p);
            questionarios.add(q);
        }

        return questionarios;

    }
}
