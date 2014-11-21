package com.example.mmittmann.androidapp.Core;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmittmann on 20/11/14.
 */
public class Categoria {

    private int categoria_id;
    private String nome;

    private HttpClient _httpClient = null;
    private HttpContext _httpContext = null;



    public Categoria(){
        _httpClient = new DefaultHttpClient();
        _httpContext = new BasicHttpContext();
    }

    public List<Categoria> RetornarTodas() throws IOException {

        HttpGet httpGet = new HttpGet(OurSettings.UrlApi + "categorias");

        HttpResponse httpResponse = _httpClient.execute(httpGet, _httpContext);

        HttpEntity entity = httpResponse.getEntity();

        String text = Util.getASCIIContentFromEntity(entity);

        return new ArrayList<Categoria>();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }
}
