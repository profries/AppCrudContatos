package com.example.iossenac.appcrudcontatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.iossenac.appcrudcontatos.R;
import com.example.iossenac.appcrudcontatos.model.Contato;

public class DetalheActivity extends AppCompatActivity {
    public static final int RESULT_EDIT=1;
    public static final int RESULT_DELETE=2;
    private EditText textoNomeDetalhe, textoTelefoneDetalhe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);



        Intent intent = getIntent();
        Contato contato = (Contato) intent.getSerializableExtra("contato");

        textoNomeDetalhe = (EditText) findViewById(R.id.textoNomeDetalhe);
        textoNomeDetalhe.setText(contato.getNome());
        textoTelefoneDetalhe = (EditText) findViewById(R.id.textoTelefoneDetalhe);
        textoTelefoneDetalhe.setText(contato.getTelefone());

    }

    public void editarContato(View v){
        Contato contato = new Contato(R.mipmap.pessoa,textoNomeDetalhe.getText().toString(),
                textoTelefoneDetalhe.getText().toString());
        Intent data = new Intent();
        data.putExtra("contato",contato);
        setResult(RESULT_EDIT,data);
        finish();
    }

    public void excluirContato(View v){
        setResult(RESULT_DELETE);
        finish();
    }

    public void voltar(View v){
        finish();
    }
}
