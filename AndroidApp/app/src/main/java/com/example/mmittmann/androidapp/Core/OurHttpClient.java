package com.example.mmittmann.androidapp.Core;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmittmann on 20/11/14.
 */
public class OurHttpClient {
    public String Post(String url, ArrayList<NameValuePair> params){
        // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);

        try {
            // Ex:
            //List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            //nameValuePairs.add(new BasicNameValuePair("id", "12345"));
            //nameValuePairs.add(new BasicNameValuePair("stringdata", "AndDev is Cool!"));

            httppost.setEntity(new UrlEncodedFormEntity(params));

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);
return "";

        } catch (ClientProtocolException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
