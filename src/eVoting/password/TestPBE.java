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
package eVoting.password;

import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author doctmanso
 */
public class TestPBE {

    public static void main(String[] args) {
        try {
            String password = "sherlock Holmes";
            String msg = "Hello World";
            System.out.println("MSG \t= " + msg);
            
            byte[] secret = PBE.encrypt(msg.getBytes(), password);            
            System.out.println("SECRET \t= " + Base64.getEncoder().encodeToString(secret));
  
            byte[] plain = PBE.decrypt(secret, password );
            System.out.println("MSG \t= " + new String(plain));
            
        } catch (Exception ex) {
            Logger.getLogger(TestPBE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
