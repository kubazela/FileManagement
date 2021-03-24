package Cv_Soubory;

import java.io.*;

public class FileSerial {
	static class Person implements Serializable{
		public String name;
		public int age;
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
		
		public int getAge() {
			return age;
		}
	}
	
	public static void Mainx(String[] args) throws IOException, ClassNotFoundException 
		{	
		Person osoba = new Person();
		osoba.setAge(5);
		osoba.setName("Karel Parek");
		
		File file = new File("C:\\kurs\\person.dat");
		
		try {
			if(file.exists()) {
				ObjectOutputStream vystup = new ObjectOutputStream(new FileOutputStream(file));
				vystup.writeObject(osoba);
				vystup.close();		
			}
			else {
				file.createNewFile();
				ObjectOutputStream vystup = new ObjectOutputStream(new FileOutputStream(file));
				vystup.writeObject(osoba);
				vystup.close();	
			}
		}
		catch (IOException e) {
			System.out.println(e);
		}
		
		Person osoba2 = null;
		
		ObjectInputStream vstup = new ObjectInputStream(new FileInputStream(file));
		osoba2 = (Person)vstup.readObject();
		
		System.out.println(osoba2.getName() + ", " + osoba2.getAge());
		}
	}