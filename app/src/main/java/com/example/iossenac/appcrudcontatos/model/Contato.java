package com.example.iossenac.appcrudcontatos.model;

import java.io.Serializable;

public class Contato implements Serializable{
    private int imagemR;
    private String nome, telefone;


    public Contato(int imagemR, String nome, String telefone) {
        this.imagemR = imagemR;
        this.nome = nome;
        this.telefone = telefone;

    }

    public int getImagemR() {
        return imagemR;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}
