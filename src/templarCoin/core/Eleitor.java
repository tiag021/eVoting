
package templarCoin.core;

/**
 *
 * @author almei
 */
public class Eleitor extends Pessoa{
    private String idEleitor;
    
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
    
}
