package com.lemilliard.mapper;

/**
 * @author Thomas Kint
 */
public class Exemple {

	public static void main(String[] args) {
		Mapper mapper = new Mapper("./exemple");

		System.out.println(mapper.processPhrase("Je cherche un travail et une formation"));
		System.out.println(mapper.processPhrase("Je cherche une formation"));
		System.out.println(mapper.processPhrase("Va à la page suivante"));
		System.out.println(mapper.processPhrase("Va sur la page suivante"));
		System.out.println(mapper.processPhrase("Fais voir la page d'avant"));
	}
}
