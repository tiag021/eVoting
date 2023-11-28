package eVoting.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import eVoting.blockchain.Block;
import eVoting.blockchain.BlockChain;
import java.util.logging.Level;
import java.util.logging.Logger;

public class eVotingPartidos implements Serializable {

    private BlockChain secureLedgerPartidos;
    public int dificulty = 4;

    public BlockChain getSecureLedgerPartidos() {
        return secureLedgerPartidos;
    }

    public eVotingPartidos() {
        secureLedgerPartidos = new BlockChain();
    }

    public List<Partido> getLedgerPartido() {
        List<Partido> lstC = new ArrayList<>();

        for (Block b : secureLedgerPartidos.getChain()) {
            lstC.add(Partido.fromText(b.getData()));
        }
        return lstC;
    }

    public List<String> getPartidos() {
        List<String> listPartidos = new ArrayList<>();
        //get Users
        for (Partido partido : getLedgerPartido()) {
            if (!listPartidos.contains(partido.getNome())) {
                listPartidos.add(partido.getNome());
            }
        }
        return listPartidos;
    }

    public String toStringPartido() {
        StringBuilder txt = new StringBuilder();
        for (Partido partido : getLedgerPartido()) {
            txt.append(partido.toString()).append("\n");
        }
        return txt.toString();
    }

    public void save(String fileName) throws Exception {
        secureLedgerPartidos.save(fileName);
    }

    public static eVotingPartidos load(String fileName) {
        eVotingPartidos tmp = new eVotingPartidos();
        if (tmp.secureLedgerPartidos.load(fileName)) {
            return tmp;
        }
        return null;
    }

    public boolean isPartidoValido(Partido c) throws Exception {
        return true;
    }

    public void addPartido(Partido c) throws Exception {
        if (isPartidoValido(c)) {
            secureLedgerPartidos.add(c.toText(), dificulty);
        } else {
            throw new Exception("Partido inválido");
        }
    }

    public static long serialVersionUID = 123L;

}
