package de.dhbw.kontoverwaltung.terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalHandler {

	private CommandListener commandEvent;
	private Thread thread;

	public TerminalHandler() {
		startThread();
	}

	private void startThread() {
		thread = new Thread(() -> {
			while (!Thread.interrupted()) {
				try {
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					String input = reader.readLine();
					if (commandEvent != null) {
						commandEvent.onInput(input);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
	}

	public void stopThread() {
		thread.interrupt();
	}

	public void setCommandEvent(CommandListener commandEvent) {
		this.commandEvent = commandEvent;
	}

}
