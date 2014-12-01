package com.example.mmittmann.androidapp.Core;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

/**
 * Created by mmittmann on 22/11/14.
 */
public class OurHttpClient {
    public String HttpGet(String url) throws IOException {

        Log.i("Teste", "Chegou aqui");
        HttpContext httpContext = new BasicHttpContext();
        HttpGet httpGet = new HttpGet(url);
        HttpClient _httpClient = new DefaultHttpClient();

        Log.i("Teste", "Chegou aqui");


        HttpResponse httpResponse = _httpClient.execute(httpGet, httpContext);

        Log.i("Teste", "Executou a requisicao");

        HttpEntity entity = httpResponse.getEntity();
        String jsonResult = Util.getASCIIContentFromEntity(entity);

        Log.i("Teste", jsonResult);

        return jsonResult;
    }

    public String HttpPost(String url, String params)
    {
        return "";
    }
}
