package de.dhbw.kontoverwaltung.types;

import java.io.Serializable;

public class EuroCentBetrag implements Serializable {

	private int cent;
	private int euro;

	public EuroCentBetrag(int cent, int euro) {
		super();
		this.cent = cent;
		this.euro = euro;
	}

	public int getCent() {
		return cent;
	}

	public int getEuro() {
		return euro;
	}

	@Override
	public String toString() {
		return "Betrag [" + euro + "," + cent + "]";
	}

	public static EuroCentBetrag parse(String input) {
		String[] split = input.split("\\.");
		if (split.length != 2) {
			return null;
		}
		try {
			int euro = Integer.parseInt(split[0]);
			int cent = Integer.parseInt(split[1]);
			return new EuroCentBetrag(cent, euro);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	private int getSum() {
		return (euro * 100) + cent;
	}

	private static EuroCentBetrag fromSum(int sum) {
		int euro = sum / 100;
		int cent = sum % 100;
		return new EuroCentBetrag(cent, euro);
	}
	
	public EuroCentBetrag subtract(EuroCentBetrag sub) {
		int sum = getSum();
		sum -= sub.getSum();
		return fromSum(sum);
	}

	public EuroCentBetrag add(EuroCentBetrag add) {
		int sum = getSum();
		sum += add.getSum();
		return fromSum(sum);
	}
}
