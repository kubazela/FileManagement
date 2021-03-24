package Cv_Soubory;

import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class FileNotParse {
        public static void Mainx(String[] args) throws IOException {
            String text = "Nashledanou";
            String textPrecteno = "";
            String[] textPole = new String[] { "Dobrý den", " celý den" };
            char[] precteno = new char[100];
            
            File di = new File("C:\\kurs\\");
            File file = new File("C:\\kurs\\FileNotParseText.txt");
            File file2 = new File("C:\\kurs\\FileNotParseText2.txt");
            
            FileReader reader = new FileReader(file);
            FileReader reader2 = new FileReader(file2);
            FileWriter writer = new FileWriter(file);
            FileWriter writer2 = new FileWriter(file2);
            
            if (file.exists() && file2.exists()) {
            	writer.write(text);
            	writer2.write(Arrays.toString(textPole));
            	writer.close();
            	writer2.close();
            }
            int i;
            
            while((i = reader.read()) >= 0) {
            	System.out.print((char)i);
            }
            
            System.out.println();
            
            i = 0;
            while((i = reader2.read()) >= 0) {
            	System.out.print((char)i);
            }
        }
}