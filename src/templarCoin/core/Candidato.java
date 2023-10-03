/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package templarCoin.core;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import templarCoin.blockchain.BlockChain;
import templarCoin.blockchain.Converter;

/**
 *
 * @author almei
 */
public class Candidato extends Pessoa implements Serializable {

    private String idCandidato;
    List<String> candidatos = new ArrayList<>();
    private BlockChain secureLedger;

    public Candidato(String nome, int idade, String idCandidato) {
        super(nome, idade);
        this.idCandidato = idCandidato;
    }

    public String getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(String idCandidato) {
        this.idCandidato = idCandidato;
    }

    public void addCandidatoLista() {
        candidatos.add(nome);
    }

    public List<String> getCandidatos() {
        return candidatos;
    }

    public String toText() {
        return Converter.objectToHex(this);
    }

    public void save(String fileName) throws Exception {
        secureLedger.save(fileName);
        try (PrintStream out = new PrintStream(
                new FileOutputStream(fileName))) {
            out.print(this.toString());
        }
    }

    public static Candidato fromText(String obj) {
        return (Candidato) Converter.hexToObject(obj);
    }

    public static long serialVersionUID = 1234;

}
