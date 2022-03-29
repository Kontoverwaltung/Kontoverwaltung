package de.dhbw.kontoverwaltung.types.transaktion;

import de.dhbw.kontoverwaltung.types.GeldBetrag;
import de.dhbw.kontoverwaltung.types.Konto;

public class KontoZuKontoTransaktion extends Transaktion {

	private Konto sender;
	private Konto empfaenger;

	public KontoZuKontoTransaktion(Konto sender, Konto empfaenger, GeldBetrag betrag) {
		super();
		this.sender = sender;
		this.empfaenger = empfaenger;
		this.betrag = betrag;
	}

	public Konto getSender() {
		return sender;
	}

	public Konto getEmpfaenger() {
		return empfaenger;
	}

}
