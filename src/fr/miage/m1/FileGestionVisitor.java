/**
 * 
 */
package fr.miage.m1;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author BAH
 *
 */
public class FileGestionVisitor extends SimpleFileVisitor<Path>{
	
	private String filtre;
	
	int i = 1;
	int j = 1;
	
	public FileGestionVisitor(String filtre) {
		this.filtre = filtre;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		System.out.println("Repertoire "+i+": " + dir);
		i++;
		return FileVisitResult.CONTINUE;
	}
	

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		//System.out.println("Fichier "+j+": " + file);
		String name = file.getFileName().toString();
		if(name.lastIndexOf(".")>0) {
			int lastIndex = name.lastIndexOf('.');
			String str = name.substring(lastIndex);

			if(str.equals(filtre)) {
				System.out.println("Fichier "+i+"-"+j+": " + file);
				j++;
			}
		}
		return FileVisitResult.CONTINUE;
	}
}
