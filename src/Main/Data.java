/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import GUI.MainFrame;

/**
 *
 * @author Arash
 */
public class Data {
    
    private String Text = "";
    public MainFrame MF;
    
    Data(MainFrame MF){
        this.MF = MF;
        MF.setVisible(true);
    }
    
    public void SetText(String str){
        Text = str;
    }
    public String GetText(){
        return Text;
    }
    
    
}
