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
package eVoting.confident.assimetric;

import security.confident.simetric.Simetric;
import java.security.KeyPair;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author doctmanso
 */
public class TestAsymmetric {

//            Simetric.saveKey(keys.getPrivate(), "k1Priv.key");
//            Simetric.saveKey(keys.getPublic(), "k1Pub.key");
//            
//            Key k2 = Asimetric.loadPublicKey("k1Pub.key");
//            Key k1 = Asimetric.loadPrivateKey("k1Priv.key");
    public static void main(String[] args) {
        try {

            String msg = "Hello Asymmetric World";

            System.out.println("MENSAGEM = " + msg);

            KeyPair keys = Asymmetric.generateKeyPair(512);

            byte[] secret = Simetric.encrypt(msg.getBytes(), keys.getPrivate());
            System.out.println("SEGREDO : " + Base64.getEncoder().encodeToString(secret));

            byte[] plain = Simetric.decrypt(secret, keys.getPublic());

            System.out.println("ORIGINAL = " + new String(plain));

        } catch (Exception ex) {
            Logger.getLogger(TestAsymmetric.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
