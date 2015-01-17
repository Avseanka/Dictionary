/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package My_Package;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Doru
 */
public class SearchHelper {
    
    
    public static ArrayList searchDef(String s, Dictionar d){
        ArrayList<String> list = new ArrayList();
        s = s.toLowerCase();
        String pattern = convertRegex(s);
        //System.out.println(pattern);
        for(Map.Entry<String,String> entry : d.getMap().entrySet()) {
              String key = entry.getKey();
        if(key.toLowerCase().matches(pattern)) list.add(key);
        
    }
        return list;
}
    
    public static String convertRegex(String s){
        String conv = "";
        for(int i = 0; i < s.length(); i++){
            if(s.substring(i,i+1).equals("*")){
                conv = conv + ".+|\0";
            }
            else{
            if(s.substring(i,i+1).equals("?")){
                conv = conv + ".{1,1}";
            }
            else{
                conv = conv + s.substring(i,i+1);
            }
        }
        }
        
        return conv;
    }
    
    
}
