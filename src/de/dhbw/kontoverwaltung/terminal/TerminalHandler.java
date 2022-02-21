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
						CommandResult result = commandEvent.onInput(input);
						printResult(result);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
	}

	private void printResult(CommandResult result) {
		System.out.println(result.toString());
	}

	public void stopThread() {
		thread.interrupt();
	}

	public void setCommandParser(CommandListener commandEvent) {
		this.commandEvent = commandEvent;
	}

}
