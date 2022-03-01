package de.dhbw.kontoverwaltung;

import de.dhbw.kontoverwaltung.events.kunde.KundeEventsImpl;
import de.dhbw.kontoverwaltung.terminal.TerminalHandler;
import de.dhbw.kontoverwaltung.terminal.command.BaseCommandParser;

public class KontoverwaltungApp {

	public static void main(String[] args) {
		KontoverwaltungApp app = new KontoverwaltungApp();
		app.start();
	}

	private void start() {
		KundeEventsImpl kundeEventsImpl = new KundeEventsImpl();

		BaseCommandParser commandParser = new BaseCommandParser(kundeEventsImpl);

		TerminalHandler terminalHandler = new TerminalHandler(commandParser);
		terminalHandler.start();
	}

}
