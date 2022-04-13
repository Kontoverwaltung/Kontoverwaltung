package de.dhbw.kontoverwaltung.terminal.process.geldausgabeautomat;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.geldausgabeautomat.GeldAusgabeAutomatEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class GetGeldAusgabeAutomatCommand extends CommandParser {

	private GeldAusgabeAutomatEvents geldAusgabeAutomatEvents;

	public GetGeldAusgabeAutomatCommand(GeldAusgabeAutomatEvents geldAusgabeAutomatEvents) {
		super();
		this.geldAusgabeAutomatEvents = geldAusgabeAutomatEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 3) {
			String geldAusgabeAutomatId = command.getStringAt(2);
			return geldAusgabeAutomatEvents.getGeldAusgabeAutomat(geldAusgabeAutomatId);
		}
		return CommandResult.usage(command.getCommandUpToPos(2), Arrays.asList("geldausgabeautomat-id"));
	}

}
