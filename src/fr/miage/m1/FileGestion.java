/**
 * 
 */
package fr.miage.m1;

import java.io.File;

/**
 * @author BAH
 *
 */
public class FileGestion {

	/**
	 * 
	 */
	public FileGestion() {
		// TODO Auto-generated constructor stub
	}
	
	public void filesOnlyList(String repertoire) {
		File rep = new File(repertoire);
		String[] fichiers = rep.list();
		System.out.println("----------------------DEBUT------------------");
		int i = 1;
		for (String fichier : fichiers) {
			System.out.println("Fichier "+i+": "+fichier);
			i++;
		}
		System.out.println("----------------------FIN---------------------");
	}
	
	public void filesList(String repertoire) {
		File rep = new File(repertoire);
		File[] fichiers = rep.listFiles();
		System.out.println("----------------------DEBUT------------------");
		int i = 1;
		for (File fichier : fichiers) {
			System.out.println("Fichier "+i+": "+fichier);
			if(fichier.isDirectory()) {
				int j = 1;
				for (String f : fichier.list()) {
					System.out.println("\tFichier "+i+"-"+j+": "+f);
					j++;
				}
			}
			i++;
		}
		System.out.println("----------------------FIN---------------------");
	}
	
	public static void main(String[] args) {
		FileGestion f = new FileGestion();
		f.filesOnlyList("C:\\Users\\BAH\\Desktop\\MIAGE");
		f.filesList("C:\\Users\\BAH\\Desktop\\MIAGE");
	}
}
