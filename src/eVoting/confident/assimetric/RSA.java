/** ****************************************************************************
 * Adapted by (M@nso 2021
 * source :  https://introcs.cs.princeton.edu/java/99crypto/RSA.java.html
 *
 *
 *  Compilation:  javac RSA.java
 *  Execution:    java RSA N
 *
 *  Generate an N-bit public and private RSA key and use to encrypt
 *  and decrypt a random message.
 *
 *  % java RSA 50
 *  public  = 65537
 *  private = 553699199426609
 *  modulus = 825641896390631
 *  message   = 48194775244950
 *  encrpyted = 321340212160104
 *  decrypted = 48194775244950
 *
 *  Known bugs (not addressed for simplicity)
 *  -----------------------------------------
 *  - It could be the case that the message >= modulus. To avoid, use
 *    a do-while loop to generate key until modulus happen to be exactly N bits.
 *
 *  - It's possible that gcd(phi, publicKey) != 1 in which case
 *    the key generation fails. This will only happen if phi is a
 *    multiple of 65537. To avoid, use a do-while loop to generate
 *    keys until the gcd is 1.
 *
 ***************************************************************************** */
//https://crypto.stackexchange.com/questions/3110/impacts-of-not-using-rsa-exponent-of-65537
//public key != 65537  would reduce compatibility with existing hardware or software, and break conformance to some standards or prescriptions of security authorities
package eVoting.confident.assimetric;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {

    private final static BigInteger one = new BigInteger("1");
    private final static SecureRandom random = new SecureRandom();

    private final BigInteger privateKey;
    private final BigInteger publicKey;
    private final BigInteger modulus;

    public RSA(int N) {// generate an N-bit (roughly) public and private key
        //gerar dois numeros primos grandes
        BigInteger p = BigInteger.probablePrime(N / 2, random);
        BigInteger q = BigInteger.probablePrime(N / 2, random);
        //MODULO
        modulus = p.multiply(q);
        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
        //CHAVE PUBLICA - numero primo aleatório pequeno       
        publicKey = BigInteger.valueOf(65537);
        //CHAVE PRIVADA   
        privateKey = publicKey.modInverse(phi);
    }

    /**
     * Chave privada
     *
     * @return [moudulo , privada]
     */
    public BigInteger[] getPrivateKey() {
        return new BigInteger[]{modulus, privateKey};
    }

    /**
     * Chave publica
     *
     * @return [moudulo , publica]
     */
    public BigInteger[] getPublicKey() {
        return new BigInteger[]{modulus, publicKey};
    }

    /**
     * codifica uma valor através de uma chave rsa
     *
     * @param value valor para codificação
     * @param key vetor [ modulo , chave ]
     * @return value ^ chave % moudlo
     */
    public static BigInteger encode(BigInteger value, BigInteger[] key) {
        return value.modPow(key[1], key[0]);
    }

    @Override
    public String toString() {
        String s = "";
        s += "public key  = (" + modulus + " , " + publicKey + ")\n";
        s += "private key = (" + modulus + " , " + privateKey;
        return s;
    }

    public static void main(String[] args) {
        RSA rsa = new RSA(300); // chave com 300 bits
        System.out.println(rsa);
        String message = "Hello RSA World"; // mensagem a encriptar
        BigInteger code = new BigInteger(message.getBytes());// valor
        System.out.println("message   \t= " + message);
        System.out.println("code \t\t= " + code);
        //encriptar e desencriptar
        BigInteger encrypt = rsa.encode(code, rsa.getPublicKey());
        BigInteger decrypt = rsa.encode(encrypt, rsa.getPrivateKey());

        System.out.println("encrypted \t= " + encrypt);
        System.out.println("decrypted \t= " + decrypt);
        System.out.println("message   \t= " + new String(decrypt.toByteArray()));
    }
}
