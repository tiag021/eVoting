
package templarCoin.core;

/**
 *
 * @author almei
 */
public class Eleitor extends Pessoa{
    private String partido;
    
    public Eleitor(String nome, int idade, String partido) {
        super(nome, idade);
        this.partido = partido;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }
    
}
