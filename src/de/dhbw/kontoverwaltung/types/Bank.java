package de.dhbw.kontoverwaltung.types;

import java.io.Serializable;

public class Bank implements Serializable {

	private String name;

	public Bank(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
