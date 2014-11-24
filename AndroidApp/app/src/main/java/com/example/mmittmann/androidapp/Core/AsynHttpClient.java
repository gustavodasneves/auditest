package com.example.mmittmann.androidapp.Core;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AsynHttpClient extends AsyncTask<String, String, Void> {
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
    public Void doInBackground(String... params) {
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
        result = responseString.trim();
        return null;
    }


    protected void onPostExecute(Void v) {

        //parse JSON data
        try{
            JSONArray jArray = new JSONArray(result);

            for(int i=0; i < jArray.length(); i++) {

                JSONObject jObject = jArray.getJSONObject(i);

                String name = jObject.getString("name");
                String tab1_text = jObject.getString("tab1_text");
                int active = jObject.getInt("active");


            }

        } catch (JSONException e) {

            Log.e("JSONException", "Error: " + e.toString());

        } // catch (JSONException e)


    } // protected void onPostExecute(Void v)

}