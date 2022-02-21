package de.dhbw.kontoverwaltung.util;

import java.util.UUID;

public class UniqueIdGenerator {

	public static String next() {
		String result = UUID.randomUUID().toString();
		return result;
	}

}
