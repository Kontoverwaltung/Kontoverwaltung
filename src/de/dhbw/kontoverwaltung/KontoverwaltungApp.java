package de.dhbw.kontoverwaltung;

import de.dhbw.kontoverwaltung.events.bank.BankEvents;
import de.dhbw.kontoverwaltung.events.bank.BankEventsImpl;
import de.dhbw.kontoverwaltung.events.geldausgabeautomat.GeldAusgabeAutomatEvents;
import de.dhbw.kontoverwaltung.events.geldausgabeautomat.GeldAusgabeAutomatEventsImpl;
import de.dhbw.kontoverwaltung.events.girokonto.GiroKontoEvents;
import de.dhbw.kontoverwaltung.events.girokonto.GiroKontoEventsImpl;
import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.events.kunde.KundeEventsImpl;
import de.dhbw.kontoverwaltung.events.transaktion.TransaktionEvents;
import de.dhbw.kontoverwaltung.events.transaktion.TransaktionEventsImpl;
import de.dhbw.kontoverwaltung.repositories.BankRepo;
import de.dhbw.kontoverwaltung.repositories.BankRepoImpl;
import de.dhbw.kontoverwaltung.repositories.GeldAusgabeAutomatRepo;
import de.dhbw.kontoverwaltung.repositories.GeldAusgabeAutomatRepoImpl;
import de.dhbw.kontoverwaltung.repositories.GiroKontoRepo;
import de.dhbw.kontoverwaltung.repositories.GiroKontoRepoImpl;
import de.dhbw.kontoverwaltung.repositories.KundeRepo;
import de.dhbw.kontoverwaltung.repositories.KundeRepoImpl;
import de.dhbw.kontoverwaltung.terminal.TerminalHandler;
import de.dhbw.kontoverwaltung.terminal.command.BaseCommandParser;

public class KontoverwaltungApp {

	private static KontoverwaltungApp instance = null;

	private KontoverwaltungApp() {
	}

	public static KontoverwaltungApp getInstance() {
		if (instance == null) {
			instance = new KontoverwaltungApp();
		}
		return instance;
	}

	public static void main(String[] args) {
		KontoverwaltungApp app = KontoverwaltungApp.getInstance();
		app.start();
	}

	private void start() {
		GiroKontoRepo giroKontoRepo = new GiroKontoRepoImpl();
		BankRepo bankRepo = new BankRepoImpl();
		KundeRepo kundeRepo = new KundeRepoImpl();
		GeldAusgabeAutomatRepo geldAusgabeAutomatRepo = new GeldAusgabeAutomatRepoImpl();

		TransaktionEvents transaktionEvents = new TransaktionEventsImpl(giroKontoRepo, geldAusgabeAutomatRepo);
		KundeEvents kundeEvents = new KundeEventsImpl(kundeRepo);
		BankEvents bankEvents = new BankEventsImpl(bankRepo);
		GiroKontoEvents giroKontoEvents = new GiroKontoEventsImpl(giroKontoRepo, bankRepo, kundeRepo);
		GeldAusgabeAutomatEvents geldAusgabeAutomatEvents = new GeldAusgabeAutomatEventsImpl(geldAusgabeAutomatRepo);

		BaseCommandParser commandParser = new BaseCommandParser(kundeEvents, bankEvents, giroKontoEvents, transaktionEvents, geldAusgabeAutomatEvents);

		TerminalHandler terminalHandler = new TerminalHandler(commandParser);
		terminalHandler.start();
	}

}
