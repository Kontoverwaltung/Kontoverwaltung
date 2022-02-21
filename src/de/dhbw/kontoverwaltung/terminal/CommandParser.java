package de.dhbw.kontoverwaltung.terminal;

import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;

public class CommandParser implements CommandListener {

	private KundeEvents kundeEvents;

	public CommandParser(KundeEvents kundeEvents) {
		super();
		this.kundeEvents = kundeEvents;
	}

	@Override
	public CommandResult onInput(String input) {
		String[] split = input.split(" ");

		CommandGroup commandGroup = CommandGroup.valueOf(split[0].toUpperCase());

		if (commandGroup == CommandGroup.KUNDE) {
			CommandMethod commandMethod = CommandMethod.valueOf(split[1].toUpperCase());

			if (commandMethod == CommandMethod.CREATE) {
				if (split.length == 5) {
					String bankName = split[2];
					String vorname = split[3];
					String nachname = split[4];
					return kundeEvents.createNewKunde(bankName, vorname, nachname);
				}
			}
		}

		return CommandResult.error("command not found");
	}

	public enum CommandGroup {
		KUNDE, KONTO;
	}

	public enum CommandMethod {
		CREATE;
	}

}
