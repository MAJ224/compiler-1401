package GUI;

import CUP.Parser;
import JFlex.LexerScanner;
import JFlex.SymbolTable;
import java.io.BufferedReader;
import java.io.FileReader;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ScannerBuffer;
import java_cup.runtime.XMLElement;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Mohamad Amin Javan
 */
public class ResultJPanel extends javax.swing.JPanel {

    /**
     * Creates new form OptionsJPanel
     *
     * @throws java.lang.Exception
     */
    public ResultJPanel() throws Exception {
        CreateResult();
        initComponents();
        CreateTable();
        CreateTree();
        TLjTextPane.setText(Main.Data.TLOutput);
        TLjTextPane.setEnabled(false);
        ParseDebugjTextPane.setText(Main.Data.ParseOutput);
        ParseDebugjTextPane.setEnabled(false);
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
        jTabbedPane = new javax.swing.JTabbedPane();
        TLjScrollPane = new javax.swing.JScrollPane();
        TLjTextPane = new javax.swing.JTextPane();
        ParseDebugjScrollPane = new javax.swing.JScrollPane();
        ParseDebugjTextPane = new javax.swing.JTextPane();
        ReturnjButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1024, 720));
        setPreferredSize(new java.awt.Dimension(500, 500));

        MainFrameTitlejLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        MainFrameTitlejLabel.setText("Java Compiler Project");
        MainFrameTitlejLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TLjTextPane.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TLjScrollPane.setViewportView(TLjTextPane);

        jTabbedPane.addTab("Tokens List", TLjScrollPane);

        ParseDebugjTextPane.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        ParseDebugjScrollPane.setViewportView(ParseDebugjTextPane);

        jTabbedPane.addTab("Parse Debug", ParseDebugjScrollPane);

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
            .addComponent(jTabbedPane)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(MainFrameTitlejLabel)
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ReturnjButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainFrameTitlejLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ReturnjButton)
                .addGap(10, 10, 10)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ReturnjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnjButtonActionPerformed
        
        Main.Data.reset();
        Main.Data.MF.setContentPane(Main.Data.MF.cp);
        Main.Data.MF.pack();

    }//GEN-LAST:event_ReturnjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MainFrameTitlejLabel;
    private javax.swing.JScrollPane ParseDebugjScrollPane;
    private javax.swing.JTextPane ParseDebugjTextPane;
    private javax.swing.JButton ReturnjButton;
    private javax.swing.JScrollPane TLjScrollPane;
    private javax.swing.JTextPane TLjTextPane;
    private javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables

    private void CreateResult() throws Exception {
        // Print Lexer Analyzer part
        LexerScanner LS = new LexerScanner();
        Main.Data.TLOutput = LS.Run(Main.Data.file);

        ComplexSymbolFactory csf = new ComplexSymbolFactory();
        SymbolTable ST = new SymbolTable(new BufferedReader(new FileReader(Main.Data.file.getAbsolutePath())), csf);
        ScannerBuffer SB = new ScannerBuffer(ST);
        Parser P = new Parser(SB, csf);

        Main.Data.e = (XMLElement) P.parse().value;
        Main.Data.ParseOutput = Parser.getDebug_parser(P);
        Main.Data.ST = ST;

    }

    private void CreateTable() {

        String[] COL_HEADER = {"ID Number", "Identifier", "Type", "Value"};
        DefaultTableModel tableModel = new DefaultTableModel(COL_HEADER, 0);
        String[][] table = Main.Data.ST.get_Token_Table();
        for (int i = 0; i < 10; i++) {
            tableModel.insertRow(i, table[i]);
        }
        javax.swing.JTable PTjtable = new javax.swing.JTable(tableModel);
        PTjtable.setEnabled(false);
        javax.swing.JScrollPane PTjScrollPane = new javax.swing.JScrollPane(PTjtable);
        jTabbedPane.addTab("Parse Table", PTjScrollPane);

    }

    private void CreateTree() {

        javax.swing.JTree PTjtree = new javax.swing.JTree(TreeGen(Main.Data.e, null));
        javax.swing.JScrollPane PTjScrollPane = new javax.swing.JScrollPane(PTjtree);
        jTabbedPane.addTab("Parse Tree", PTjScrollPane);
        
    }

    private DefaultMutableTreeNode TreeGen(XMLElement e, DefaultMutableTreeNode root) {
        if (root == null) {
            //create the root node
            root = new DefaultMutableTreeNode("Tree");
        }
        //create the child nodes
        for (int i = 0; i < e.getChildren().size(); i++) {
            XMLElement next = e.getChildren().get(i);
            if (next.hasChildren()) {
                DefaultMutableTreeNode new_root = new DefaultMutableTreeNode(e.getTagname());
                root.add(TreeGen(next, new_root));
            } else {
                root.add(new DefaultMutableTreeNode(next.getTagname()));
            }
        }
        return root;
    }

}
