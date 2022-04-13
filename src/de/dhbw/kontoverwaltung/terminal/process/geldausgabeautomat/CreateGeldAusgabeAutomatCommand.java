package de.dhbw.kontoverwaltung.terminal.process.geldausgabeautomat;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.geldausgabeautomat.GeldAusgabeAutomatEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class CreateGeldAusgabeAutomatCommand extends CommandParser {

	private GeldAusgabeAutomatEvents geldAusgabeAutomatEvents;

	public CreateGeldAusgabeAutomatCommand(GeldAusgabeAutomatEvents geldAusgabeAutomatEvents) {
		super();
		this.geldAusgabeAutomatEvents = geldAusgabeAutomatEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 4) {
			String geldAusgabeAutomatId = command.getStringAt(2);
			String betrag = command.getStringAt(3);
			return geldAusgabeAutomatEvents.createGeldAusgabeAutomat(geldAusgabeAutomatId, betrag);
		}
		return CommandResult.usage(command.getCommandUpToPos(2), Arrays.asList("geldausgabeautomat-id", "betrag"));
	}

}
