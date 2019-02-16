/**
 * 
 */
package fr.miage.m1;

import java.io.File;
import java.io.FilenameFilter;

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
		}

		return false;
	}
}
