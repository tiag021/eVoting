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
package templarCoin.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import templarCoin.core.TemplarCoin;
import templarCoin.core.Transaction;

/**
 *
 * @author manso
 */
public class TemplarCoinGUI extends javax.swing.JFrame {
    public static String fileTemplarCpoin = "templarCoin.obj";
    TemplarCoin coin;
    
    /**
     * Creates new form TemplarCoinGUI
     */
    public TemplarCoinGUI() {
        initComponents();
        coin = new  TemplarCoin();
        try {
            coin = TemplarCoin.load(fileTemplarCpoin);
        } catch (Exception e) {
        }
        txtLeger.setText(coin.toString());
        txtBlochains.setText(coin.getSecureLedger().toString());
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
        jScrollPane3 = new javax.swing.JScrollPane();
        txtBlochains = new javax.swing.JTextArea();
        tpTransaction = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        pnTransaction = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        txtValue = new javax.swing.JTextField();
        btRegister = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pnUsersBalance = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstUsers = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        tpTransaction1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        pnTransaction1 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        txtValue1 = new javax.swing.JTextField();
        btRegister1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pnUsersBalance1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstUsers1 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Templar coin Demo");

        txtLeger.setColumns(20);
        txtLeger.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtLeger.setRows(5);
        jScrollPane1.setViewportView(txtLeger);

        jTabbedPane1.addTab("Ledger", new javax.swing.ImageIcon(getClass().getResource("/templarCoin/multimedia/blockChain.png")), jScrollPane1); // NOI18N

        txtBlochains.setColumns(20);
        txtBlochains.setRows(5);
        jScrollPane3.setViewportView(txtBlochains);

        jTabbedPane1.addTab("blockchain", jScrollPane3);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        tpTransaction.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tpTransactionStateChanged(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.BorderLayout());

        pnTransaction.setPreferredSize(new java.awt.Dimension(109, 180));
        pnTransaction.setLayout(new java.awt.GridLayout(4, 1, 5, 5));

        jComboBox1.setEditable(true);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createTitledBorder("Eleitor"));
        pnTransaction.add(jComboBox1);

        jComboBox2.setEditable(true);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createTitledBorder("Candidato"));
        pnTransaction.add(jComboBox2);

        txtValue.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtValue.setText("0.0");
        txtValue.setBorder(javax.swing.BorderFactory.createTitledBorder("Value"));
        txtValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValueActionPerformed(evt);
            }
        });
        pnTransaction.add(txtValue);

        btRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/templarCoin/multimedia/cash-icon.png"))); // NOI18N
        btRegister.setText("Votar");
        btRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegisterActionPerformed(evt);
            }
        });
        pnTransaction.add(btRegister);

        jPanel1.add(pnTransaction, java.awt.BorderLayout.NORTH);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/templarCoin/multimedia/templarCoin.png"))); // NOI18N
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        tpTransaction.addTab("Votos", new javax.swing.ImageIcon(getClass().getResource("/templarCoin/multimedia/templar.png")), jPanel1); // NOI18N

        pnUsersBalance.setLayout(new java.awt.BorderLayout());

        lstUsers.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lstUsers.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstUsers);

        pnUsersBalance.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jButton1.setText("Novo Eleitor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnUsersBalance.add(jButton1, java.awt.BorderLayout.PAGE_END);

        tpTransaction.addTab("Eleitores", new javax.swing.ImageIcon(getClass().getResource("/templarCoin/multimedia/users_ledger_24.png")), pnUsersBalance); // NOI18N

        tpTransaction1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tpTransaction1StateChanged(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new java.awt.BorderLayout());

        pnTransaction1.setPreferredSize(new java.awt.Dimension(109, 180));
        pnTransaction1.setLayout(new java.awt.GridLayout(4, 1, 5, 5));

        jComboBox3.setEditable(true);
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.setBorder(javax.swing.BorderFactory.createTitledBorder("Eleitor"));
        pnTransaction1.add(jComboBox3);

        jComboBox4.setEditable(true);
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox4.setBorder(javax.swing.BorderFactory.createTitledBorder("Candidato"));
        pnTransaction1.add(jComboBox4);

        txtValue1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtValue1.setText("0.0");
        txtValue1.setBorder(javax.swing.BorderFactory.createTitledBorder("Value"));
        txtValue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValue1ActionPerformed(evt);
            }
        });
        pnTransaction1.add(txtValue1);

        btRegister1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/templarCoin/multimedia/cash-icon.png"))); // NOI18N
        btRegister1.setText("Votar");
        btRegister1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegister1ActionPerformed(evt);
            }
        });
        pnTransaction1.add(btRegister1);

        jPanel2.add(pnTransaction1, java.awt.BorderLayout.NORTH);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/templarCoin/multimedia/templarCoin.png"))); // NOI18N
        jPanel2.add(jLabel2, java.awt.BorderLayout.CENTER);

        tpTransaction1.addTab("Votos", new javax.swing.ImageIcon(getClass().getResource("/templarCoin/multimedia/templar.png")), jPanel2); // NOI18N

        pnUsersBalance1.setLayout(new java.awt.BorderLayout());

        lstUsers1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lstUsers1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(lstUsers1);

        pnUsersBalance1.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jButton2.setText("Novo Eleitor");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnUsersBalance1.add(jButton2, java.awt.BorderLayout.PAGE_END);

        tpTransaction1.addTab("Eleitores", new javax.swing.ImageIcon(getClass().getResource("/templarCoin/multimedia/users_ledger_24.png")), pnUsersBalance1); // NOI18N

        tpTransaction.addTab("tab3", tpTransaction1);

        getContentPane().add(tpTransaction, java.awt.BorderLayout.WEST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tpTransactionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tpTransactionStateChanged
        if( tpTransaction.getSelectedComponent()== pnUsersBalance){
            DefaultListModel model = new DefaultListModel();
            model.addAll(coin.getUsersBalance());
            lstUsers.setModel(model);
        }
    }//GEN-LAST:event_tpTransactionStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegisterActionPerformed
        try {
            /*Transaction t = new Transaction(
                /* txtFrom.getText(),
                txtTo.getText(),
                Double.valueOf(txtValue.getText())
            );

            coin.add(t);*/
            txtLeger.setText(coin.toString());
            txtBlochains.setText(coin.getSecureLedger().toString());
            coin.save(fileTemplarCpoin);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(TemplarCoinGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btRegisterActionPerformed

    private void txtValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValueActionPerformed

    private void txtValue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValue1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValue1ActionPerformed

    private void btRegister1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegister1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRegister1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tpTransaction1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tpTransaction1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tpTransaction1StateChanged

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
    private javax.swing.JButton btRegister1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> lstUsers;
    private javax.swing.JList<String> lstUsers1;
    private javax.swing.JPanel pnTransaction;
    private javax.swing.JPanel pnTransaction1;
    private javax.swing.JPanel pnUsersBalance;
    private javax.swing.JPanel pnUsersBalance1;
    private javax.swing.JTabbedPane tpTransaction;
    private javax.swing.JTabbedPane tpTransaction1;
    private javax.swing.JTextArea txtBlochains;
    private javax.swing.JTextArea txtLeger;
    private javax.swing.JTextField txtValue;
    private javax.swing.JTextField txtValue1;
    // End of variables declaration//GEN-END:variables
}
