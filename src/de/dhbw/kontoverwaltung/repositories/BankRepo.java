package de.dhbw.kontoverwaltung.repositories;

import java.io.Serializable;

import de.dhbw.kontoverwaltung.database.FileHandlerImpl;
import de.dhbw.kontoverwaltung.database.PersistentDatabase;
import de.dhbw.kontoverwaltung.repositories.returns.BankReturn;
import de.dhbw.kontoverwaltung.types.Bank;

public class BankRepo {

	private static PersistentDatabase<Serializable> bankDatabase = new PersistentDatabase<>(
			new FileHandlerImpl("Bank"));

	public static BankReturn getBankByName(String bankName) {
		Bank bank = (Bank) bankDatabase.get(bankName);
		if (bank != null) {
			return new BankReturn(true, bank);
		}
		return new BankReturn(false, null);
	}

	public static BankReturn addBank(String bankName) {
		Bank neueBank = new Bank(bankName);
		bankDatabase.set(neueBank.getName(), neueBank);
		return new BankReturn(true, neueBank);
	}

	public static BankReturn removeBankByName(String bankName) {
		Bank bank = (Bank) bankDatabase.get(bankName);
		if (bank != null) {
			bankDatabase.remove(bankName);
			return new BankReturn(true, bank);
		}
		return new BankReturn(false, null);
	}
}
