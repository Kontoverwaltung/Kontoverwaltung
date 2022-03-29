package de.dhbw.kontoverwaltung.events.bank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import de.dhbw.kontoverwaltung.repositories.BankRepo;
import de.dhbw.kontoverwaltung.repositories.returns.BankReturn;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;
import de.dhbw.kontoverwaltung.types.Bank;

@TestMethodOrder(OrderAnnotation.class)
class BankEventsImplTest {

	private static final String BANK_NAME = "testbank";

	private static Bank bank = null;

	private BankEventsImpl target = new BankEventsImpl(new BankRepo() {
		@Override
		public BankReturn removeBankByName(String bankName) {
			assertThat(bankName, is(BANK_NAME));
			bank = null;
			return new BankReturn(true, bank);
		}

		@Override
		public BankReturn getBankByName(String bankName) {
			if (bank != null && bankName.equals(BANK_NAME)) {
				return new BankReturn(true, bank);
			} else {
				return new BankReturn(false, null);
			}
		}

		@Override
		public BankReturn addBank(String bankName) {
			assertThat(bankName, is(BANK_NAME));
			bank = new Bank(bankName);
			return new BankReturn(true, bank);
		}
	});

	@Test
	@Order(1)
	void testBankNotFound1() {
		bankNotFound();
	}

	@Test
	@Order(2)
	void testCreateBank() {
		CommandResult result = target.createBank(BANK_NAME);
		assertThat(result.isSuccessful(), is(true));
		assertThat(result.getAdditionalInfo(), is("bank created"));
	}

	@Test
	@Order(3)
	void testBankFound() {
		CommandResult result = target.getBank(BANK_NAME);
		assertThat(result.isSuccessful(), is(true));
		assertThat(result.getAdditionalInfo(), is("Bank [Name=testbank]"));
	}

	@Test
	@Order(4)
	void testBankDelete() {
		CommandResult result = target.deleteBank(BANK_NAME);
		assertThat(result.isSuccessful(), is(true));
		assertThat(result.getAdditionalInfo(), is("bank deleted"));
	}

	@Test
	@Order(5)
	void testBankNotFound2() {
		bankNotFound();
	}

	private void bankNotFound() {
		CommandResult result = target.getBank(BANK_NAME);
		assertThat(result.isSuccessful(), is(false));
		assertThat(result.getAdditionalInfo(), is("failed to load bank"));
	}

}
