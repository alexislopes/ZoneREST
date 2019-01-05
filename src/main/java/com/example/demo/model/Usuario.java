package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Usuario {
    @Id
    private String _id;
    private String nome;
    private String sobrenome;

    public Usuario() {
    }

    public Usuario(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Usuario(String _id, String nome, String sobrenome) {
        this._id = _id;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "_id=" + _id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                '}';
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
