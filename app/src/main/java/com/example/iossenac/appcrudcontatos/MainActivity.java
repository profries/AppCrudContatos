package com.example.iossenac.appcrudcontatos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.iossenac.appcrudcontatos.R;
import com.example.iossenac.appcrudcontatos.adapter.ContatoAdapter;
import com.example.iossenac.appcrudcontatos.model.Contato;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ContatoAdapter.ContatoOnClickListener{
    private static final int REQ_CADASTRO=1;
    private static final int REQ_DETALHE=2;

    List<Contato> listaContatos;
    RecyclerView recyclerView;
    ContatoAdapter contatoAdapter;
    int posicaoAlterar=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciaLista();

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        contatoAdapter = new ContatoAdapter(getBaseContext(),listaContatos,this);
        recyclerView.setAdapter(contatoAdapter);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    private void iniciaLista() {
        listaContatos = new ArrayList<>();
        listaContatos.add(new Contato(R.mipmap.pessoa,"Fulano","3445566"));
        listaContatos.add(new Contato(R.mipmap.pessoa,"Sicrano","32321122"));
        listaContatos.add(new Contato(R.mipmap.pessoa,"Beltrano","44332211"));

    }

    @Override
    public void onClickContato(View view, int pos) {
        Intent it = new Intent(this, DetalheActivity.class);
        MainActivity.this.posicaoAlterar = pos;
        Contato contato = listaContatos.get(pos);
        it.putExtra("contato",contato);
        startActivityForResult(it,REQ_DETALHE);
    }

    public void abrirFormulario(View v){
        Intent it = new Intent(MainActivity.this, CadastroActivity.class);
        startActivityForResult(it,REQ_CADASTRO);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQ_CADASTRO)
        {
            if(resultCode == RESULT_OK){
                Contato contato = (Contato) data.getSerializableExtra("contato");
                listaContatos.add(contato);
                contatoAdapter.notifyDataSetChanged();
                Toast.makeText(this,"Cadastro realizada com sucesso!",Toast.LENGTH_SHORT)
                        .show();
            }
        }
        else if(requestCode == REQ_DETALHE){
            if(resultCode == DetalheActivity.RESULT_EDIT){
                Contato contato = (Contato) data.getSerializableExtra("contato");
                listaContatos.set(this.posicaoAlterar,
                        contato);
                contatoAdapter.notifyDataSetChanged();
                Toast.makeText(this,"Edicao realizada com sucesso!",Toast.LENGTH_SHORT)
                        .show();
            }
            else if(resultCode == DetalheActivity.RESULT_DELETE){
                listaContatos.remove(this.posicaoAlterar);
                contatoAdapter.notifyDataSetChanged();
                Toast.makeText(this,"Exclusao realizada com sucesso!",Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

}
