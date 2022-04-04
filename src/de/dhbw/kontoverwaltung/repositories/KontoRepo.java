package de.dhbw.kontoverwaltung.repositories;

import de.dhbw.kontoverwaltung.repositories.returns.KontoReturn;
import de.dhbw.kontoverwaltung.types.Bank;
import de.dhbw.kontoverwaltung.types.EuroCentBetrag;
import de.dhbw.kontoverwaltung.types.GiroKonto;
import de.dhbw.kontoverwaltung.types.Person;
import de.dhbw.kontoverwaltung.types.Pin;
import de.dhbw.kontoverwaltung.types.transaktion.Transaktion;

public interface KontoRepo {

	public KontoReturn getKontoById(String kontoId);

	public KontoReturn addKonto(Bank bank, Person inhaber, Pin pin);

	public KontoReturn updatePin(GiroKonto konto, Pin newPin);

	public KontoReturn updateBank(GiroKonto konto, Bank newBank);

	public KontoReturn updateBetrag(GiroKonto konto, EuroCentBetrag betrag);
	
	public KontoReturn addHistoryEntry(GiroKonto konto, Transaktion transaktion);

	public KontoReturn removeKontoById(String kontoId);

}
