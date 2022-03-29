package de.dhbw.kontoverwaltung.types.transaktion;

import java.io.Serializable;

import de.dhbw.kontoverwaltung.types.GeldBetrag;
import de.dhbw.kontoverwaltung.util.UniqueIdGenerator;

public abstract class Transaktion implements Serializable {

	public Transaktion() {
		transaktionId = UniqueIdGenerator.next();
	}

	protected String transaktionId;
	protected GeldBetrag betrag;

	public String getTransaktionId() {
		return transaktionId;
	}

	public GeldBetrag getBetrag() {
		return betrag;
	}

}
