package de.dhbw.kontoverwaltung.types.transaktion;

import de.dhbw.kontoverwaltung.types.EuroCentBetrag;
import de.dhbw.kontoverwaltung.types.GiroKonto;

public class KontoZuKontoTransaktion extends Transaktion {

	private GiroKonto sender;
	private GiroKonto empfaenger;

	public KontoZuKontoTransaktion(GiroKonto sender, GiroKonto empfaenger, EuroCentBetrag betrag) {
		super();
		this.sender = sender;
		this.empfaenger = empfaenger;
		this.betrag = betrag;
	}

	public GiroKonto getSender() {
		return sender;
	}

	public GiroKonto getEmpfaenger() {
		return empfaenger;
	}

	@Override
	public String toString() {
		return "KontoZuKontoTransaktion [Sender=" + sender + ", Empfaenger=" + empfaenger + "]";
	}
	
	

}
