package templarCoin.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import templarCoin.blockchain.Block;
import templarCoin.blockchain.BlockChain;

public class eVotingCandidatos implements Serializable {

    private BlockChain secureLedgerCandidatos;
    public int dificulty = 4;

    public BlockChain getSecureLedgerCandidatos() {
        return secureLedgerCandidatos;
    }

    public eVotingCandidatos() {
        secureLedgerCandidatos = new BlockChain();
        Candidato seedCandidato = new Candidato("candidato", "0", "0000");
        secureLedgerCandidatos.add(seedCandidato.toText(), dificulty);
    }

    public List<Candidato> getLedgerCandidato() {
        List<Candidato> lstC = new ArrayList<>();

        for (Block b : secureLedgerCandidatos.getChain()) {
            lstC.add(Candidato.fromText(b.getData()));
        }
        return lstC;
    }

    public List<String> getCandidatos() {
        List<String> listCandidatos = new ArrayList<>();
        //get Users
        for (Candidato candidato : getLedgerCandidato()) {
            if (!listCandidatos.contains(candidato.getNomeCandidato())) {
                listCandidatos.add(candidato.getNomeCandidato());
            }
            if (!listCandidatos.contains(candidato.getNomeCandidato())) {
                listCandidatos.add(candidato.getNomeCandidato());
            }
        }
        return listCandidatos;
    }

    public String toStringCandidato() {
        StringBuilder txt = new StringBuilder();
        for (Candidato transaction : getLedgerCandidato()) {
            txt.append(transaction.toString()).append("\n");
        }
        return txt.toString();
    }

    public void save(String fileName) throws Exception {
        secureLedgerCandidatos.save(fileName);
    }

    public static eVotingCandidatos load(String fileName) throws Exception {
        eVotingCandidatos tmp = new eVotingCandidatos();
        tmp.secureLedgerCandidatos.load(fileName);
        return tmp;
    }

    public boolean isCandidatoValido(Candidato c) throws Exception {
        return true;
    }

    public void addCandidato(Candidato c) throws Exception {
        if (isCandidatoValido(c)) {
            secureLedgerCandidatos.add(c.toText(), dificulty);
        } else {
            throw new Exception("Candidato inválido");
        }
    }

    public static long serialVersionUID = 123;

}
