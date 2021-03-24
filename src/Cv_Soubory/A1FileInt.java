package Cv_Soubory;

import java.io.*;

public class A1FileInt {
	public static void Mainx(String[] args) throws IOException {
		int dny = 2, hodiny = 3, celkem, x, dny2 = 0, hodiny2 = 0;
		String soubFN = "C:/kurs/inty.dat";
		File fi = new File(soubFN);
		File di = new File("C:/kurs/");
		
		if (di.exists()) {
			fi.createNewFile();
			
			FileInputStream fis = new FileInputStream(fi);
			FileOutputStream fio = new FileOutputStream(fi);
			
			BufferedReader dr = new BufferedReader(new InputStreamReader(fis));
			BufferedWriter dw = new BufferedWriter(new OutputStreamWriter(fio));
			
			dw.write(Integer.valueOf(dny));;
			dw.write(Integer.valueOf(hodiny));

			dw.close();
			
			try {
				dny2 = (int)dr.read();
				hodiny2 = (int)dr.read();
				//x = br.ReadInt32();        //EndOfStreamException
			}
			catch (FileNotFoundException e) { System.out.println("Soubor nenalezen"); }
			catch (IOException e) { System.out.println("Ètení za koncem souboru"); }

			celkem = (dny2 * 24) + hodiny2;
			System.out.println("\n" + dny2 + " dnu a " + hodiny2 + " hodiny je " + celkem + " hodin\n");
			dw.close();
		}
		else
			System.out.println("cesta " + di.getAbsolutePath() + " neexistuje");
	}
}
