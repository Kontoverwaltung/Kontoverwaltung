package de.dhbw.kontoverwaltung;

import de.dhbw.kontoverwaltung.events.automat.AutomatEvents;
import de.dhbw.kontoverwaltung.events.automat.AutomatEventsImpl;
import de.dhbw.kontoverwaltung.events.bank.BankEvents;
import de.dhbw.kontoverwaltung.events.bank.BankEventsImpl;
import de.dhbw.kontoverwaltung.events.konto.KontoEvents;
import de.dhbw.kontoverwaltung.events.konto.KontoEventsImpl;
import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.events.kunde.KundeEventsImpl;
import de.dhbw.kontoverwaltung.events.transfer.TransferEvents;
import de.dhbw.kontoverwaltung.events.transfer.TransferEventsImpl;
import de.dhbw.kontoverwaltung.repositories.AutomatRepo;
import de.dhbw.kontoverwaltung.repositories.AutomatRepoImpl;
import de.dhbw.kontoverwaltung.repositories.BankRepo;
import de.dhbw.kontoverwaltung.repositories.BankRepoImpl;
import de.dhbw.kontoverwaltung.repositories.KontoRepo;
import de.dhbw.kontoverwaltung.repositories.KontoRepoImpl;
import de.dhbw.kontoverwaltung.repositories.KundeRepo;
import de.dhbw.kontoverwaltung.repositories.KundeRepoImpl;
import de.dhbw.kontoverwaltung.terminal.TerminalHandler;
import de.dhbw.kontoverwaltung.terminal.command.BaseCommandParser;

public class KontoverwaltungApp {

	public static void main(String[] args) {
		KontoverwaltungApp app = new KontoverwaltungApp();
		app.start();
	}

	private void start() {
		KontoRepo kontoRepo = new KontoRepoImpl();
		BankRepo bankRepo = new BankRepoImpl();
		KundeRepo kundeRepo = new KundeRepoImpl();
		AutomatRepo automatRepo = new AutomatRepoImpl();

		TransferEvents transferEvents = new TransferEventsImpl(kontoRepo);
		KundeEvents kundeEvents = new KundeEventsImpl(kundeRepo);
		BankEvents bankEvents = new BankEventsImpl(bankRepo);
		KontoEvents kontoEvents = new KontoEventsImpl(kontoRepo, bankRepo, kundeRepo);
		AutomatEvents automatEvents = new AutomatEventsImpl(automatRepo);

		BaseCommandParser commandParser = new BaseCommandParser(kundeEvents, bankEvents, kontoEvents, transferEvents, automatEvents);

		TerminalHandler terminalHandler = new TerminalHandler(commandParser);
		terminalHandler.start();
	}

}
