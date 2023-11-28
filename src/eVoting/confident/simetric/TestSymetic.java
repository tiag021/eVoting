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
package eVoting.confident.simetric;

import java.security.Key;
import java.security.Security;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import security.confident.simetric.Simetric;

/**
 *
 * @author doctmanso
 */
public class TestSymetic {

    public static void main(String[] args) {
        //::::::::::::::::::    B O U N C Y    C A S T L E    ::::::::::::::::::
        Security.addProvider(new BouncyCastleProvider());
        try {
            Simetric.listAlgorithms();

            System.out.println("\nCRIPTOGRAFIA\n");
            String message = "hello secret world";
            System.out.println("Mensagem : " + message);

            String algorithm = "AES";

            //Key k = Simetric.generateKey(algorithm);  // SUN
            Key k = Simetric.generateKey(algorithm, "BC"); // Bouncy Castle

            Simetric.saveKey(k, "aes.txt");

            k = Simetric.loadKey("aes.txt", algorithm);

            byte secret[] = Simetric.encrypt(message.getBytes(), k);

            System.out.println("Segredo : " + Base64.getEncoder().encodeToString(secret));
            byte[] plain = Simetric.decrypt(secret, k);
            System.out.println("Original: " + new String(plain));

        } catch (Exception ex) {
            Logger.getLogger(TestSymetic.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
