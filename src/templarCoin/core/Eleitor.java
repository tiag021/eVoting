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
public class Eleitor extends Pessoa implements Serializable {

    private String idEleitor;
    List<String> eleitores = new ArrayList<>();
    private BlockChain secureLedger;

    public Eleitor(String nome, int idade, String idEleitor) {
        super(nome, idade);
        this.idEleitor = idEleitor;
    }

    public String getIdEleitor() {
        return idEleitor;
    }

    public void setIdEleitor(String idEleitor) {
        this.idEleitor = idEleitor;
    }

    public void addEleitorLista() {
        eleitores.add(nome);
    }

    public List<String> getEleitores() {
        return eleitores;
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

    public static Eleitor fromText(String obj) {
        return (Eleitor) Converter.hexToObject(obj);
    }

    public static long serialVersionUID = 12345;
}
