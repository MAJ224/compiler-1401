/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohamad Amin Javan
 */
public class OptionsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form OptionsJPanel
     */
    public OptionsJPanel() {
        initComponents();
        
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
        TablejScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
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

        TLjScrollPane.setViewportView(TLjTextPane);
        TLjTextPane.setText(Main.Data.Output);

        jTabbedPane.addTab("Tokens List", TLjScrollPane);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Type", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablejScrollPane.setViewportView(jTable);

        jTabbedPane.addTab("tab2", TablejScrollPane);

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
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(MainFrameTitlejLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ReturnjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaveOutputjButton)
                .addContainerGap())
            .addComponent(jTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainFrameTitlejLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
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
            String text = Main.Data.Output;
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
    private javax.swing.JButton ReturnjButton;
    private javax.swing.JButton SaveOutputjButton;
    private javax.swing.JScrollPane TLjScrollPane;
    private javax.swing.JTextPane TLjTextPane;
    private javax.swing.JScrollPane TablejScrollPane;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}