package de.dhbw.kontoverwaltung.types;

public class Pin {

	private String pin;
	
	private boolean checkPin(String pinToCheck) {
		return pin.equals(pinToCheck);
	}

}
