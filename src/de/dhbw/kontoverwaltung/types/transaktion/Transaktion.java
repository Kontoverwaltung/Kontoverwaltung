package de.dhbw.kontoverwaltung.types.transaktion;

import java.util.UUID;

import de.dhbw.kontoverwaltung.types.Betrag;

public abstract class Transaktion {

	public Transaktion() {
		transaktionId = UUID.randomUUID().toString();
	}

	protected String transaktionId;
	protected Betrag betrag;

	public String getTransaktionId() {
		return transaktionId;
	}

	public Betrag getBetrag() {
		return betrag;
	}

}
