/**
 * 
 */
package fr.miage.m1.tp1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author BAH
 *
 */
public class SeLit {

	void lecture(Scanner source) { 

		/*
		 * Redirection de la sortie standard vers un fichier
		 */
		PrintStream fileStream;
		try {
			fileStream = new PrintStream("Output.txt");
			System.setOut(fileStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(source.hasNextLine()) {  
			String s = source.nextLine();
			if (!s.trim().startsWith("//")) {
				System.out.println(s); 

			}

			// A modifier  
		}  
	}  

	static public void main(String[] args) {   
		try {
			FileInputStream in = new FileInputStream(new File("src/fr/miage/m1/tp1/Selit.java"));
			Scanner sc = new Scanner(in);
			SeLit seLit = new SeLit();
			seLit.lecture(sc);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
	} 

}
