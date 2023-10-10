package eVoting.core;

import java.io.Serializable;
import eVoting.blockchain.Converter;

/**
 *
 * @author almei
 */
public class Eleitor extends Pessoa implements Serializable {

    private String idEleitor;

    public Eleitor(String nome, String idade, String idEleitor) {
        super(nome, idade);
        this.idEleitor = idEleitor;
    }

    public String getIdEleitor() {
        return idEleitor;
    }

    public String getNomeEleitor() {
        return nome;
    }

    public void setIdEleitor(String idEleitor) {
        this.idEleitor = idEleitor;
    }

    public String toText() {
        return Converter.objectToHex(this);
    }

    public static Eleitor fromText(String obj) {
        return (Eleitor) Converter.hexToObject(obj);
    }

    @Override
    public String toString() {
        //format values to english notation

        return String.format("ID: %-5s Nome: %-15s Idade: %-3s", idEleitor, nome, idade);
        //return from + "\t : " + to + "\t -> " + value;
    }

    public static long serialVersionUID = 123;
}
