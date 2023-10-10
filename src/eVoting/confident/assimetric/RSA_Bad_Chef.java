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
//::                                                               (c)2021   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package eVoting.confident.assimetric;

import java.util.Arrays;

/**
 * Created on 16/set/2021, 10:28:30
 *
 * @author IPT - computer
 */
public class RSA_Bad_Chef {

    public static void main(String[] args) {
 
        String message = "bad chef";

        int code[] = stringToCode(message);
        System.out.println("Mensagem = " + message );
        System.out.println("Encriptar " +  Arrays.toString(code));
        for (int i = 0; i < code.length; i++) {
            System.out.print(message.charAt(i) + "[ " + code[i] + "] => ");
            //encriptar com a chave publica
            code[i] = encode(code[i], publicKey, modulus);
            System.out.println(code[i]);
        }
        
        
        System.out.println("Segredo = "+ Arrays.toString(code));
        System.out.println("Desencriptar " + Arrays.toString(code));
        for (int i = 0; i < code.length; i++) {
            System.out.print("[ " + code[i] + "] => ");
            //desencriptar com a chave privada
            code[i] = encode(code[i], privateKey, modulus);
            System.out.println(code[i] + " \t" + alphabet.charAt(code[i]));
        }
        
        
        System.out.println("Mensagem = " + codeToString(code));

    }

    public static final String alphabet = " abcdefghijklmnopqrstuvwxyz";

    public static int privateKey = 3;
    public static int publicKey = 7;
    public static int modulus = 33;

    public static int encode(int v, int key, int modulus) {
        return ((int) Math.pow(v, key)) % modulus;
    }

    public static int decrypt(int v) {
        return ((int) Math.pow(v, privateKey)) % modulus;
    }

    public static int[] stringToCode(String txt) {
        int[] code = new int[txt.length()];
        for (int i = 0; i < code.length; i++) {
            code[i] = alphabet.contains(txt.charAt(i) + "") ? alphabet.indexOf(txt.charAt(i)) : 0;
        }
        return code;
    }

    public static String codeToString(int[] code) {
        StringBuffer txt = new StringBuffer();
        for (int i = 0; i < code.length; i++) {
            txt.append(code[i] < alphabet.length() ? alphabet.charAt(code[i]) : " ");
        }
        return txt.toString();
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202109161028L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2021  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
}
