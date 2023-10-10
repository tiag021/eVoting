package eVoting.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import eVoting.blockchain.Block;
import eVoting.blockchain.BlockChain;

public class eVotingEleitores implements Serializable {

    private BlockChain secureLedgerEleitores;
    public int dificulty = 4;

    public BlockChain getSecureLedgerEleitores() {
        return secureLedgerEleitores;
    }

    public eVotingEleitores() {
        secureLedgerEleitores = new BlockChain();
        Eleitor seedEleitor = new Eleitor("eleitor", "0", "0000");
        secureLedgerEleitores.add(seedEleitor.toText(), dificulty);
    }

    public List<Eleitor> getLedgerEleitores() {
        List<Eleitor> lstE = new ArrayList<>();

        for (Block b : secureLedgerEleitores.getChain()) {
            lstE.add(Eleitor.fromText(b.getData()));
        }
        return lstE;
    }

    public List<String> getEleitores() {
        List<String> listEleitores = new ArrayList<>();
        //get Users
        for (Eleitor eleitor : getLedgerEleitores()) {
            if (!listEleitores.contains(eleitor.getNomeEleitor())) {
                listEleitores.add(eleitor.getNomeEleitor());
            }
            if (!listEleitores.contains(eleitor.getNomeEleitor())) {
                listEleitores.add(eleitor.getNomeEleitor());
            }
        }
        return listEleitores;
    }

    public String toStringEleitor() {
        StringBuilder txt = new StringBuilder();
        for (Eleitor eleitor : getLedgerEleitores()) {
            txt.append(eleitor.toString()).append("\n");
        }
        return txt.toString();
    }

    public void save(String fileName) throws Exception {
        secureLedgerEleitores.save(fileName);
    }

    public static eVotingEleitores load(String fileName) throws Exception {
        eVotingEleitores tmp = new eVotingEleitores();
        tmp.secureLedgerEleitores.load(fileName);
        return tmp;
    }

    public boolean idEleitorValido(Eleitor e) throws Exception {
        return true;
    }

    public void addEleitor(Eleitor e) throws Exception {
        if (idEleitorValido(e)) {
            secureLedgerEleitores.add(e.toText(), dificulty);
        } else {
            throw new Exception("Eleitor inválido");
        }
    }

    public static long serialVersionUID = 123;

}
