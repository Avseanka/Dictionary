/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class ClassicSingleton {
   private static Dictionar d = new Dictionar();
   protected ClassicSingleton() {
      // Exists only to defeat instantiation.
   }
   public static ClassicSingleton getInstance() {
      if(d == null) {
         d= new ClassicSingleton();
      }
      return d;
   }
}



