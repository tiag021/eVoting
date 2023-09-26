/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package templarCoin.test;

import templarCoin.core.Transaction;

/**
 *
 * @author manso
 */
public class TestTtransaction {
    
    public static void main(String[] args) {
        Transaction t = new Transaction("System", "Master", 100);
        System.out.println(t);
    }
    
}
