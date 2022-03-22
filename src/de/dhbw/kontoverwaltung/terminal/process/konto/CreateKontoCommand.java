package de.dhbw.kontoverwaltung.terminal.process.konto;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.konto.KontoEvents;
import de.dhbw.kontoverwaltung.repositories.BankRepo;
import de.dhbw.kontoverwaltung.repositories.KundeRepo;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;
import de.dhbw.kontoverwaltung.types.Betrag;
import de.dhbw.kontoverwaltung.types.Pin;

public class CreateKontoCommand extends CommandParser {

	private KontoEvents kontoEvents;

	public CreateKontoCommand(KontoEvents kontoEvents) {
		super();
		this.kontoEvents = kontoEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 7) {
			String bankName = command.getStringAt(2);
			String kundenId = command.getStringAt(3);
			int betragEuro = Integer.parseInt(command.getStringAt(4));
			int betragCent = Integer.parseInt(command.getStringAt(5));
			String pin = command.getStringAt(6);
			return kontoEvents.createNewKonto(BankRepo.getBankByName(bankName).getInstance(),
					KundeRepo.getKundeById(kundenId).getInstance(), new Betrag(betragCent, betragEuro), new Pin(pin));
		}
		return CommandResult.usage(command.getCommandUpToPos(2),
				Arrays.asList("bankname", "kundenid", "euro", "cent", "pin"));
	}
}
