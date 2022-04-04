package de.dhbw.kontoverwaltung.util;

public class UniqueIdGenerator {

	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

	public static String next() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			int index = (int) (Math.random() * ALPHABET.length());
			sb.append(ALPHABET.charAt(index));
		}
		return sb.toString();
	}

}
