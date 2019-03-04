/**
 * 
 */
package fr.miage.m1.tp1;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

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


	public class FiltreInterne implements FilenameFilter {

		private String filtre;

		/**
		 * 
		 */
		public FiltreInterne(String filtre){
			this.filtre = filtre;
		}

		@Override
		public boolean accept(File dir, String name) {
			if(name.lastIndexOf('.')>0) {
				int lastIndex = name.lastIndexOf('.');
				String str = name.substring(lastIndex);

				if(str.equals(filtre)) {
					return true;
				}
			}

			return false;
		}
	}



	/**
	 * Lister le contenu d'un repertoire et sous repertoire
	 * 
	 * @param repertoire repertoire à lister
	 */
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

	/**
	 * Lister le contenu d'un repertoire et sous repertoire
	 * 
	 * @param repertoire repertoire à lister
	 */
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

	/**
	 * Lister le contenu d'un repertoire avec un filtre de Classe externe
	 * 
	 * @param repertoire le repertoire à lister
	 * @param filtre le filtre des fichiers
	 */
	public void filesListFilter(String repertoire, Filtre filtre) {
		try {

			File rep = new File(repertoire);
			File[] fichiers = rep.listFiles(filtre);
			System.out.println("----------------------DEBUT------------------");
			int i = 1;
			for (File fichier : fichiers) {
				System.out.println("Fichier "+i+": "+fichier);
				/*
				if(fichier.isDirectory()) {
					int j = 1;
					for (String f : fichier.list()) {
						System.out.println("\tFichier "+i+"-"+j+": "+f);
						j++;
					}
				}
				*/
				i++;
			}
			System.out.println("----------------------FIN---------------------");
		} catch(Exception e) {
			// if any error occurs
			e.printStackTrace();
		}
	}

	/**
	 * Lister le contenu d'un repertoire avec un filtre de Classe interne
	 * 
	 * @param repertoire le repertoire à lister
	 * @param filtre le filtre des fichiers
	 */
	public void filesListFilterInterne(String repertoire, FiltreInterne filtre) {
		try {

			File rep = new File(repertoire);
			File[] fichiers = rep.listFiles(filtre);
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
		} catch(Exception e) {
			// if any error occurs
			e.printStackTrace();
		}
	}
	
	/**
	 * Lister le contenu d'un repertoire avec un filtre de Classe interne
	 * 
	 * @param repertoire le repertoire à lister
	 * @param String le filtre des fichiers
	 */
	public void filesListFilterAnonymous(String repertoire, String filtre) {
		try {

			File rep = new File(repertoire);
			File[] fichiers = rep.listFiles(new FilenameFilter() {
				
				@Override
				public boolean accept(File dir, String name) {
					if(name.lastIndexOf('.')>0) {
						int lastIndex = name.lastIndexOf('.');
						String str = name.substring(lastIndex);

						if(str.equals(filtre)) {
							return true;
						}
					}

					return false;
				}
			});
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
		} catch(Exception e) {
			// if any error occurs
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FileGestion f = new FileGestion();
		String dir = "C:\\Users\\BAH\\Desktop";
		String dir2 = "C:\\Users\\BAH\\Desktop\\MIAGE\\M1\\Intelligence Economique";
		
		//f.filesOnlyList(dir);
		//f.filesList(dir);
		
		Pattern p = Pattern.compile(".*docx");

		Filtre filtre = new Filtre(p);
		f.filesListFilter(dir, filtre);

		FiltreInterne fI = f.new FiltreInterne(".zip");
		//f.filesListFilterInterne(dir, fI);
		
		//f.filesListFilterAnonymous(dir, ".pdf");
		
		FileGestionVisitor fileVisitor = new FileGestionVisitor(".pdf");
		try {
			Files.walkFileTree(Paths.get(dir2), fileVisitor);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
