package com.example.iossenac.appcrudcontatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.iossenac.appcrudcontatos.R;
import com.example.iossenac.appcrudcontatos.model.Contato;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);



        Intent intent = getIntent();
        Contato contato = (Contato) intent.getSerializableExtra("contato");

        EditText textoNomeDetalhe = (EditText) findViewById(R.id.textoNomeDetalhe);
        textoNomeDetalhe.setText(contato.getNome());
        EditText textoTelefoneDetalhe = (EditText) findViewById(R.id.textoTelefoneDetalhe);
        textoTelefoneDetalhe.setText(contato.getTelefone());

    }
}
