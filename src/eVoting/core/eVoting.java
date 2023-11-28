package eVoting.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import eVoting.blockchain.Block;
import eVoting.blockchain.BlockChain;

public class eVoting implements Serializable {

    private BlockChain secureLedgerVoto;
    public int dificulty = 4;

    public BlockChain getSecureLedgerVoto() {
        return secureLedgerVoto;
    }

    public eVoting() {
        secureLedgerVoto = new BlockChain();
    }

    public List<Voto> getLedgerVotou() {
        List<Voto> lst = new ArrayList<>();

        for (Block a : secureLedgerVoto.getChain()) {
            lst.add(Voto.fromText(a.getData()));
        }
        return lst;
    }

    public List<String> getVotos() {
        List<String> listaVotos = new ArrayList<>();
        //get Users
        for (Voto votou : getLedgerVotou()) {
            if (!listaVotos.contains(votou.getFrom())) {
                listaVotos.add(votou.getFrom());
            }
        }
        return listaVotos;
    }

    public boolean jaVotou(Pessoa p) {
        return getVotos().contains(p.getCC());
    }

    public String toStringVoto() {
        StringBuilder txt = new StringBuilder();
        for (Voto voto : getLedgerVotou()) {
            txt.append(voto.toString()).append("\n");
        }
        return txt.toString();
    }

    public void save(String fileName) throws Exception {
        secureLedgerVoto.save(fileName);
    }

    public static eVoting load(String fileName) {
        eVoting tmp = new eVoting();
        if (tmp.secureLedgerVoto.load(fileName)) {
            return tmp;
        }
        return null;
    }

    public boolean isValid(Voto v) throws Exception {
        if (!getVotos().contains(v.getFrom())) {
            return true;
        }
        return false;
    }

    public void addVoto(Voto v) throws Exception {
        if (isValid(v)) {
            secureLedgerVoto.add(v.toText(), dificulty);
        } else {
            throw new Exception("Voto inválido");
        }
    }

    public static long serialVersionUID = 123L;

}
