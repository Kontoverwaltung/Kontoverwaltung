package de.dhbw.kontoverwaltung.repositories;

import de.dhbw.kontoverwaltung.repositories.returns.BankReturn;
import de.dhbw.kontoverwaltung.types.Bank;

public interface BankRepo {

	public BankReturn getBankByName(String bankName);

	public BankReturn addBank(String bankName);

	public BankReturn removeBank(Bank bank);

}
