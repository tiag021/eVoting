/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eVoting.test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import eVoting.core.TemplarCoin;
import eVoting.core.Transaction;

/**
 *
 * @author manso
 */
public class TestTemplarCoin {
    public static void main(String[] args) {
        try {
            //TemplarCoin coin  = new TemplarCoin();
            
            TemplarCoin coin  = TemplarCoin.load("tc.obj");
          
            System.out.println("System : " + coin.getAmount("System"));
            System.out.println("Master : " + coin.getAmount("Master"));
            
            coin.add(new Transaction("Maria", "João", 5));
            System.out.println(coin);            
            coin.save("tc.obj");
            
        } catch (Exception ex) {
            Logger.getLogger(TestTemplarCoin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
