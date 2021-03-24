package Cv_Soubory;
import java.io.*;

public class A1FileByte {
	public static void Mainx(String[] args) throws IOException {
		File cesta = new File("C:\\kurs\\hodiny.dat");
		int celkem, dny, hodiny;//, pokus;
		
		FileInputStream fileInput = new FileInputStream(cesta);
		FileOutputStream fileOutput = new FileOutputStream(cesta);
		
		DataInputStream vstup = new DataInputStream(fileInput);
		DataOutputStream vystup = new DataOutputStream(fileOutput);
		
		try {
			if (cesta.exists()) {
				byte[] poleB = new byte[] {2,3};
				for (int i = 0; i < poleB.length; i++) {
					vystup.write(Byte.valueOf(poleB[i]));;
				}
				vystup.close();
				try {
					int i = 0, cislo;
					do {
						cislo = vstup.read();
						if (cislo != -1) {
							poleB[i] = (byte)cislo;
							System.out.println("Pozice v souboru: " + fileInput.getChannel().position() + "cislo: " + poleB[i]);
						}
						i++;
					} while (cislo != -1);
					
					fileInput.getChannel().position(0);

					dny = (byte)vstup.read();
					hodiny = (byte)vstup.read();

					celkem = dny * 24 + hodiny;
					System.out.println("Celkem " + celkem + "  hodin.");
				}
				catch (NumberFormatException e) {
					System.out.println("Spatny format cisla. " + e.getMessage());
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("Pokus o cteni za koncem souboru");
				}
			}
		}
		catch (IOException e) {
			System.out.println("Soubor nenalezen! " + e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Nastala nejaka divna chyba");
		}
	}
}
