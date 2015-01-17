/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package My_Package;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Doru
 */
public class WellFormedHelper {
    public static boolean wellFormed(Dictionar d){
        
        return true;
    }
    
    public static boolean checkConsistency(Dictionar d){
        String value = "";
        String key = "";
        String word = "";
        String[] parts;
        boolean ok = false;
        TreeMap<String, String> map = d.getMap();
        
        for(Map.Entry<String,String> entry : map.entrySet()) {
                value = entry.getValue();
                parts = value.split(",");
                
            for (String part : parts) {
                ok = false;
                for (Map.Entry<String,String> entry1 : map.entrySet()) {
                    key = entry1.getKey();
                    if (part.equals(key)) {
                        ok = true;
                        break;
                    }
                }
                                    if(ok == false) {
                        return false;
                    }
            }
        }
        return true;
    }
}
