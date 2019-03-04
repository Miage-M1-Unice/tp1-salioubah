/**
 * 
 */
package fr.miage.m1.tp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author BAH
 *
 */
public class AnalyseurClasse {

	public static void analyseClasse(String nomClasse) throws ClassNotFoundException {
		// Récupération d'un objet de type Class correspondant au nom passé en paramètres
		Class cl = AnalyseurClasse.getClasse(nomClasse); // CODE A ECRIRE !

		afficheEnTeteClasse(cl);

		System.out.println();
		afficheAttributs(cl);

		System.out.println();
		afficheConstructeurs(cl);

		System.out.println();
		afficheMethodes(cl);

		// L'accolade fermante de fin de classe !
		System.out.println("}");
	}


	/** Retourne la classe dont le nom est passé en paramètre */
	public static Class getClasse(String nomClasse) throws ClassNotFoundException {
		Class c = Class.forName(nomClasse);
		return c;
		// CODE A ECRIRE
	}

	/** Cette méthode affiche par ex "public class Toto extends Tata implements Titi, Tutu {" */
	public static void afficheEnTeteClasse(Class cl) {
		//  Affichage du modifier et du nom de la classe
		// CODE A ECRIRE
		int i = cl.getModifiers();
		String mod = Modifier.toString(i);
		String className = cl.getSimpleName()+" ";

		// Récupération de la superclasse si elle existe (null si cl est le type Object)
		// CODE A ECRIRE
		Class superClass = cl.getSuperclass();
		String extensionClassName = superClass.getSimpleName();
		String extension = "";
		if(!superClass.equals(Object.class)) {
			extension = "extends "+extensionClassName+" ";
		}

		// On ecrit le "extends " que si la superclasse est non nulle et
		// différente de Object
		// CODE A ECRIRE

		// Affichage des interfaces que la classe implemente
		// CODE A ECRIRE
		Class interfaces[] = cl.getInterfaces();
		String implementations = "implements ";
		int compteur = 1;
		int taille = interfaces.length;
		String separateur = ", ";
		for (Class inter : interfaces) {
			if(compteur == taille) separateur = "";
			implementations += inter.getSimpleName()+separateur;
			compteur++;
		}
		
		System.out.println(mod+" Class "+className+extension+implementations+" {");
		// Enfin, l'accolade ouvrante !
		//System.out.println(" { ");

	}
	public static void afficheAttributs(Class cl) {
		// CODE A ECRIRE
		System.out.println("// Champs");
		Field champs[] = cl.getDeclaredFields();
		for (Field field : champs) {
			System.out.println(Modifier.toString(field.getModifiers())+" "+field.getType()+" "+field.getName());
		}
	}

	public static void afficheConstructeurs(Class cl) {
		// CODE A ECRIRE
		System.out.println("// Constructeurs");
		Constructor cons[] = cl.getDeclaredConstructors();
		for (Constructor constructor : cons) {
			System.out.println(constructor);
		}
	}


	public static void afficheMethodes(Class cl) {
		// CODE A ECRIRE
		System.out.println("// Méthodes");
		Method meth[] = cl.getDeclaredMethods();
		for (Method method : meth) {
			System.out.println(method);
		}
	}


	public static String litChaineAuClavier() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}

	public static void main(String[] args) {
		boolean ok = false;

		while(!ok) {
			try {
				System.out.println("Entrez le nom d'une classe (ex : java.util.Date): ");
				String nomClasse = litChaineAuClavier();

				analyseClasse(nomClasse);

				ok = true;
			} catch(ClassNotFoundException e) {
				System.out.println("Classe non trouvée.");
			}catch(Exception e) {
				System.out.println("Erreur d'E/S!");
			}
		}
	}

}
