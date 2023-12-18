package eVoting.gui;

import eVoting.core.Partido;
import eVoting.core.Pessoa;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import eVoting.core.eVoting;
import eVoting.core.Voto;
import eVoting.core.eVotingPartidos;
import eVoting.core.eVotingEleitores;

public class eVotingGUI extends javax.swing.JFrame {

    public static String ficheiroVotos = "sistemaVotos.obj";
    public static String ficheiroEleitores = "sistemaEleitores.obj";
    public static String ficheiroPartidos = "sistemaPartidos.obj";
    private String CC;
    eVoting ledgerVotos;
    eVotingPartidos ledgerPartidos;
    eVotingEleitores ledgerEleitores;

    public eVotingGUI(String cc) {
        initComponents();
        ledgerVotos = new eVoting();
        ledgerPartidos = new eVotingPartidos();
        ledgerEleitores = new eVotingEleitores();
        CC = cc;

        try {
            //tentativa de carregamento dos ficheiros com dados das ledgers
            loadFiles();

            //escrever na ledger votos
            votosLedger.setText(ledgerVotos.toStringVoto());
            blockchainVotos.setText(ledgerVotos.getSecureLedgerVoto().toString());

            //escrever na ledger eleitores
            eleitoresLedger.setText(ledgerEleitores.toStringEleitor());
            blockchainEleitores.setText(ledgerEleitores.getSecureLedgerEleitores().toString());

            //escrever na ledger partidos
            partidosLedger.setText(ledgerPartidos.toStringPartido());
            blockchainPartidos.setText(ledgerPartidos.getSecureLedgerPartidos().toString());

            //faz log in do eleitor e mostra os dados
            updateEleitor();

            //popular as jComboBox com o nome dos partidos
            jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(ledgerPartidos.getPartidos().toArray(new String[0])));

        } catch (Exception e) {
        }

        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        partidosLedger = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        eleitoresLedger = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        blockchainVotos = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        blockchainPartidos = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        blockchainEleitores = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        votosLedger = new javax.swing.JTextArea();
        tpTransaction = new javax.swing.JTabbedPane();
        pnVotos = new javax.swing.JPanel();
        pnTransaction = new javax.swing.JPanel();
        jLabelEleitor = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        btRegister = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("eVoting");

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(200, 0));

        partidosLedger.setColumns(20);
        partidosLedger.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        partidosLedger.setRows(5);
        jScrollPane4.setViewportView(partidosLedger);

        jTabbedPane1.addTab("Ledger Partidos", new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/users_ledger_24.png")), jScrollPane4); // NOI18N

        eleitoresLedger.setColumns(20);
        eleitoresLedger.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        eleitoresLedger.setRows(5);
        jScrollPane6.setViewportView(eleitoresLedger);

        jTabbedPane1.addTab("Ledger Eleitores", new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/users_ledger_24.png")), jScrollPane6); // NOI18N

        blockchainVotos.setColumns(20);
        blockchainVotos.setRows(5);
        jScrollPane3.setViewportView(blockchainVotos);

        jTabbedPane1.addTab("Blockchain Votos", new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/blockChain.png")), jScrollPane3); // NOI18N

        blockchainPartidos.setColumns(20);
        blockchainPartidos.setRows(5);
        jScrollPane7.setViewportView(blockchainPartidos);

        jTabbedPane1.addTab("Blockchain Partidos", new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/blockChain.png")), jScrollPane7); // NOI18N

        blockchainEleitores.setColumns(20);
        blockchainEleitores.setRows(5);
        jScrollPane8.setViewportView(blockchainEleitores);

        jTabbedPane1.addTab("Blockchain Eleitores", new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/blockChain.png")), jScrollPane8); // NOI18N

        votosLedger.setColumns(20);
        votosLedger.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        votosLedger.setRows(5);
        jScrollPane1.setViewportView(votosLedger);

        jTabbedPane1.addTab("Ledger Votos", new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/users_ledger_24.png")), jScrollPane1); // NOI18N

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

        pnTransaction.setMinimumSize(new java.awt.Dimension(94, 300));
        pnTransaction.setPreferredSize(new java.awt.Dimension(200, 380));
        pnTransaction.setLayout(new java.awt.GridLayout(4, 1, 5, 5));

        jLabelEleitor.setBorder(javax.swing.BorderFactory.createTitledBorder("Eleitor"));
        jLabelEleitor.setMaximumSize(new java.awt.Dimension(10, 40));
        jLabelEleitor.setMinimumSize(new java.awt.Dimension(10, 40));
        jLabelEleitor.setPreferredSize(new java.awt.Dimension(10, 40));
        pnTransaction.add(jLabelEleitor);

        jComboBox2.setEditable(true);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createTitledBorder("Partido"));
        jComboBox2.setMaximumSize(new java.awt.Dimension(75, 43));
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/eVotingLogo.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 350));
        pnVotos.add(jLabel1, java.awt.BorderLayout.CENTER);

        tpTransaction.addTab("Votos", new javax.swing.ImageIcon(getClass().getResource("/eVoting/multimedia/templar.png")), pnVotos); // NOI18N

        getContentPane().add(tpTransaction, java.awt.BorderLayout.WEST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tpTransactionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tpTransactionStateChanged
        updateLista();
    }//GEN-LAST:event_tpTransactionStateChanged

    private void btRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegisterActionPerformed
        try {
            Pessoa eleitor = ledgerEleitores.getEleitor(CC);

            //Verificar se não votou
            if (!ledgerVotos.jaVotou(eleitor)) {
                Voto v = new Voto(
                        eleitor.getCC(),
                        jComboBox2.getItemAt(jComboBox2.getSelectedIndex())
                );

                ledgerVotos.addVoto(v);
                votosLedger.setText(ledgerVotos.toStringVoto());
                blockchainVotos.setText(ledgerVotos.getSecureLedgerVoto().toString());
                ledgerVotos.save(ficheiroVotos);

                updateEleitor();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(eVotingGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btRegisterActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO addVoto your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void loadFiles() throws Exception {
        //tentativa de carregamento dos ficheiros com dados das ledgers
        if (eVoting.load(ficheiroVotos) != null) {
            ledgerVotos = eVoting.load(ficheiroVotos);
        }

        //não foram criados partidos
        if (eVotingPartidos.load(ficheiroPartidos) == null) {
            //criar partidos
            Partido partido = new Partido("Partido 1");
            Partido partido2 = new Partido("Partido 2");
            Partido partido3 = new Partido("Partido 3");
            Partido partido4 = new Partido("Partido 4");

            ledgerPartidos.addPartido(partido);
            ledgerPartidos.addPartido(partido2);
            ledgerPartidos.addPartido(partido3);
            ledgerPartidos.addPartido(partido4);

            partidosLedger.setText(ledgerPartidos.toStringPartido());
            blockchainPartidos.setText(ledgerPartidos.getSecureLedgerPartidos().toString());
            ledgerPartidos.save(ficheiroPartidos);
        } else {
            ledgerPartidos = eVotingPartidos.load(ficheiroPartidos);
        }

        if (eVotingEleitores.load(ficheiroEleitores) != null) {
            ledgerEleitores = eVotingEleitores.load(ficheiroEleitores);
        }
    }

    private void updateEleitor() {
        Pessoa eleitor = ledgerEleitores.getEleitor(CC);
        String nomeEleitor = eleitor.getNome();
        String ccEleitor = eleitor.getCC();
        int idade = eleitor.getIdade();
        String idadeEleitor = String.valueOf(idade);
        String votouEleitor;
        
        if (ledgerVotos.jaVotou(eleitor)) {
            votouEleitor = "Sim";
            btRegister.setEnabled(false);
        } else {
            votouEleitor = "Não";
        }

        String jLabelEleitorText = "<html>Id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: " + ccEleitor + "<br>Nome: " + nomeEleitor + "<br>Idade : " + idadeEleitor + "<br>Votou : " + votouEleitor + "</html>";
        jLabelEleitor.setText(jLabelEleitorText);
    }

    private void updateLista() {
        if (tpTransaction.getSelectedComponent() == pnVotos) {
            try {
                //popular a jComboBox com o nome dos partidos
                if (eVotingPartidos.load(ficheiroPartidos) != null) {
                    jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(ledgerPartidos.getPartidos().toArray(new String[0])));
                }
            } catch (Exception ex) {
                Logger.getLogger(eVotingGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

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
                new eVotingGUI(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea blockchainEleitores;
    private javax.swing.JTextArea blockchainPartidos;
    private javax.swing.JTextArea blockchainVotos;
    private javax.swing.JButton btRegister;
    private javax.swing.JTextArea eleitoresLedger;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEleitor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea partidosLedger;
    private javax.swing.JPanel pnTransaction;
    private javax.swing.JPanel pnVotos;
    private javax.swing.JTabbedPane tpTransaction;
    private javax.swing.JTextArea votosLedger;
    // End of variables declaration//GEN-END:variables
}
