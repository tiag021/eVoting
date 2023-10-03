//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//::                                                                         ::
//::     Antonio Manuel Rodrigues Manso                                      ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::     e-mail: manso@ipt.pt                                                ::
//::     url   : http://orion.ipt.pt/~manso                                  ::
//::                                                                         ::
//::     This software was build with the purpose of investigate and         ::
//::     learning.                                                           ::
//::                                                                         ::
//::                                                               (c)2020   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package templarCoin.core;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import templarCoin.blockchain.Block;
import templarCoin.blockchain.BlockChain;

/**
 *
 * @author manso
 */
public class TemplarCoin implements Serializable {

    private List<Voto> ledgerVoto;
    private List<Candidato> ledgerCandidato;
    private List<Eleitor> ledgerEleitor;

    private BlockChain secureLedger;
    public int dificulty = 4;

    public BlockChain getSecureLedger() {
        return secureLedger;
    }

    public TemplarCoin() {
        secureLedger = new BlockChain();
        Voto seed = new Voto("system", "master");
        secureLedger.add(seed.toText(), dificulty);
    }

    public List<Voto> getLedgerVoto() {
        List<Voto> lst = new ArrayList<>();

        for (Block b : secureLedger.getChain()) {
            lst.add(Voto.fromText(b.getData()));
        }
        return lst;
    }
    
    public List<Candidato> getLedgerCandidato() {
        List<Candidato> lstC = new ArrayList<>();

        for (Block b : secureLedger.getChain()) {
            lstC.add(Candidato.fromText(b.getData()));
        }
        return lstC;
    }
    
    public List<Eleitor> getLedgerEleitor() {
        List<Eleitor> lstE = new ArrayList<>();

        for (Block b : secureLedger.getChain()) {
            lstE.add(Eleitor.fromText(b.getData()));
        }
        return lstE;
    }

    public String toStringVoto() {
        StringBuilder txt = new StringBuilder();
        for (Object transaction : getLedgerVoto()) {
            txt.append(transaction.toString()).append("\n");
        }
        return txt.toString();
    }
    
    public String toStringEleitor() {
        StringBuilder txt = new StringBuilder();
        for (Object transaction : getLedgerEleitor()) {
            txt.append(transaction.toString()).append("\n");
        }
        return txt.toString();
    }
    
    public String toStringCandidato() {
        StringBuilder txt = new StringBuilder();
        for (Object transaction : getLedgerCandidato()) {
            txt.append(transaction.toString()).append("\n");
        }
        return txt.toString();
    }

    public void save(String fileName) throws Exception {
        secureLedger.save(fileName);
        try (PrintStream out = new PrintStream(
                new FileOutputStream(fileName))) {
            out.print(this.toString());
        }
    }

    public static TemplarCoin load(String fileName) throws Exception {
        TemplarCoin tmp = new TemplarCoin();
        tmp.secureLedger.load(fileName);
        return tmp;
    }

    public boolean isValid(Voto t) throws Exception {
        return true;
    }

    public boolean isCandidatoValido(Candidato c) throws Exception {
        return true;
    }

    public boolean idEleitorValido(Eleitor e) throws Exception {
        return true;
    }

    public void addVoto(Voto v) throws Exception {
        if (isValid(v)) {
            secureLedger.add(v.toText(), dificulty);
        } else {
            throw new Exception("Transaction not valid");
        }
    }

    public void addCandidato(Candidato c) throws Exception {
        if (isCandidatoValido(c)) {
            secureLedger.add(c.toText(), dificulty);
        } else {
            throw new Exception("Candidato inválido");
        }
    }

    public void addEleitor(Eleitor e) throws Exception {
        if (idEleitorValido(e)) {
            secureLedger.add(e.toText(), dificulty);
        } else {
            throw new Exception("Eleitor inválido");
        }
    }

    public static long serialVersionUID = 123;

}
