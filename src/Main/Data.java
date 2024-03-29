
package Main;

import GUI.MainFrame;
import GUI.ResultJPanel;
import JFlex.SymbolTable;
import java.io.File;
import java.util.ArrayList;
import java_cup.runtime.XMLElement;

/**
 *
 * @author Mohamad Amin Javan
 * this class stores all data of the project
 */
public class Data {
    
    // PRINT VARIABLES
    public static String Text = "";
    public static String TLOutput = ""; // Tokens List Output
    public static String ParseOutput = ""; // Parse Result Output
    public static String Errors = ""; // Generated Errors
    public static XMLElement e = null;
    
    public static File file = null;
    public static MainFrame MF;
    public static ResultJPanel RP;
    public static SymbolTable ST;
    
    // ARRAYS
    /* Identifier Array includes
    *  at [0] NAME
    *  at [1] TYPE
    */
    public static ArrayList<String[]> IdentifierArr = new ArrayList<String[]>();

    public static void reset() {
        
        file = null;
        
    }
    
}
