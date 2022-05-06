
package Main;

import GUI.MainFrame;
import GUI.ResultJPanel;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Mohamad Amin Javan
 * this class stores all data of the project
 */
public class Data {
    
    public static String Text = "";
    public static String TLOutput = "";
    public static String PTOutput = "";
    public static File file;
    public static MainFrame MF;
    public static ResultJPanel OP;
    /* Identifier Array includes
    *  at [0] NAME
    *  at [1] TYPE
    */
    public static ArrayList<String[]> IdentifierArr = new ArrayList<String[]>();
    
}
