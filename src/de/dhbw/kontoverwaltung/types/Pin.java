package de.dhbw.kontoverwaltung.types;

import java.io.Serializable;

public class Pin implements Serializable {

	private String pin;

	public Pin(String pin) {
		super();
		this.pin = pin;
	}

	public boolean isCorrectPin(String pinToCheck) {
		return pin.equals(pinToCheck);
	}

}
