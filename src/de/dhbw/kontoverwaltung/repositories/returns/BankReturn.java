package de.dhbw.kontoverwaltung.repositories.returns;

import de.dhbw.kontoverwaltung.types.Bank;

public class BankReturn extends Return {

	private Bank instance;

	public BankReturn(boolean successful, Bank instance) {
		super(successful);
		this.instance = instance;
	}

	public Bank getInstance() {
		return instance;
	}
}
