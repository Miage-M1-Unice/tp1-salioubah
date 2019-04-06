/**
 * 
 */
package fr.miage.m1.tp2;

import java.awt.Point;
import java.awt.Polygon;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * @author BAH
 *
 */
public class GenericToString {

	/**
	 * 
	 */
	public GenericToString() {
		// TODO Auto-generated constructor stub
	}


	/*
	 * Methode toString sans profondeur
	 */
	public String toString(Object ob) {

		Class cl = ob.getClass();
		Field attributs[] = cl.getDeclaredFields();

		String affichage = cl.getName()+"[";
		for (Field field : attributs) {
			field.setAccessible(true);
			try {
				affichage += field.getName()+"="+field.get(ob)+";";
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {

				e.printStackTrace();
			} catch (IllegalAccessException e) {

				e.printStackTrace();
			}
		}
		affichage += "]";

		return affichage;
	}

	/*
	 * Methode toString avec profondeur
	 */
	public String toString(Object ob, int prof) throws IllegalArgumentException, IllegalAccessException, InstantiationException {

		String affichage = "";
		Class cl = ob.getClass();
		Field attributs[] = cl.getDeclaredFields();

		affichage = cl.getName()+"[";
		for (Field field : attributs) {
			if(prof == 0) {
				return "";
			}
			field.setAccessible(true);
			if(field.getType().isPrimitive()) {
				affichage += field.getName()+"="+field.get(ob)+";";
			}
			else if(field.getType().isArray()){

                affichage += field.getName();
                affichage += "={";

                for (int j = 0; j < Array.getLength(field.get(ob)); j++) {
                    affichage += Array.get(field.get(ob), j);

                    if(j != Array.getLength(field.get(ob))-1)
                        affichage += ",";
                }
                affichage += "} ";
            }
			else {
				//	for (int i = 1; i < prof; i++) {
				affichage += toString(field.get(ob),prof-1);
				//}
			}
		}
		affichage += "]";

		return affichage;
	}

	public static void main(String[] args) {
		GenericToString g = new GenericToString();
		Polygon pol = new Polygon(new int[]{10, 20, 30}, new int[]{20,30, 40}, 3);  
		pol.getBounds();
		try {
			System.out.println(g.toString(pol,2));
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
