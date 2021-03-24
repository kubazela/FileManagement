package Cv_Soubory;
import java.io.File;
import java.util.*;

class TestFiles {
    public static void Mainx(String[] args) {
    	
        String cesta = "C:\\kurs\\";
        Scanner sc = new Scanner(System.in);
        File di = new File(cesta);
        File[] seznamSoub = null;
        if (di.exists()) {
             seznamSoub = di.listFiles();
            for (File soub : seznamSoub) {
                System.out.println(soub.getName() + "\t\t velikost: " + soub.length() + "\t\t datum: " + new Date(soub.lastModified()));
            }
        }
        else {
        	System.out.println("Slo�ka neexistuje");
        }
        System.out.println("\nZadej n�zev souboru pro smaz�n�:");
        File del = new File(cesta + sc.nextLine());
        if (del.exists()) {
            del.delete();
            //del.Delete();
            System.out.println("Soubor smaz�n");
            seznamSoub = di.listFiles();
            for (File soub : seznamSoub) {
            	System.out.println(soub.getName() + "\t\t velikost: " + soub.length() + "\t\t datum: " + new Date(soub.lastModified()));
            }
        }
        else {
        	System.out.println("Soubor neexistuje\n");
        }
    }
}
