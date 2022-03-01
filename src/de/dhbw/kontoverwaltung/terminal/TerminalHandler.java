package de.dhbw.kontoverwaltung.terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import de.dhbw.kontoverwaltung.terminal.command.CommandListener;
import de.dhbw.kontoverwaltung.terminal.command.CommandResult;

public class TerminalHandler {

	private CommandListener commandListener;
	private Thread thread;

	public TerminalHandler(CommandListener commandListener) {
		this.commandListener = commandListener;
	}

	public void start() {
		thread = new Thread(() -> {
			while (!Thread.interrupted()) {
				try {
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					String input = reader.readLine();
					if (commandListener != null) {
						CommandResult result = commandListener.onInput(input);
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

}
