/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speller_checker;
/**
 *
 * @author ACER
 */
public class Speller_Checker {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Speller obj1 = new Speller();

        String[] dictionary = obj1.Dictionary();
        String output = obj1.TextFile(dictionary);

        obj1.WriteOutput(output);
        obj1.Print_Mis_Spelled(output);
    }
}
