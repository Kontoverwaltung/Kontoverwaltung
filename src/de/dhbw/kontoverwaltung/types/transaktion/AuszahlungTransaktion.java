package de.dhbw.kontoverwaltung.types.transaktion;

import de.dhbw.kontoverwaltung.types.GeldAusgabeAutomat;
import de.dhbw.kontoverwaltung.types.EuroCentBetrag;
import de.dhbw.kontoverwaltung.types.GiroKonto;

public class AuszahlungTransaktion extends Transaktion {

	private GeldAusgabeAutomat automat;
	private GiroKonto konto;

	public AuszahlungTransaktion(GeldAusgabeAutomat automat, GiroKonto konto, EuroCentBetrag betrag) {
		super();
		this.automat = automat;
		this.konto = konto;
		this.betrag = betrag;
	}

	public GeldAusgabeAutomat getAutomat() {
		return automat;
	}

	public GiroKonto getKonto() {
		return konto;
	}

	@Override
	public String toString() {
		return "AuszahlungTransaktion [Automat=" + automat + ", KontoID=" + konto.getKontoId() + ", TransaktionID=" + transaktionId
				+ ", Betrag=" + betrag + "]";
	}

	
}
