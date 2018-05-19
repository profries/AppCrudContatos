package com.example.iossenac.apprecycleviewcontatos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.iossenac.apprecycleviewcontatos.adapter.ContatoAdapter;
import com.example.iossenac.apprecycleviewcontatos.model.Contato;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Contato> listaContatos;
    RecyclerView recyclerView;
    ContatoAdapter contatoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContatos = new ArrayList<>();
        listaContatos.add(new Contato(R.mipmap.pessoa,"Fulano","3445566"));
        listaContatos.add(new Contato(R.mipmap.pessoa,"Sicrano","32321122"));
        listaContatos.add(new Contato(R.mipmap.pessoa,"Beltrano","44332211"));

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        contatoAdapter = new ContatoAdapter(listaContatos);
        recyclerView.setAdapter(contatoAdapter);

    }
}
