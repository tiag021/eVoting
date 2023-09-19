/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package eVoting.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import eVoting.core.eVoting;
import eVoting.core.Transaction;

/**
 *
 * @author manso
 */
public class TemplarCoinGUI extends javax.swing.JFrame {
    public static String fileTemplarCpoin = "templarCoin.obj";
    eVoting coin;
    
    /**
     * Creates new form TemplarCoinGUI
     */
    public TemplarCoinGUI() {
        initComponents();
        coin = new  eVoting();
        try {
            coin = eVoting.load(fileTemplarCpoin);
        } catch (Exception e) {
        }
        txtLeger.setText(coin.toString());
        setSize(800, 600);
        setLocationRelativeTo(null);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLeger = new javax.swing.JTextArea();
        tpTransaction = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        pnTransaction = new javax.swing.JPanel();
        txtFrom = new javax.swing.JTextField();
        txtTo = new javax.swing.JTextField();
        txtValue = new javax.swing.JTextField();
        btRegister = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pnUsersBalance = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstUsers = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Templar coin Demo");

        txtLeger.setColumns(20);
        txtLeger.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtLeger.setRows(5);
        jScrollPane1.setViewportView(txtLeger);

        jTabbedPane1.addTab("Ledger", new javax.swing.ImageIcon(getClass().getResource("/templarCoin/multimedia/blockChain.png")), jScrollPane1); // NOI18N

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        tpTransaction.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tpTransactionStateChanged(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.BorderLayout());

        pnTransaction.setLayout(new java.awt.GridLayout(4, 1, 5, 5));

        txtFrom.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtFrom.setBorder(javax.swing.BorderFactory.createTitledBorder("From"));
        pnTransaction.add(txtFrom);

        txtTo.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtTo.setBorder(javax.swing.BorderFactory.createTitledBorder("to"));
        txtTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtToActionPerformed(evt);
            }
        });
        pnTransaction.add(txtTo);

        txtValue.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtValue.setText("0.0");
        txtValue.setBorder(javax.swing.BorderFactory.createTitledBorder("Value"));
        pnTransaction.add(txtValue);

        btRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/templarCoin/multimedia/cash-icon.png"))); // NOI18N
        btRegister.setText("Register");
        btRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegisterActionPerformed(evt);
            }
        });
        pnTransaction.add(btRegister);

        jPanel1.add(pnTransaction, java.awt.BorderLayout.NORTH);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/templarCoin/multimedia/templarCoin.png"))); // NOI18N
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        tpTransaction.addTab("Transaction", new javax.swing.ImageIcon(getClass().getResource("/templarCoin/multimedia/templar.png")), jPanel1); // NOI18N

        pnUsersBalance.setLayout(new java.awt.BorderLayout());

        lstUsers.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lstUsers.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstUsers);

        pnUsersBalance.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        tpTransaction.addTab("Users Balance", new javax.swing.ImageIcon(getClass().getResource("/templarCoin/multimedia/users_ledger_24.png")), pnUsersBalance); // NOI18N

        getContentPane().add(tpTransaction, java.awt.BorderLayout.WEST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtToActionPerformed

    private void btRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegisterActionPerformed
        try {
            Transaction t = new Transaction(
                    txtFrom.getText(),
                    txtTo.getText(),
                    Double.valueOf(txtValue.getText())
            );
            
            coin.add(t);
            txtLeger.setText(coin.toString());
            coin.save(fileTemplarCpoin);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(TemplarCoinGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btRegisterActionPerformed

    private void tpTransactionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tpTransactionStateChanged
        if( tpTransaction.getSelectedComponent()== pnUsersBalance){
            DefaultListModel model = new DefaultListModel();
            model.addAll(coin.getUsers());
            lstUsers.setModel(model);
        }
    }//GEN-LAST:event_tpTransactionStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TemplarCoinGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TemplarCoinGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TemplarCoinGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TemplarCoinGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TemplarCoinGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> lstUsers;
    private javax.swing.JPanel pnTransaction;
    private javax.swing.JPanel pnUsersBalance;
    private javax.swing.JTabbedPane tpTransaction;
    private javax.swing.JTextField txtFrom;
    private javax.swing.JTextArea txtLeger;
    private javax.swing.JTextField txtTo;
    private javax.swing.JTextField txtValue;
    // End of variables declaration//GEN-END:variables
}
