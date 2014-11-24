package com.example.mmittmann.androidapp.Core;

import android.content.Context;
import android.util.JsonReader;
import android.util.Log;

import com.example.mmittmann.androidapp.Core.Model.Categoria;
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

/**
 * Created by mmittmann on 20/11/14.
 */
public class CategoriaManager {



    private HttpClient _httpClient = null;
    private HttpContext _httpContext = null;
    private Context _ctx;


    public CategoriaManager(Context ctx){
        this._ctx = ctx;
        _httpClient = new DefaultHttpClient();
        _httpContext = new BasicHttpContext();
    }

    public List<Categoria> RetornarTodas() throws IOException, JSONException {

        OurHttpClient ourHttpClient = new OurHttpClient();
        String jsonResult = ourHttpClient.HttpGet(OurSettings.UrlApi + "categorias");

        JSONTokener tokener = new JSONTokener(jsonResult);
        JSONArray jsonArray = new JSONArray(tokener);

        ArrayList<Categoria> categorias = new ArrayList<Categoria>();

        for (int i=0; i<jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            Categoria c = new Categoria();
            c.setNome("Teste");
            categorias.add(c);
        }


        return categorias;
    }

}
