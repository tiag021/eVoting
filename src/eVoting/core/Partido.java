package eVoting.core;

import eVoting.blockchain.Converter;
import java.io.Serializable;

public class Partido implements Serializable {

    private String nome;

    public Partido(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toText() {
        return Converter.objectToHex(this);
    }

    public static Partido fromText(String obj) {
        return (Partido) Converter.hexToObject(obj);
    }

    @Override
    public String toString() {
        //format values to english notation

        return String.format("Nome: %s", nome);
    }

    public static long serialVersionUID = 123L;
}
