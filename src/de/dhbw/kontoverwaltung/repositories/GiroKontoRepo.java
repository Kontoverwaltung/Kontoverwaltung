package de.dhbw.kontoverwaltung.repositories;

import de.dhbw.kontoverwaltung.repositories.returns.GiroKontoReturn;
import de.dhbw.kontoverwaltung.types.Bank;
import de.dhbw.kontoverwaltung.types.EuroCentBetrag;
import de.dhbw.kontoverwaltung.types.GiroKonto;
import de.dhbw.kontoverwaltung.types.Person;
import de.dhbw.kontoverwaltung.types.Pin;
import de.dhbw.kontoverwaltung.types.transaktion.Transaktion;

public interface GiroKontoRepo {

	public GiroKontoReturn getGiroKontoById(String giroKontoId);

	public GiroKontoReturn addGiroKonto(Bank bank, Person inhaber, Pin pin);

	public GiroKontoReturn updatePin(GiroKonto giroKonto, Pin newPin);

	public GiroKontoReturn updateBank(GiroKonto giroKonto, Bank newBank);

	public GiroKontoReturn updateBetrag(GiroKonto giroKonto, EuroCentBetrag betrag);

	public GiroKontoReturn addHistoryEntry(GiroKonto giroKonto, Transaktion transaktion);

	public GiroKontoReturn removeGiroKonto(GiroKonto giroKonto);

}
