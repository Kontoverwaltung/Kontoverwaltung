package de.dhbw.kontoverwaltung;

import de.dhbw.kontoverwaltung.terminal.TerminalHandler;

public class KontoverwaltungApp {

	public static void main(String[] args) {
		KontoverwaltungApp app = new KontoverwaltungApp();
		app.start();
	}

	private void start() {
		TerminalHandler terminalHandler = new TerminalHandler();
		terminalHandler.setCommandEvent(input -> {
			System.out.println("Input: " + input);
		});
	}

}
