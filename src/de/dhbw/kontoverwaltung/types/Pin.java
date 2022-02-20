package de.dhbw.kontoverwaltung.types;

public class Pin {

	private String pin;

	public Pin(String pin) {
		super();
		this.pin = pin;
	}

	public String getPin() {
		return pin;
	}

	public boolean checkPin(String pinToCheck) {
		return pin.equals(pinToCheck);
	}

}
