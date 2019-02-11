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

	/**
	 * 
	 */
	public Filtre(){
		
	}

	/* (non-Javadoc)
	 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
	 */
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void filesListFilter(String chemin) {
		File f = new File(chemin);
		//f.listFiles(Filtre);
	}

}
