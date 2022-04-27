/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import GUI.MainFrame;
import GUI.OptionsJPanel;
import java.io.File;

/**
 *
 * @author Arash
 */
public class Data {
    
    private String Text = "";
    private String Output = "";
    private File file;
    private MainFrame MF;
    private OptionsJPanel OP;
    
    
    Data(MainFrame MF){
        this.MF = MF;
        MF.setVisible(true);
    }
    
    public void setText(String str){
        Text = str;
    }
    
    public String getText(){
        return Text;
    }
    
    public String getOutput() {
        return Output;
    }

    public void setOutput(String Output) {
        this.Output = Output;
    }
    
    public void SetFile(File file){
        this.file = file;
    }

    public File getFile() {
        return file;
    }
    
    public void SetMFText(String txt) {
        MF.SetText(txt);
    }
    
    public String getMFText(){
        return MF.getText();
    }
    
    public void setOP(OptionsJPanel OP){
        this.OP = OP;
    }
    public OptionsJPanel getOP(){
        return OP;
    }
}
