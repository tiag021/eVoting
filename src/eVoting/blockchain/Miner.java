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
package eVoting.blockchain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on 28/09/2022, 11:13:39
 *
 * @author IPT - computer
 * @version 1.0
 */
public class Miner {

    //maximum number of Nonce
    public static int MAX_NONCE = (int) 1E9;

    public static int getNonce(String data, int dificulty) {
        //String of zeros
        String zeros = String.format("%0" + dificulty + "d", 0);
        //starting nonce
        int nonce = 0;
        while (nonce < MAX_NONCE) {
            //calculate hash of block
            String hash = getHash(nonce + data);
            //Nounce found
            if (hash.startsWith(zeros)) {
                return nonce;
            }
            //next nounce
            nonce++;
        }
        return nonce;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    //:::::::::      I N T E G R I T Y         :::::::::::::::::::::::::::::::::    
    ///////////////////////////////////////////////////////////////////////////
    public static String getHash(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(data.getBytes());
            return Base64.getEncoder().encodeToString(md.digest());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Miner.class.getName()).log(Level.SEVERE, null, ex);
            return data;
        }
    }
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 123L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2022  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
}
