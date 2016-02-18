package com.example.lucas.agenda;

import java.io.Serializable;

/**
 * Created by Lucas on 04/02/2016.
 */
public class Contato implements Serializable {

    private String nome;
    private String telefone;
    private int imagem;
    private int _id;


    public Contato() {
    }

    public Contato(String nome, String telefone, int imagem) {
        this.nome = nome;
        this.telefone = telefone;
        this.imagem = imagem;
    }

    public Contato(int _id, String nome, String telefone, int imagem) {
        this.nome = nome;
        this.telefone = telefone;
        this.imagem = imagem;
        this._id = _id;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}