package com.example.mmittmann.androidapp.Core;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class AsynHttpClient extends AsyncTask<String, Void, String> {
    Context context;
    public String result;

    public AsynHttpClient(Context c) {
        context = c;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    public String doInBackground(String... params) {
     Log.i("Teste", "Chegou aqui");
        HttpContext httpContext = new BasicHttpContext();
        HttpGet httpGet = new HttpGet(params[0]);

        Log.i("Teste", "Chegou aqui");


        HttpClient _httpClient = new DefaultHttpClient();
        HttpResponse httpResponse = null;
        try {
            httpResponse = _httpClient.execute(httpGet, httpContext);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i("Teste", "Executou a requisicao");

        HttpEntity entity = httpResponse.getEntity();
        String jsonResult = null;
        try {
            jsonResult = Util.getASCIIContentFromEntity(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i("Teste", jsonResult);

        return jsonResult;
    }


    protected void onPostExecute(String result) {
        this.result = result;

    } // protected void onPostExecute(Void v)

}