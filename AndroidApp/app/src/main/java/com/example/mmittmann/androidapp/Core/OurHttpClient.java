package com.example.mmittmann.androidapp.Core;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmittmann on 20/11/14.
 */
public class OurHttpClient extends AsyncTask<String, Void, String> {
    Context context;

    public OurHttpClient(Context c) {
        context = c;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String responseString="";
        HttpClient client = null;
        try {
            client = new DefaultHttpClient();
            HttpGet get = new HttpGet(params[0]);
            HttpResponse responseGet = client.execute(get);
            HttpEntity resEntityGet = responseGet.getEntity();
            if (resEntityGet != null) {
                responseString = EntityUtils.toString(resEntityGet);
                Log.i("GET RESPONSE", responseString.trim());
            }
        } catch (Exception e) {
            Log.d("ANDRO_ASYNC_ERROR", "Error is "+e.toString());
        }
        Log.d("ANDRO_ASYNC_RESPONSE", responseString.trim());
        client.getConnectionManager().shutdown();
        return responseString.trim();

    }


    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
    }
}