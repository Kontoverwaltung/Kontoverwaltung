package de.dhbw.kontoverwaltung;

import de.dhbw.kontoverwaltung.events.bank.BankEvents;
import de.dhbw.kontoverwaltung.events.bank.BankEventsImpl;
import de.dhbw.kontoverwaltung.events.konto.KontoEvents;
import de.dhbw.kontoverwaltung.events.konto.KontoEventsImpl;
import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.events.kunde.KundeEventsImpl;
import de.dhbw.kontoverwaltung.events.transfer.TransferEvents;
import de.dhbw.kontoverwaltung.events.transfer.TransferEventsImpl;
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

		TransferEvents transferEvents = new TransferEventsImpl(kontoRepo);
		KundeEvents kundeEventsImpl = new KundeEventsImpl(bankRepo, kundeRepo);
		BankEvents bankEventsImpl = new BankEventsImpl(bankRepo);
		KontoEvents kontoEventsImpl = new KontoEventsImpl(kontoRepo, bankRepo, kundeRepo);

		BaseCommandParser commandParser = new BaseCommandParser(kundeEventsImpl, bankEventsImpl, kontoEventsImpl, transferEvents);

		TerminalHandler terminalHandler = new TerminalHandler(commandParser);
		terminalHandler.start();
	}

}
