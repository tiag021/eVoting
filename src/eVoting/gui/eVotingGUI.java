package eVoting.gui;

import java.awt.GridLayout;
import java.io.Console;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import eVoting.core.Candidato;
import eVoting.core.Eleitor;
import eVoting.core.eVoting;
import eVoting.core.Voto;
import eVoting.core.eVotingCandidatos;
import eVoting.core.eVotingEleitores;

public class eVotingGUI extends javax.swing.JFrame {

    public static String ficheiroVotos = "sistemaVotos.obj";
    public static String ficheiroEleitores = "sistemaEleitores.obj";
    public static String ficheiroCandidatos = "sistemaCandidatos.obj";
    eVoting ledgerVotos;
    eVotingCandidatos ledgerCandidatos;
    eVotingEleitores ledgerEleitores;
    DefaultListModel modelCandidatos;
    DefaultListModel modelEleitores;

    public eVotingGUI() {
        initComponents();
        ledgerVotos = new eVoting();
        ledgerCandidatos = new eVotingCandidatos();
        ledgerEleitores = new eVotingEleitores();

        try {
            //tentativa de carregamento dos ficheiros com dados das ledgers
            loadFiles();

            //escrever na ledger votos
            votosLedger.setText(ledgerVotos.toStringVoto());
            blockchainVotos.setText(ledgerVotos.getSecureLedgerVotos().toString());

            //escrever na ledger eleitores
            eleitoresLedger.setText(ledgerEleitores.toStringEleitor());
            blockchainEleitores.setText(ledgerEleitores.getSecureLedgerEleitores().toString());

            //escrever na ledger candidatos
            candidatosLedger.setText(ledgerCandidatos.toStringCandidato());
            blockchainCandidatos.setText(ledgerCandidatos.getSecureLedgerCandidatos().toString());

            //popular as jComboBox com o nome dos eleitores e candidatos
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(ledgerEleitores.getEleitores().toArray(new String[0])));
            jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(ledgerCandidatos.getCandidatos().toArray(new String[0])));

        } catch (Exception e) {
        }

        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        votosLedger = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        candidatosLedger = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        eleitoresLedger = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        blockchainVotos = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        blockchainCandidatos = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        blockchainEleitores = new javax.swing.JTextArea();
        tpTransaction = new javax.swing.JTabbedPane();
        pnVotos = new javax.swing.JPanel();
        pnTransaction = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        btRegister = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pnEleitores = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstUsers = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        pnCandidatos = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstCandidates = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("eVoting");

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(234, 0));

        votosLedger.setColumns(20);
        votosLedger.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        votosLedger.setRows(5);
        jScrollPane1.setViewportView(votosLedger);

        jTabbedPane1.addTab("Ledger Votos", new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/users_ledger_24.png")), jScrollPane1); // NOI18N

        candidatosLedger.setColumns(20);
        candidatosLedger.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        candidatosLedger.setRows(5);
        jScrollPane4.setViewportView(candidatosLedger);

        jTabbedPane1.addTab("Ledger Candidatos", new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/users_ledger_24.png")), jScrollPane4); // NOI18N

        eleitoresLedger.setColumns(20);
        eleitoresLedger.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        eleitoresLedger.setRows(5);
        jScrollPane6.setViewportView(eleitoresLedger);

        jTabbedPane1.addTab("Ledger Eleitores", new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/users_ledger_24.png")), jScrollPane6); // NOI18N

        blockchainVotos.setColumns(20);
        blockchainVotos.setRows(5);
        jScrollPane3.setViewportView(blockchainVotos);

        jTabbedPane1.addTab("Blockchain Votos", new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/blockChain.png")), jScrollPane3); // NOI18N

        blockchainCandidatos.setColumns(20);
        blockchainCandidatos.setRows(5);
        jScrollPane7.setViewportView(blockchainCandidatos);

        jTabbedPane1.addTab("Blockchain Candidatos", new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/blockChain.png")), jScrollPane7); // NOI18N

        blockchainEleitores.setColumns(20);
        blockchainEleitores.setRows(5);
        jScrollPane8.setViewportView(blockchainEleitores);

        jTabbedPane1.addTab("Blockchain Eleitores", new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/blockChain.png")), jScrollPane8); // NOI18N

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        tpTransaction.setPreferredSize(new java.awt.Dimension(260, 525));
        tpTransaction.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tpTransactionStateChanged(evt);
            }
        });

        pnVotos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnVotos.setMinimumSize(new java.awt.Dimension(260, 450));
        pnVotos.setLayout(new java.awt.BorderLayout());

        pnTransaction.setPreferredSize(new java.awt.Dimension(109, 250));
        pnTransaction.setLayout(new java.awt.GridLayout(4, 1, 5, 5));

        jComboBox1.setEditable(true);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createTitledBorder("Eleitor"));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        pnTransaction.add(jComboBox1);

        jComboBox2.setEditable(true);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createTitledBorder("Candidato"));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        pnTransaction.add(jComboBox2);

        btRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/cash-icon.png"))); // NOI18N
        btRegister.setText("Votar");
        btRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegisterActionPerformed(evt);
            }
        });
        pnTransaction.add(btRegister);

        pnVotos.add(pnTransaction, java.awt.BorderLayout.NORTH);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/templarCoin.png"))); // NOI18N
        pnVotos.add(jLabel1, java.awt.BorderLayout.CENTER);

        tpTransaction.addTab("Votos", new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/templar.png")), pnVotos); // NOI18N

        pnEleitores.setLayout(new java.awt.BorderLayout());

        lstUsers.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lstUsers.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstUsers);

        pnEleitores.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jButton1.setText("Novo Eleitor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnEleitores.add(jButton1, java.awt.BorderLayout.PAGE_END);

        tpTransaction.addTab("Eleitores", new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/users_ledger_24.png")), pnEleitores); // NOI18N

        pnCandidatos.setLayout(new java.awt.BorderLayout());

        lstCandidates.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lstCandidates.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(lstCandidates);

        pnCandidatos.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jButton3.setText("Novo Candidato");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        pnCandidatos.add(jButton3, java.awt.BorderLayout.PAGE_END);

        tpTransaction.addTab("Candidatos", new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/users_ledger_24.png")), pnCandidatos); // NOI18N

        getContentPane().add(tpTransaction, java.awt.BorderLayout.WEST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tpTransactionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tpTransactionStateChanged
        updateLista();
    }//GEN-LAST:event_tpTransactionStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Create input fields
        JTextField nameField = new JTextField(10);
        JTextField ageField = new JTextField(10);
        JTextField idField = new JTextField(10);

        // Create a panel to hold input fields
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Nome: "));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Idade: "));
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Id do Eleitor: "));
        inputPanel.add(idField);

        int result = JOptionPane.showConfirmDialog(
                this,
                inputPanel,
                "Insira os dados do eleitor",
                JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            //Obter valores dos campos de input
            String name = nameField.getText();
            String age = ageField.getText();
            String id = idField.getText();

            //criar um novo eleitor
            Eleitor eleitor = new Eleitor(name, age, id);

            //update da JList eleitores
            updateLista();

            //tentaiva de adicionar um eleitor à blockchain e guardar os seus dados
            try {
                ledgerEleitores.addEleitor(eleitor);
                eleitoresLedger.setText(ledgerEleitores.toStringEleitor());
                blockchainEleitores.setText(ledgerEleitores.getSecureLedgerEleitores().toString());
                ledgerEleitores.save(ficheiroEleitores);
            } catch (Exception ex) {
                Logger.getLogger(eVotingGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            // You can perform further actions with the created candidate here.
            // For example, display the candidate's information.
            JOptionPane.showMessageDialog(this,
                    "ID: " + eleitor.getIdEleitor() + ", Nome: " + eleitor.getNomeEleitor() + ", Idade: " + eleitor.getIdade(),
                    "Eleitor criado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegisterActionPerformed
        try {
            Voto t = new Voto(
                    jComboBox1.getItemAt(jComboBox1.getSelectedIndex()),
                    jComboBox2.getItemAt(jComboBox2.getSelectedIndex())
            );

            ledgerVotos.addVoto(t);
            votosLedger.setText(ledgerVotos.toStringVoto());
            blockchainVotos.setText(ledgerVotos.getSecureLedgerVotos().toString());
            ledgerVotos.save(ficheiroVotos);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(eVotingGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btRegisterActionPerformed

    private void loadFiles() throws Exception {
        //tentativa de carregamento dos ficheiros com dados das ledgers
        ledgerVotos = eVoting.load(ficheiroVotos);
        ledgerCandidatos = eVotingCandidatos.load(ficheiroCandidatos);
        ledgerEleitores = eVotingEleitores.load(ficheiroEleitores);
    }

    private void updateLista() {
        if (tpTransaction.getSelectedComponent() == pnEleitores) {
            modelEleitores = new DefaultListModel();
            modelEleitores.addAll(ledgerEleitores.getEleitores());
            lstUsers.setModel(modelEleitores);
        }
        if (tpTransaction.getSelectedComponent() == pnCandidatos) {
            modelCandidatos = new DefaultListModel();
            modelCandidatos.addAll(ledgerCandidatos.getCandidatos());
            lstCandidates.setModel(modelCandidatos);
        }
        if (tpTransaction.getSelectedComponent() == pnVotos) {
            //popular as jComboBox com o nome dos eleitores e candidatos
            //jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(ledgerEleitores.getEleitores().toArray(new String[0])));
            //jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(ledgerCandidatos.getCandidatos().toArray(new String[0])));
        }

    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Create input fields
        JTextField nameField = new JTextField(10);
        JTextField ageField = new JTextField(10);
        JTextField idField = new JTextField(10);

        // Create a panel to hold input fields
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Nome: "));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Idade: "));
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Id do Candidato: "));
        inputPanel.add(idField);

        int result = JOptionPane.showConfirmDialog(
                this,
                inputPanel,
                "Insira os dados do candidato",
                JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            // Get values from input fields
            String name = nameField.getText();
            String age = ageField.getText();
            String id = idField.getText();

            //criar um novo candidato
            Candidato candidato = new Candidato(name, age, id);

            //update da JList candidatos
            updateLista();

            //tentaiva de adicionar um eleitor à blockchain e guardar os seus dados
            try {
                ledgerCandidatos.addCandidato(candidato);
                candidatosLedger.setText(ledgerCandidatos.toStringCandidato());
                blockchainCandidatos.setText(ledgerCandidatos.getSecureLedgerCandidatos().toString());
                ledgerCandidatos.save(ficheiroCandidatos);
            } catch (Exception ex) {
                Logger.getLogger(eVotingGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            // You can perform further actions with the created candidate here.
            // For example, display the candidate's information.
            JOptionPane.showMessageDialog(this,
                    "ID: " + candidato.getIdCandidato() + ", Nome: " + candidato.getNomeCandidato() + ", Idade: " + candidato.getIdade(),
                    "Candidato criado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed


    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO addVoto your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

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
            java.util.logging.Logger.getLogger(eVotingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(eVotingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(eVotingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(eVotingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new eVotingGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea blockchainCandidatos;
    private javax.swing.JTextArea blockchainEleitores;
    private javax.swing.JTextArea blockchainVotos;
    private javax.swing.JButton btRegister;
    private javax.swing.JTextArea candidatosLedger;
    private javax.swing.JTextArea eleitoresLedger;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> lstCandidates;
    private javax.swing.JList<String> lstUsers;
    private javax.swing.JPanel pnCandidatos;
    private javax.swing.JPanel pnEleitores;
    private javax.swing.JPanel pnTransaction;
    private javax.swing.JPanel pnVotos;
    private javax.swing.JTabbedPane tpTransaction;
    private javax.swing.JTextArea votosLedger;
    // End of variables declaration//GEN-END:variables
}
