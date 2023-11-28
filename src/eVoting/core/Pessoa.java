package eVoting.core;

import eVoting.blockchain.Converter;
import java.io.Serializable;

public class Pessoa implements Serializable {

    private String nome, cc, password;
    private int idade;

    public Pessoa(String nome, String cc, String password, int idade) {
        this.nome = nome;
        this.cc = cc;
        this.idade = idade;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getNome() {
        return nome;
    }

    public String getCC() {
        return cc;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCC(String cc) {
        this.cc = cc;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toText() {
        return Converter.objectToHex(this);
    }

    public static Pessoa fromText(String obj) {
        return (Pessoa) Converter.hexToObject(obj);
    }

    @Override
    public String toString() {
        //format values to english notation

        return String.format("CC: %s Nome: %s Idade: %s ", cc, nome, idade);
        //return from + "\t : " + to + "\t -> " + value;
    }

    public static long serialVersionUID = 123L;
}
