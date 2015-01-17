/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package My_Package;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Doru
 */
public class Dictionar {
    TreeMap<String, String> map = new TreeMap();
    TreeMap<String, String> mistakes = new TreeMap();
    TreeMap<String, String> toBeAdded = new TreeMap();
    
    public Dictionar(){
        
    }

    public void populate(){
        loadFromFile();
    }
    
    public TreeMap<String, String> getMap() {
        return map;
    }
    
    public void newDefinition(String key, String value){
        toBeAdded.put(key, value);
    }
    
    public void confirmDefinition(String key, String value){
        toBeAdded.remove(key);
        newDefinition(key,value);
    }
    
    public void reportMistake(String key,String value){
        mistakes.put(key, value);
    }
    
    public void confirmMistake(String key, String value){
        removeDefinition(key);
        mistakes.remove(key);
    }
    
    public void addDefinition(String key,String value){
        map.put(key, value);
        writeToFile();
        loadFromFile();
    }
    
    public void removeDefinition(String s){
        map.remove(s);
        writeToFile();
        loadFromFile();
    }
    
    public String search(String s){
        return toString(SearchHelper.searchDef(s, this));
    }
    
    public String toString(ArrayList<String> list){
        String rez = "";
        for(int i = 0; i < list.size(); i++){
            rez = rez + list.get(i) +"  -  "+ map.get(list.get(i)) + "\n";
        }
                return rez;
    }
    
        public void print(){
                 for(Map.Entry<String,String> entry : map.entrySet()) {
              String key = entry.getKey();
              String value = entry.getValue();
              System.out.println(key + "=" + value);
    }
    }
    
    public void loadFromFile(){
        String input = "";
        String key = "";
        String value = "";
        String[] parts;
        try {
            Scanner in = new Scanner(new FileReader("dictionar.txt"));
            while(in.hasNextLine()){
                String nextLine = in.nextLine();
                if(nextLine.contains("=")){ 
                parts = nextLine.split("=");
                key = parts[0]; 
                value = parts[1];
                map.put(key, value);
                }
                else{
                    map.put(key, map.get(key).concat("\n"+nextLine));
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dictionar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void writeToFile(){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("dictionar.txt", "UTF-8");
             for(Map.Entry<String,String> entry : map.entrySet()) {
              String key = entry.getKey();
              String value = entry.getValue();
              writer.println(key + "=" + value);
    }
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dictionar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Dictionar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
    }
}
