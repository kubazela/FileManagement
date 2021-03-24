package Cv_Soubory;

import java.io.*;

public class A1FileStr {
	public static void Mainx(String[] args) throws IOException{
		
        int hodiny = 0, dny = 0, celkem = 0;
        int i = 0;
        String s = "";
        
        File cesta = new File("C:\\kurs\\A1FileStr.txt");
        File cesta2 = new File("C:\\kurs\\A1FileStrWRITE.txt");
        BufferedReader sRead = new BufferedReader(new FileReader(cesta));
        BufferedWriter sWrite = new BufferedWriter(new FileWriter(cesta2));
        
        try {
            if (cesta.exists()) {
                int j = 0;
                String[] pole = new String[2];
                while ((s = sRead.readLine()) != null ) {
                	pole[j] = s;
                	j++;
                }
                try {
                    hodiny = Integer.valueOf(pole[0]);
                    dny = Integer.valueOf(pole[1]);
                    celkem = dny * 24 + hodiny;
                    System.out.println("hodiny " + hodiny + ", dny " + dny );
                    if (cesta2.exists()) {
                        sWrite.write(String.valueOf(celkem));
                        System.out.println("Soubor naplnìn hodnotami");
                        sWrite.close();
                    }
                    else {
                        cesta2.createNewFile();
                        sWrite.write(celkem);
                        System.out.println("Soubor byl vytvoøen a naplnìn hodnotami");
                        sWrite.close();
                    }
                }
                catch (NumberFormatException e) {
                	System.out.println("Špatnì zadaný formát èísla");
                }
                catch (IndexOutOfBoundsException e) {
                	System.out.println("Pokus o ètení za ko");
                }
            }
        }
        catch (FileNotFoundException e) {
        	System.out.println("Soubor nenalezen");
        }
        catch (Exception e) {
        	System.out.println(e);
        }
    }
}
