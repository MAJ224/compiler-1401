/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFlex;

import java.util.ArrayList;

/**
 *
 * @author Mohamad Amin Javan
 */
public class SymbolTable{
    
    /* Parse Table includes
    *  at [0] NAME
    *  at [1] TYPE
    *  at [2] VALUE
    */
    public static ArrayList<String[]> ParseTable = new ArrayList<String[]>();
    static String[] Types = {"LONG","INT","STRING","CHAR","BOOLEAN","DOUBLE","FLOAT", "VOID"};  
    static String[] Values = {"INTEGER_LITERAL", "FLOATING_POINT_LITERAL", "BOOLEAN_LITERAL",
        "CHARACTER_LITERAL", "STRING_LITERAL", "NULL_LITERAL"};
    public static String CreateTable (){
        
        String Token[], PrevToken[] = null;
        int LastIDIndex = 0;
        
        for (int i = 0; i < Main.Data.IdentifierArr.size(); i++) {
            Token =  Main.Data.IdentifierArr.get(i);
            if (Token[1].equals("IDENTIFIER")){
                if (!ContainsName(Token[0]))
                    ParseTable.add(new String[]{Token[0] ,"UNDEFINED" ,"UNDEFINED"});
                if (PrevToken != null && ContainsType(PrevToken[1]))
                    ParseTable.set(getIndexOf(Token[0]), new String[]{Token[0], PrevToken[1], "UNDEFINED"});
                LastIDIndex = getIndexOf(Token[0]);
            }
            else if (ContainsValue(Token[1]))
                ParseTable.set(LastIDIndex, new String[]{ParseTable.get(LastIDIndex)[0],
                    ParseTable.get(LastIDIndex)[1], Token[0]});
            PrevToken = Token;
        }
        int index = 0;
        String Output = "ID ---- NAME ---- TYPE ---- VALUE\n";
        for(String[] arr : ParseTable){
            Output += Integer.toString(index) + " ---- " + arr[0] +
                    " ---- " + arr[1] + " ---- " + arr[2] +"\n";
            index++;
        }
        return Output;
    }
    
    private static boolean ContainsType(String type){
        for (String s : Types){
            if (s.equals(type)) return true;
        }
        return false;
    }
    private static boolean ContainsValue(String value){
        for (String s : Values){
            if (s.equals(value)) return true;
        }
        return false;
    }
        private static boolean ContainsName(String name){
        return getIndexOf(name) >= 0;
    }
    private static int getIndexOf(String name){
        for (int i = 0; i < ParseTable.size(); i++){
            if (ParseTable.get(i)[0].equals(name)) return i;
        }
        return -1;
    }
}
