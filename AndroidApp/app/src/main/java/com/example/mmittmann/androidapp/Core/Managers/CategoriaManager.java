package com.example.mmittmann.androidapp.Core.Managers;

import android.content.Context;
import android.util.JsonReader;
import android.util.Log;

import com.example.mmittmann.androidapp.Core.AsynHttpClient;
import com.example.mmittmann.androidapp.Core.Model.Categoria;
import com.example.mmittmann.androidapp.Core.OurSettings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by mmittmann on 20/11/14.
 */
public class CategoriaManager {

    private HttpClient _httpClient = null;
    private HttpContext _httpContext = null;
    private Context _ctx = null;


    public CategoriaManager(Context ctx){
        _httpClient = new DefaultHttpClient();
        _httpContext = new BasicHttpContext();
        _ctx= ctx;
    }

    public ArrayList<Categoria> RetornarTodas() throws IOException, JSONException, InterruptedException, ExecutionException {
       AsynHttpClient asynHttpClient = new AsynHttpClient(_ctx);
        String jsonResult = asynHttpClient.execute(OurSettings.UrlApi + "categorias").get();

        //= asynHttpClient.result;

       if(jsonResult == null || jsonResult == "")
           return new ArrayList<Categoria>();

       /* OurHttpClient ourHttpClient = new OurHttpClient();
        String jsonResult = ourHttpClient.HttpGet(OurSettings.UrlApi + "categorias");*/

        JSONTokener tokener = new JSONTokener(jsonResult);
        JSONObject obj = (JSONObject)tokener.nextValue();
        JSONArray jsonArray = obj.getJSONArray("results");

        ArrayList<Categoria> categorias = new ArrayList<Categoria>();

        for (int i=0; i<jsonArray.length(); i++) {
            JSONObject o = jsonArray.getJSONObject(i);
            Categoria c = new Categoria();
            c.setNome(o.getString("nome"));
            c.setCategoria_id(o.getInt("categoria_id"));
            categorias.add(c);
        }

        return categorias;
    }

}
