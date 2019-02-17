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
	
	int i = 1;
	int j = 1;

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		System.out.println("Repertoire "+i+": " + dir);
		i++;
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.out.println("Fichier "+j+": " + file);
		j++;
		return FileVisitResult.CONTINUE;
	}



}
