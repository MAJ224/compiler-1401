package GUI;

import java.awt.Container;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Mohamad Amin Javan 98213011
 */
public class MainFrame extends javax.swing.JFrame {

    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    Container cp = this.getContentPane();

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    public void SetText(String txt) {
        jTextPane.setText(txt);
    }

    public String getText() {
        return jTextPane.getText();
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
        LoadFilejButton = new javax.swing.JButton();
        InputCodejLabel = new javax.swing.JLabel();
        SaveFilejButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane = new javax.swing.JTextPane();
        CompilejButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compiler Project 98213011");
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        setPreferredSize(new java.awt.Dimension(400, 300));

        MainFrameTitlejLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        MainFrameTitlejLabel.setText("Java Compiler Project");
        MainFrameTitlejLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        LoadFilejButton.setText("Load File");
        LoadFilejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadFilejButtonActionPerformed(evt);
            }
        });

        InputCodejLabel.setText("Your Code :");

        SaveFilejButton.setText("Save File");
        SaveFilejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveFilejButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPane);
        TextLineNumber tln = new TextLineNumber(jTextPane);
        jScrollPane1.setRowHeaderView(tln);

        CompilejButton.setText("Compile");
        CompilejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompilejButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(InputCodejLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CompilejButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LoadFilejButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SaveFilejButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(100, Short.MAX_VALUE)
                        .addComponent(MainFrameTitlejLabel)
                        .addGap(0, 96, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainFrameTitlejLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoadFilejButton)
                    .addComponent(InputCodejLabel)
                    .addComponent(SaveFilejButton)
                    .addComponent(CompilejButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoadFilejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadFilejButtonActionPerformed

        String Text = "";
        int returnValue = jfc.showOpenDialog(null);

        // Query whether "Open" was clicked
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            Scanner scn = null;
            File file = jfc.getSelectedFile();
            Main.Data.file = file;
            try {
                scn = new Scanner(Main.Data.file); //file to be scanned
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            // while there is another line to read 
            while (scn.hasNext()) {
                Text += scn.nextLine() + "\n";
            }
            Main.Data.Text = Text;
            Main.Data.MF.SetText(Text);
            scn.close(); // closes the scanner
        }

    }//GEN-LAST:event_LoadFilejButtonActionPerformed

    private void SaveFilejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveFilejButtonActionPerformed
        if (Main.Data.file == null) {
            JOptionPane.showMessageDialog(this, "No File is Selected!", "Error", 0);
        } else {
            String text = Main.Data.MF.getText();
            Main.Data.Text = text;
            try (PrintWriter pw = new PrintWriter(Main.Data.file.getAbsolutePath())) {
                pw.write(text);
                pw.flush();
                pw.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "An error occurred while saving!", "Error", 0);
            }
            JOptionPane.showMessageDialog(this, "New File Has Been Saved!", "Success", 1);
        }
    }//GEN-LAST:event_SaveFilejButtonActionPerformed

    private void CompilejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompilejButtonActionPerformed

        if (Main.Data.file == null) {
            JOptionPane.showMessageDialog(this, "No File is Selected!", "Error", 0);
        } else {
            if (JOptionPane.showConfirmDialog(this, "Continue?",
                    "Scan Completed", 2) == JOptionPane.YES_OPTION) {
                ResultJPanel OP = null;
                try {
                    OP = new ResultJPanel();
                } catch (Exception ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                Main.Data.OP = OP;
                this.setContentPane(Main.Data.OP);
                this.pack();
            }
        }

    }//GEN-LAST:event_CompilejButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CompilejButton;
    private javax.swing.JLabel InputCodejLabel;
    private javax.swing.JButton LoadFilejButton;
    private javax.swing.JLabel MainFrameTitlejLabel;
    private javax.swing.JButton SaveFilejButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane;
    // End of variables declaration//GEN-END:variables
}
