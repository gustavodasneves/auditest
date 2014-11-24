package com.example.mmittmann.androidapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.mmittmann.androidapp.Core.CategoriaManager;
import com.example.mmittmann.androidapp.Core.Model.Categoria;
import com.example.mmittmann.androidapp.Core.OurHttpClient;
import com.example.mmittmann.androidapp.Core.OurSettings;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

            new Thread(){
                @Override
                public void run(){

                    CategoriaManager categoriaManager = new CategoriaManager(MainActivity.this);
                    final Spinner spnCategorias;
                    try {

                        List<Categoria> categorias = categoriaManager.RetornarTodas();

                        spnCategorias = (Spinner)findViewById(R.id.spnProjetos);

                        ArrayAdapter<Categoria> dataAdapter = new ArrayAdapter<Categoria>(MainActivity.this,
                                android.R.layout.simple_spinner_item, categorias);
                        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnCategorias.setAdapter(dataAdapter);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }.start();


            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
