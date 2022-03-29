package de.dhbw.kontoverwaltung.repositories;

import de.dhbw.kontoverwaltung.repositories.returns.BankReturn;

public interface BankRepo {

	public BankReturn getBankByName(String bankName);

	public BankReturn addBank(String bankName);

	public BankReturn removeBankByName(String bankName);

}
