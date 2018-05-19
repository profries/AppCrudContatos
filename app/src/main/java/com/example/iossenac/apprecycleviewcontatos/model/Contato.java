package com.example.iossenac.apprecycleviewcontatos.model;

public class Contato {
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
