
package Main;

import GUI.MainFrame;
import GUI.ResultJPanel;
import JFlex.SymbolTable;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Mohamad Amin Javan
 * this class stores all data of the project
 */
public class Data {
    
    // PRINT VARIABLES
    public static String Text = "";
    public static String TLOutput = ""; // Tokens List Output
    public static String PTOutput = ""; // Pase Table Output
    public static String ParseOutput = ""; // Parse Result Output
    
    // 
    public static File file;
    public static MainFrame MF;
    public static ResultJPanel OP;
    public static SymbolTable ST;
    
    // ARRAYS
    /* Identifier Array includes
    *  at [0] NAME
    *  at [1] TYPE
    */
    public static ArrayList<String[]> IdentifierArr = new ArrayList<String[]>();
    
}
