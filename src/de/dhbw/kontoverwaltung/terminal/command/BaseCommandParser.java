package de.dhbw.kontoverwaltung.terminal.command;

import de.dhbw.kontoverwaltung.events.bank.BankEvents;
import de.dhbw.kontoverwaltung.events.geldausgabeautomat.GeldAusgabeAutomatEvents;
import de.dhbw.kontoverwaltung.events.girokonto.GiroKontoEvents;
import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.events.transaktion.TransaktionEvents;
import de.dhbw.kontoverwaltung.terminal.process.automat.GeldAusgabeAutomatCommandProcessor;
import de.dhbw.kontoverwaltung.terminal.process.bank.BankCommandProcessor;
import de.dhbw.kontoverwaltung.terminal.process.konto.GiroKontoCommandProcessor;
import de.dhbw.kontoverwaltung.terminal.process.kunde.KundeCommandProcessor;
import de.dhbw.kontoverwaltung.terminal.process.transaktion.TransaktionCommandProcessor;

public class BaseCommandParser extends UppercaseCommandParser {

	public BaseCommandParser(KundeEvents kundeEvents, BankEvents bankEvents, GiroKontoEvents giroKontoEvents,
			TransaktionEvents transaktionEvents, GeldAusgabeAutomatEvents geldAusgabeAutomatEvents) {
		super(0);
		commands.put("KUNDE", new KundeCommandProcessor(kundeEvents));
		commands.put("BANK", new BankCommandProcessor(bankEvents));
		commands.put("GIROKONTO", new GiroKontoCommandProcessor(giroKontoEvents));
		commands.put("TRANSAKTION", new TransaktionCommandProcessor(transaktionEvents));
		commands.put("GELDAUSGABEAUTOMAT", new GeldAusgabeAutomatCommandProcessor(geldAusgabeAutomatEvents));
	}

}
