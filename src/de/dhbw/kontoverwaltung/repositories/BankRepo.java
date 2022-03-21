package de.dhbw.kontoverwaltung.repositories;

import java.util.ArrayList;
import java.util.List;

import de.dhbw.kontoverwaltung.repositories.returns.BankReturn;
import de.dhbw.kontoverwaltung.types.Bank;

public class BankRepo {

	private static List<Bank> banken = new ArrayList<>();

	public static BankReturn getBankByName(String bankName) {
		for (Bank bank : banken) {
			if (bank.getName().equals(bankName)) {
				return new BankReturn(true, bank);
			}
		}
		return new BankReturn(false, null);
	}

	public static BankReturn addBank(String bankName) {
		Bank neueBank = new Bank(bankName);
		banken.add(neueBank);
		return new BankReturn(true, neueBank);
	}

	public static BankReturn removeBankByName(String bankName) {
		for (Bank bank : banken) {
			if (bank.getName().equals(bankName)) {
				banken.remove(bank);
				return new BankReturn(true, bank);
			}
		}
		return new BankReturn(false, null);
	}
}
