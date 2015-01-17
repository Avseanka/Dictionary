/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package My_Package;

import java.util.ArrayList;

/**
 *
 * @author Doru
 */
public class Test {
    
    
    
    
    public static void main(String Args[]){
        String s2 = "KungFuPanda";
        String s1 = "KungFuPand";
        ArrayList<String> list = new ArrayList();
        
        
        Dictionar d = new Dictionar();
    //System.out.println(s1.matches("KungFuPa.d"));
            //d.search("S*");     
//System.out.println(d.search("S*aseara"));
        d.populate();
//        d.print();
//        System.out.println("======================================================================");
//        d.addDefinition("Doru","Pamidoru");
//        d.addDefinition("Serii","Babuin");
//        d.print();
//        d.removeDefinition("Serii");
//        System.out.println("======================================================================");
//        d.print();
        System.out.println(WellFormedHelper.checkConsistency(d));
        //System.out.println(d.search("S?chka*"));
//S+ = non whitespace character 
    //. any character
    
    }
    // replace all whitespace with tabs
} 

