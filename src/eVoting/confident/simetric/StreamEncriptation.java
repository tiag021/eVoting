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
package security.confident.simetric;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;

/**
 * Created on 11/10/2022, 22:08:25
 *
 * @author IPT - computer
 * @version 1.0
 */
public class StreamEncriptation {

    public static void main(String[] args) throws Exception {
        write("Hello world from cypher stream", "streamCipher.txt");
        System.out.println("Secret = " + readFile("streamCipher.txt"));
    }

    /**
     * Escreve a mensagem message no ficheiro fileName e escreve a chave de
     * encriptacao no ficheiro fileName.key
     *
     * @param message mensagem a encriptar
     * @param fileName ficheiro para guardar a mensagem
     * @throws Exception
     */
    public static void write(String message, String fileName) throws Exception {
        //criar uma chave de encriptacao
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        Key key = keyGen.generateKey();
        //escrever a chave de encriptacao no ficheiro .key
        ObjectOutputStream kos = new ObjectOutputStream(new FileOutputStream(fileName + ".key"));
        kos.writeObject(key);
        //fechar a stream
        kos.close();
        //encriptar a mensagem  
        writeCrypt(message.getBytes(), new FileOutputStream(fileName), key);
    }

    /**
     * Escreve a mensagem message encriptada com uma chave simetrica numa stream
     *
     * @param message mensagem a encriptar
     * @param out stream de saida
     * @param key chave de encriptacao     
     * @throws Exception
     */
    public static void writeCrypt(byte[] message, OutputStream out, Key key) throws Exception {
        //criar a cifra
        Cipher cipher = Cipher.getInstance(key.getAlgorithm());
        //iniciar para encriptar
        cipher.init(Cipher.ENCRYPT_MODE, key);
        //criar uma stream cifrada com a cifra
        CipherOutputStream cos = new CipherOutputStream(out, cipher);
        //escrever a mensagem
        cos.write(message);
        //fechar a stream
        cos.close();
    }

    /**
     * Le a mensagem que esta escrita no ficheiro fileName Le a chave de
     * encriptacao do ficheiro fileName.key
     *
     * @param fileName nome do ficheiro encriptado
     * @return
     * @throws Exception
     */
    public static String readFile(String fileName) throws Exception {
        //stream com a chave de encriptacao
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName + ".key"));
        //ler a chave
        Key key = ((Key) ois.readObject());
        //objecto para decifrar
        return new String(readCrypt(new FileInputStream(fileName), key));
    }

    /**
     * Le a mensagem cifrada com a chave key de uma stream 
     *
     * @param in stream de entrada
     * @param key chave de cifragem
     * @return bytes do ficheiro
     * @throws Exception
     */
    public static byte[] readCrypt(InputStream in, Key key) throws Exception {
        //objecto para decifrar
        Cipher cipher = Cipher.getInstance(key.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, key);
        //abertura de uma stream cifrada
        CipherInputStream cis = new CipherInputStream(in, cipher);
        //ler os bytes da stream
        return cis.readAllBytes();
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202210112208L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2022  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
}
