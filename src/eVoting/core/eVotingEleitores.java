package eVoting.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import eVoting.blockchain.Block;
import eVoting.blockchain.BlockChain;

public class eVotingEleitores implements Serializable {

    private final BlockChain secureLedgerEleitores;
    public int dificulty = 4;

    public BlockChain getSecureLedgerEleitores() {
        return secureLedgerEleitores;
    }

    public eVotingEleitores() {
        secureLedgerEleitores = new BlockChain();
    }

    //retorna a ledger de eleitores
    public List<Pessoa> getLedgerEleitores() {
        List<Pessoa> lstE = new ArrayList<>();

        for (Block b : secureLedgerEleitores.getChain()) {
            lstE.add(Pessoa.fromText(b.getData()));
        }
        return lstE;
    }

    //retorna uma lista de eleitores baseada na ledger
    public List<String> getEleitores() {
        List<String> listEleitores = new ArrayList<>();

        for (Pessoa eleitor : getLedgerEleitores()) {
            if (!listEleitores.contains(eleitor.getNome())) {
                listEleitores.add(eleitor.getNome());
            }
        }
        return listEleitores;
    }

    //retorna uma pessoa baseada no cc
    public Pessoa getEleitor(String cc) {
        for (Pessoa eleitor : getLedgerEleitores()) {
            if (eleitor.getCC().equals(cc)) {
                return eleitor;
            }
        }
        return null;
    }

    //verifica se o utilizador existe através do CC
    public boolean eleitorExists(String cc) {
        boolean exists = false;
        //get Users
        for (Pessoa eleitor : getLedgerEleitores()) {
            if (eleitor.getCC().equals(cc)) {
                exists = true;
            }
        }
        return exists;
    }

    //obtém a password encriptada comparando o CC inserido com o da ledger
    public String getPasswordEncriptada(String cc) {
        String passwordVerificada = new String();
        //get Users
        for (Pessoa eleitor : getLedgerEleitores()) {
            if (cc.equals(eleitor.getCC())) {
                passwordVerificada = eleitor.getPassword();
                return passwordVerificada;
            }
        }
        return null;
    }

    //converte objeto para string e escreve na ledger dos eleitores
    public String toStringEleitor() {
        StringBuilder txt = new StringBuilder();
        for (Pessoa eleitor : getLedgerEleitores()) {
            txt.append(eleitor.toString()).append("\n");
        }
        return txt.toString();
    }

    public void save(String fileName) throws Exception {
        secureLedgerEleitores.save(fileName);
    }

    public static eVotingEleitores load(String fileName) {
        eVotingEleitores tmp = new eVotingEleitores();
        if (tmp.secureLedgerEleitores.load(fileName)) {
            return tmp;
        }
        return null;
    }

    public boolean isPessoaValida(Pessoa p) throws Exception {
        //em falta
        return true;
    }

    public void addEleitor(Pessoa p) throws Exception {
        if (isPessoaValida(p)) {
            secureLedgerEleitores.add(p.toText(), dificulty);
        } else {
            throw new Exception("Eleitor inválido");
        }
    }

    public static long serialVersionUID = 123L;

}
