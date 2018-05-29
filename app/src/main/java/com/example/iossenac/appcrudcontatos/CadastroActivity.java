package com.example.iossenac.appcrudcontatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.iossenac.appcrudcontatos.R;
import com.example.iossenac.appcrudcontatos.model.Contato;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void cadastrarContato(View view){
        EditText textoNomeCadastro = (EditText) findViewById(R.id.textoNomeCadastro);
        EditText textoTelefoneCadastro = (EditText) findViewById(R.id.textoTelefoneCadastro);
        String nome = textoNomeCadastro.getText().toString();
        String telefone = textoTelefoneCadastro.getText().toString();
        Contato contato = new Contato(R.mipmap.pessoa, nome, telefone);

        Intent it = new Intent();
        it.putExtra("contato",contato);
        setResult(RESULT_OK,it);
        finish();
    }

    public void cancelarCadastro(View view){
        finish();
    }
}
