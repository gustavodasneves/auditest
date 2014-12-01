package com.example.mmittmann.androidapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.mmittmann.androidapp.Core.Managers.CategoriaManager;
import com.example.mmittmann.androidapp.Core.Managers.PerguntaManager;
import com.example.mmittmann.androidapp.Core.Managers.ProjetoManager;
import com.example.mmittmann.androidapp.Core.Managers.QuestionarioManager;
import com.example.mmittmann.androidapp.Core.Managers.RespostaManager;
import com.example.mmittmann.androidapp.Core.Model.Categoria;
import com.example.mmittmann.androidapp.Core.Model.Pergunta;
import com.example.mmittmann.androidapp.Core.Model.Projeto;
import com.example.mmittmann.androidapp.Core.Model.Questionario;
import com.example.mmittmann.androidapp.Core.Model.Resposta;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resposta r = new Resposta();
        r.setData_hora(new Date());
        r.setResposta_id(1);
        r.setValor_resposta("teteteteste");
        Pergunta p = new Pergunta();
        p.setPergunta_id(1);
        r.setPergunta(p);
        RespostaManager rm = new RespostaManager(this);
        rm.inserirResposta(r);

                    QuestionarioManager questionarioManager = new QuestionarioManager(this);

        ArrayList<Questionario> questionarios = new ArrayList<Questionario>();
        try {
            questionarios = questionarioManager.retornarQuestionarios();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Spinner spnCategorias = (Spinner)findViewById(R.id.spnProjetos);

         ArrayAdapter<Questionario> dataAdapter = new ArrayAdapter<Questionario>(this,
                 android.R.layout.simple_spinner_item, questionarios);
         //dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         spnCategorias.setAdapter(dataAdapter);


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
