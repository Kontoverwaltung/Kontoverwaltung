package de.dhbw.kontoverwaltung.types;

public class Pin {

	private String pin;

	public Pin(String pin) {
		this.pin = pin;
	}

	public boolean checkPin(String pinToCheck) {
		return pin.equals(pinToCheck);
	}

}
