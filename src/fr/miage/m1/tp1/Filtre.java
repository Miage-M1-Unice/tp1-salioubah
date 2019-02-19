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

	/**
	 * 
	 */
	public Filtre(String filtre){
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
			
			Pattern p = Pattern.compile(filtre);
			Matcher m = p.matcher(name);
			if(m.find())
				return true;
		}

		return false;
	}
}
