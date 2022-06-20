/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CUP.Parser;
import JFlex.Scanner;
import JFlex.SymbolTable;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ScannerBuffer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohamad Amin Javan
 */
public class ResultJPanel extends javax.swing.JPanel {

    /**
     * Creates new form OptionsJPanel
     */
    public ResultJPanel() {
        CreateResult();
        initComponents();
        TLjTextPane.setText(Main.Data.TLOutput);
        TLjTextPane.setEnabled(false);
        PTjTextPane.setText(Main.Data.PTOutput);
        PTjTextPane.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainFrameTitlejLabel = new javax.swing.JLabel();
        SaveOutputjButton = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        TLjScrollPane = new javax.swing.JScrollPane();
        TLjTextPane = new javax.swing.JTextPane();
        PTjScrollPane = new javax.swing.JScrollPane();
        PTjTextPane = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        ReturnjButton = new javax.swing.JButton();

        MainFrameTitlejLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        MainFrameTitlejLabel.setText("Java Compiler Project");
        MainFrameTitlejLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        SaveOutputjButton.setText("Save Output");
        SaveOutputjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveOutputjButtonActionPerformed(evt);
            }
        });

        TLjTextPane.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TLjScrollPane.setViewportView(TLjTextPane);

        jTabbedPane.addTab("Tokens List", TLjScrollPane);

        PTjTextPane.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        PTjScrollPane.setViewportView(PTjTextPane);

        jTabbedPane.addTab("Parse Table", PTjScrollPane);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        jTabbedPane.addTab("tab4", jScrollPane1);

        ReturnjButton.setText("Return");
        ReturnjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ReturnjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaveOutputjButton)
                .addContainerGap())
            .addComponent(jTabbedPane)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MainFrameTitlejLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainFrameTitlejLabel)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveOutputjButton)
                    .addComponent(ReturnjButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SaveOutputjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveOutputjButtonActionPerformed

        JFileChooser jfc = new JFileChooser(Main.Data.file.getAbsolutePath());
        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String text = Main.Data.TLOutput;
            try (PrintWriter pw = new PrintWriter(jfc.getSelectedFile().getAbsolutePath())) {
                pw.write(text);
                pw.flush();
                pw.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(jfc, "An error occurred while saving!", "Error", 0);
            }
        }
    }//GEN-LAST:event_SaveOutputjButtonActionPerformed

    private void ReturnjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnjButtonActionPerformed

        Main.Data.MF.setContentPane(Main.Data.MF.cp);
        Main.Data.MF.pack();

    }//GEN-LAST:event_ReturnjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MainFrameTitlejLabel;
    private javax.swing.JScrollPane PTjScrollPane;
    private javax.swing.JTextPane PTjTextPane;
    private javax.swing.JButton ReturnjButton;
    private javax.swing.JButton SaveOutputjButton;
    private javax.swing.JScrollPane TLjScrollPane;
    private javax.swing.JTextPane TLjTextPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables

    private void CreateResult() {
        
        Main.Data.TLOutput = JFlex.Scanner.run(Main.Data.file);
        SymbolTable ST = null;
        try {
            ST = new SymbolTable(new BufferedReader(new FileReader(Main.Data.file.getAbsolutePath())));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ResultJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.Data.ST = ST;
        Main.Data.PTOutput = ST.CreateTable();
        
        ScannerBuffer lexer = new ScannerBuffer(ST);
        ComplexSymbolFactory csf = new ComplexSymbolFactory();
        Parser parser = new Parser(lexer, csf);
        
    }
}
