package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Usuario {

    @Id
    private String _id;
    private String nome;
    private String sobrenome;
    private String username;
    private String senha;
    private String tipo;
    private Veiculo veiculo;
    private Contato contato;


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
                "_id='" + _id + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", username='" + username + '\'' +
                ", senha='" + senha + '\'' +
                ", tipo='" + tipo + '\'' +
                ", veiculo=" + veiculo +
                ", contato=" + contato +
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    /*{
        "nome":"teste",
            "sobrenome":"sobreteste",
            "username":"testeBR",
            "senha":"testedosteste",
            "tipo":"motorista",
            "veiculo" : {
        "marca":"fiat",
                "modelo":"uno",
                "ano":"1996",
                "placa":"BRL 1616",
                "detalhes":"tunadão"
    } ,
        "contato" : {
        "email":"teste@teste.com",
                "telefones":[
        154685498
        ]
    }
    }*/
}
