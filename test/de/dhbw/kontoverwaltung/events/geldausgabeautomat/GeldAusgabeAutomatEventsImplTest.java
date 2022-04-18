package de.dhbw.kontoverwaltung.events.geldausgabeautomat;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import de.dhbw.kontoverwaltung.events.bank.BankEventsImpl;
import de.dhbw.kontoverwaltung.repositories.BankRepo;
import de.dhbw.kontoverwaltung.repositories.GeldAusgabeAutomatRepo;
import de.dhbw.kontoverwaltung.repositories.returns.BankReturn;
import de.dhbw.kontoverwaltung.repositories.returns.GeldAusgabeAutomatReturn;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;
import de.dhbw.kontoverwaltung.types.Bank;
import de.dhbw.kontoverwaltung.types.EuroCentBetrag;
import de.dhbw.kontoverwaltung.types.GeldAusgabeAutomat;

@TestMethodOrder(OrderAnnotation.class)
class GeldAusgabeAutomatEventsImplTest {

	private static final String AUTOMAT_ID = "testautomat";
	private static final EuroCentBetrag BETRAG = new EuroCentBetrag(10, 20);

	private static GeldAusgabeAutomat automat = null;
	
	private GeldAusgabeAutomatEventsImpl target = new GeldAusgabeAutomatEventsImpl(new GeldAusgabeAutomatRepo() {
		
		@Override
		public GeldAusgabeAutomatReturn updateBetrag(GeldAusgabeAutomat geldAusgabeAutomat, EuroCentBetrag betrag) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public GeldAusgabeAutomatReturn removeGeldAusgabeAutomat(GeldAusgabeAutomat geldAusgabeAutomat) {
			assertThat(geldAusgabeAutomat.getAutomatId(), is(AUTOMAT_ID));
			automat = null;
			return new GeldAusgabeAutomatReturn(true, automat);
		}
		
		@Override
		public GeldAusgabeAutomatReturn getGeldAusgabeAutomatById(String geldAusgabeAutomatId) {
			if(automat != null && geldAusgabeAutomatId.equals(AUTOMAT_ID)) {
				return new GeldAusgabeAutomatReturn(true, automat);
			}
			return new GeldAusgabeAutomatReturn(false, null);
		}
		
		@Override
		public GeldAusgabeAutomatReturn addGeldAusgabeAutomat(String geldAusgabeAutomatId, EuroCentBetrag betrag) {
			assertThat(geldAusgabeAutomatId, is(AUTOMAT_ID));
			assertThat(betrag.getEuro(), is(BETRAG.getEuro()));
			assertThat(betrag.getCent(), is(BETRAG.getCent()));
			automat = new GeldAusgabeAutomat(geldAusgabeAutomatId, betrag);
			return new GeldAusgabeAutomatReturn(true, automat);
		}
	});

	@Test
	@Order(1)
	void testAutomatNotFound1() {
		automatNotFound();
	}

	@Test
	@Order(2)
	void testCreateAutomat() {
		CommandResult result = target.createGeldAusgabeAutomat(AUTOMAT_ID, "20.10");
		assertThat(result.isSuccessful(), is(true));
		assertThat(result.getAdditionalInfo(), is("geldausgabeautomat testautomat created"));
	}

	@Test
	@Order(3)
	void testAutomatFound() {
		CommandResult result = target.getGeldAusgabeAutomat(AUTOMAT_ID);
		assertThat(result.isSuccessful(), is(true));
		assertThat(result.getAdditionalInfo(), is("Automat [AutomatID=testautomat]"));
	}

	@Test
	@Order(4)
	void testAutomatDelete() {
		CommandResult result = target.deleteGeldAusgabeAutomat(AUTOMAT_ID);
		assertThat(result.isSuccessful(), is(true));
		assertThat(result.getAdditionalInfo(), is("geldausgabeautomat deleted"));
	}

	@Test
	@Order(5)
	void testAutomatNotFound2() {
		automatNotFound();
	}

	private void automatNotFound() {
		CommandResult result = target.getGeldAusgabeAutomat(AUTOMAT_ID);
		assertThat(result.isSuccessful(), is(false));
		assertThat(result.getAdditionalInfo(), is("failed to load geldausgabeautomat"));
	}

}
