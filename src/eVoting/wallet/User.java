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
//::                                                               (c)2023   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package eVoting.wallet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;
import eVoting.core.Voto;
import eVoting.utils.SecurityUtils;

/**
 * Created on 29/09/2023, 17:23:07
 *
 * @author manso - computer
 */
public class User {

    private String name;
    private PublicKey pubKey;
    private PrivateKey privKey;    
    private List<Voto> transactions;

    public User(String name) throws Exception {
        this.name = name;        
        KeyPair kp = SecurityUtils.generateRSAKeyPair();
        privKey = kp.getPrivate();
        pubKey = kp.getPublic();
        transactions = new ArrayList<>();
    }

    public User(String name, PublicKey pubKey, PrivateKey privKey,List<Voto> transactions) {
        this.name = name;
        this.pubKey = pubKey;
        this.privKey = privKey;       
        this.transactions = transactions;
    }

    public void addTransaction(Voto t) throws Exception {
        Files.write(Path.of(getUserFileName(t.getTo())), (t.toText() + "\n").getBytes(), StandardOpenOption.APPEND);
        Files.write(Path.of(getUserFileName(t.getFrom())), (t.toText() + "\n").getBytes(), StandardOpenOption.APPEND);
        transactions.add(t);
    }

    @Override
    public String toString() {
        String pub = Base64.getEncoder().encodeToString(pubKey.getEncoded());
        String priv = privKey != null ? Base64.getEncoder().encodeToString(privKey.getEncoded()) : "unknow";        
        String txt = "Name\t: " + name
                + "\nPub\t: " + pub
                + "\nPrv\t: " + priv
                + "\nTransactions \n";
        for (Voto transaction : transactions) {
            txt += transaction.toString() + "\n";
        }
        return txt;

    }

    public static String getUserFileName(String name) throws Exception {
        return name + ".user";
    }

    public void save(String password) throws Exception {
        String fileName = getUserFileName(name);
        PrintStream out = new PrintStream(new FileOutputStream(fileName));
        out.println(name);
        out.println(Base64.getEncoder().encodeToString(pubKey.getEncoded()));
        out.println(Base64.getEncoder().encodeToString(SecurityUtils.encrypt(privKey.getEncoded(), password)));       
        for (Voto transaction : transactions) {
            out.println(transaction.toText());
        }
        out.close();
    }

    public static User loadUser(String... params) throws Exception {
        params[0] = getUserFileName(params[0]);
        return load(params);
    }

    /**
     * loads an user from filename
     *
     * @param params array of parameters
     * <br>params[0] - filename (mandatory)
     * <br>params[1] - password (optional)
     *
     * @return User
     * @throws Exception
     */
    private static User load(String... params) throws Exception {
        Scanner file = new Scanner(new FileInputStream(params[0]));
        String name = file.nextLine();
        String pub = file.nextLine();
        String priv = file.nextLine();        

        PublicKey pubKey = SecurityUtils.getPublicKey(Base64.getDecoder().decode(pub));
        PrivateKey privKey = null;        
        List<Voto> transactions = new ArrayList<>();
        //try to load keys 
        try {
            privKey = SecurityUtils.getPrivateKey(SecurityUtils.decrypt(Base64.getDecoder().decode(priv), params[1]));            
            while (file.hasNext()) {
                transactions.add(Voto.fromText(file.nextLine()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new User(name,
                SecurityUtils.getPublicKey(Base64.getDecoder().decode(pub)),
                privKey, transactions);
    }

 

    public String getName() {
        return name;
    }

    public PublicKey getPubKey() {
        return pubKey;
    }

    public PrivateKey getPrivKey() {
        return privKey;
    } 

    public List<Voto> getTransactions() {
        return transactions;
    }

}
