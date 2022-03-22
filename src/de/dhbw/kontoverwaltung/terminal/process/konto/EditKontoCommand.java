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

public class EditKontoCommand extends CommandParser {

	private KontoEvents kontoEvents;

	public EditKontoCommand(KontoEvents kontoEvents) {
		super();
		this.kontoEvents = kontoEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 8) {
			String oldKontoId = command.getStringAt(2);
			String newBankName = command.getStringAt(3);
			String newKundenId = command.getStringAt(4);
			int newBetragEuro = Integer.parseInt(command.getStringAt(5));
			int newBetragCent = Integer.parseInt(command.getStringAt(6));
			String newPin = command.getStringAt(7);
			return kontoEvents.editKonto(oldKontoId, BankRepo.getBankByName(newBankName).getInstance(),
					KundeRepo.getKundeById(newKundenId).getInstance(), new Betrag(newBetragCent, newBetragEuro),
					new Pin(newPin));
		}
		return CommandResult.usage(command.getCommandUpToPos(2),
				Arrays.asList("kontoid", "bankname", "kundenid", "euro", "cent", "pin"));
	}
}
