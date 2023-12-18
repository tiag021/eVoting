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

import java.math.BigInteger;
import java.security.spec.KeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author doctmanso
 */
public class PBE {

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    //:::::::::::        PASSWORD BASED ENCRYPTATION                 :::::::::::
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    /**
     * Cria um objecto de cifragem com password
     *
     * @param mode Cipher.DECRYPT_MODE ou Cipher.ENCRYPT_MODE
     * @param password password de da cifra
     * @return Objecto de cifragem
     * @throws Exception
     */
    public static Cipher createCipherPBE(int mode, String password) throws Exception {
        //sal da chave - deve ser aleatório e diferente para cada mensagem
        byte[] salt = password.getBytes();
        //inicializar o gerador aleatorio
        Random rnd = new Random(new BigInteger(salt).longValue());
        rnd.nextBytes(salt); // gerar sal aleatorio
        //fazer iteracoes com a password
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256);
        //Criar a chave da cifra
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");       
        //Gerar uma chave secreta
        SecretKey key = factory.generateSecret(spec);
        //Gerar uma chave AES
        SecretKeySpec secretKey = new SecretKeySpec(key.getEncoded(), "AES");
        //criar Objecto de cifragem
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        //Vetor de inicializacao
        byte[] iv = new byte[16];
        rnd.nextBytes(iv); // aleatorizar o vetor
        IvParameterSpec ivspec = new IvParameterSpec(iv);
        //inicializar o objeto de cifragem
        cipher.init(mode, secretKey, ivspec);
        //retornar o Objecto de cifragem
        return cipher;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    //:::::::::::               ENCRYPT /  DECRYPT                   :::::::::::
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    /**
     * encripta dados usando uma password de texto
     *
     * @param data dados para encriptar
     * @param password password de encriptação
     * @return dados encriptados
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, String password) throws Exception {
        //criar um objecto de cifragem da chave
        Cipher cipher = createCipherPBE(Cipher.ENCRYPT_MODE, password);
        //cifrar os dados
        return cipher.doFinal(data);
    }

    /**
     * desencripta dados usando uma password de texto
     *
     * @param data dados para desencriptar
     * @param password password de desencriptação
     * @return dados desencriptados
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, String password) throws Exception {
        //criar um objecto de cifragem da chave
        Cipher cipher = createCipherPBE(Cipher.DECRYPT_MODE, password);
        //cifrar os dados
        return cipher.doFinal(data);
    }

}
