/**
 * 
 */
package fr.miage.m1.tp1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author BAH
 *
 */
public class Filtre implements FilenameFilter {
	
	private String filtre;
	
	private Pattern pattern;

	/**
	 * 
	 */
	public Filtre(String filtre){
		this.filtre = filtre;
	}
	
	public Filtre(Pattern p) {
		pattern = p;
	}
	
	@Override
	public boolean accept(File dir, String name) {
		
		File f = new File(dir, name);
		return f.isDirectory() || Pattern.matches(pattern.pattern(), f.getPath());
	
	}
}
