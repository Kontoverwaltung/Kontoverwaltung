package de.dhbw.kontoverwaltung.types.transaktion;

import java.io.Serializable;

import de.dhbw.kontoverwaltung.types.EuroCentBetrag;
import de.dhbw.kontoverwaltung.util.UniqueIdGenerator;

public abstract class Transaktion implements Serializable {

	public Transaktion() {
		transaktionId = UniqueIdGenerator.next();
	}

	protected String transaktionId;
	protected EuroCentBetrag betrag;

	public String getTransaktionId() {
		return transaktionId;
	}

	public EuroCentBetrag getBetrag() {
		return betrag;
	}

}
