package com.example.mmittmann.androidapp.Core;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class AsyncHttpPost extends AsyncTask<String, Void, String> {
    Context context;
    public String result;

    public AsyncHttpPost(Context c) {
        context = c;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    public String doInBackground(String... params) {

        BufferedReader inBuffer = null;

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(params[0]);
        UrlEncodedFormEntity formEntity = null;

        List<NameValuePair> postParameters =
                new ArrayList<NameValuePair>();
        postParameters.add(new BasicNameValuePair("pergunta_id", params[1]));
        postParameters.add(new BasicNameValuePair("valor_resposta", params[2]));
        postParameters.add(new BasicNameValuePair("data_hora", params[3]));

        try {
            formEntity = new UrlEncodedFormEntity(
                    postParameters);
            Log.i("form entity", formEntity.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        httpPost.setEntity(formEntity);
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            inBuffer = new BufferedReader(
                    new InputStreamReader(
                            httpResponse.getEntity().getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuffer stringBuffer = new StringBuffer("");
        String line = "";
        String newLine = System.getProperty("line.separator");
        assert inBuffer != null;
        try {
            while ((line = inBuffer.readLine()) != null) {
                stringBuffer.append(line + newLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            inBuffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        result = stringBuffer.toString();
        Log.i("EXECUCAO DA REQUISICAO", result);
        return result;
    }


    protected void onPostExecute(String result) {
        this.result = result;

    } // protected void onPostExecute(Void v)

}