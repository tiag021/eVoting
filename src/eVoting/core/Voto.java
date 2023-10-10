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
//::                                                               (c)2022   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package eVoting.core;

import java.io.Serializable;
import eVoting.blockchain.Converter;

/**
 *
 * @author manso
 */
public class Voto implements Serializable {

    private String from;
    private String to;

    public Voto(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        //format values to english notation

        return String.format("%-10s -> %20s", from, to);
        //return from + "\t : " + to + "\t -> " + value;
    }

    public static Voto fromString(String txt) throws Exception {
        String[] elem = txt.split(" -> ");
        return new Voto(elem[0].trim(), elem[2].trim());
    }
    
    public String toText(){
       return Converter.objectToHex(this);
    }
    
    public static Voto fromText(String obj){
       return (Voto) Converter.hexToObject(obj);
    }
    
    public static long serialVersionUID = 123;

}
