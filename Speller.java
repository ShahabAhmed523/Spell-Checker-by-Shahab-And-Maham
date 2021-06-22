/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speller_checker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

/**
 *
 * @author ACER
 */
public class Speller {

    String data = "";
    String line;
    String output = "";

    
    public Speller() {
    }

    public String[] Dictionary() {

        try {
            FileReader in = new FileReader("E:/dictionary2.txt");			
            BufferedReader reader = new BufferedReader(in);
            while ((line = reader.readLine()) != null) {
                data = data + line.toLowerCase() + " ";
              
            }
            reader.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        String[] dictionary = data.split(" ");

        return dictionary;
    }

    public String TextFile(String[] dictionary) {

        int lineNo = 0, WordCout = 0;

        try {
            FileReader in = new FileReader("E:/text.txt");			
            BufferedReader reader = new BufferedReader(in);
            while ((line = reader.readLine()) != null) {
                
                lineNo++;
                String[] words = line.split(" ");
                for (String word : words) {
                    WordCout++;
                    word = word.replaceAll("[^a-zA-Z0-9]", "");
                    if (!Arrays.asList(dictionary).contains(word.toLowerCase())) {
                        output += "[" + lineNo + "]:[" + WordCout + "]:[" + word + "] \n";
                    }
                }
                WordCout = 0;
            }
            reader.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

        return output;
    }

    public void WriteOutput(String output) {

        try {
            FileWriter out = new FileWriter("E:/output.txt");			 
            BufferedWriter writer = new BufferedWriter(out);
            writer.write(output);				

            writer.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }

    public void Print_Mis_Spelled(String output) {

        System.out.println(output);

    }

}
