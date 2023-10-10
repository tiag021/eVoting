package eVoting.core;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import eVoting.blockchain.Block;
import eVoting.blockchain.BlockChain;

public class eVoting implements Serializable {

    private BlockChain secureLedgerVotos;
    public int dificulty = 4;

    public BlockChain getSecureLedgerVotos() {
        return secureLedgerVotos;
    }

    public eVoting() {
        secureLedgerVotos = new BlockChain();
        Voto seed = new Voto("system", "master");
        secureLedgerVotos.add(seed.toText(), dificulty);
    }

    public List<Voto> getLedgerVoto() {
        List<Voto> lst = new ArrayList<>();

        for (Block a : secureLedgerVotos.getChain()) {
            lst.add(Voto.fromText(a.getData()));
        }
        return lst;
    }

    public List<String> getVotos() {
        List<String> listaVotos = new ArrayList<>();
        //get Users
        for (Voto voto : getLedgerVoto()) {
            if (!listaVotos.contains(voto.getFrom())) {
                listaVotos.add(voto.getFrom());
            }
            if (!listaVotos.contains(voto.getTo())) {
                listaVotos.add(voto.getTo());
            }
        }
        return listaVotos;
    }

    public String toStringVoto() {
        StringBuilder txt = new StringBuilder();
        for (Voto voto : getLedgerVoto()) {
            txt.append(voto.toString()).append("\n");
        }
        return txt.toString();
    }

    public void save(String fileName) throws Exception {
        secureLedgerVotos.save(fileName);
    }

    public static eVoting load(String fileName) throws Exception {
        eVoting tmp = new eVoting();
        tmp.secureLedgerVotos.load(fileName);
        return tmp;
    }

    public boolean isValid(Voto t) throws Exception {
        return true;
    }

    public void addVoto(Voto v) throws Exception {
        if (isValid(v)) {
            secureLedgerVotos.add(v.toText(), dificulty);
        } else {
            throw new Exception("Transaction not valid");
        }
    }

    public static long serialVersionUID = 123;

}
