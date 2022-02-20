package de.dhbw.kontoverwaltung.types.transaktion;

import de.dhbw.kontoverwaltung.types.Betrag;
import de.dhbw.kontoverwaltung.types.Konto;

public class KontoZuKontoTransaktion extends Transaktion {

	private Konto sender;
	private Konto empfaenger;

	public KontoZuKontoTransaktion(Konto sender, Konto empfaenger, Betrag betrag) {
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
