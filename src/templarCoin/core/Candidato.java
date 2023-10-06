/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package templarCoin.core;

import java.io.Serializable;
import templarCoin.blockchain.Converter;

public class Candidato extends Pessoa implements Serializable {

    private String idCandidato;
    

    public Candidato(String nome, String idade, String idCandidato) {
        super(nome, idade);
        this.idCandidato = idCandidato;
    }

    public String getIdCandidato() {
        return idCandidato;
    }
    
    public String getNomeCandidato() {
        return nome;
    }
    
    @Override
    public String toString() {
        //format values to english notation

        return String.format("ID: %-5s Nome: %-15s Idade: %-3s", idCandidato, nome, idade);
        //return from + "\t : " + to + "\t -> " + value;
    }

    public void setIdCandidato(String idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String toText() {
        return Converter.objectToHex(this);
    }

    public static Candidato fromText(String obj) {
        return (Candidato) Converter.hexToObject(obj);
    }

    public static long serialVersionUID = 123;

}
