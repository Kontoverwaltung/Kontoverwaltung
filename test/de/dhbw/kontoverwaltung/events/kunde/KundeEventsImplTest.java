package de.dhbw.kontoverwaltung.events.kunde;

import static org.junit.jupiter.api.Assertions.*;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import de.dhbw.kontoverwaltung.repositories.KundeRepo;
import de.dhbw.kontoverwaltung.repositories.returns.KundeReturn;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;
import de.dhbw.kontoverwaltung.types.Person;
import de.dhbw.kontoverwaltung.types.Person.PersonBuilder;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;

@TestMethodOrder(OrderAnnotation.class)
class KundeEventsImplTest {

	private static final String VORNAME = "Max";
	private static final String NACHNAME = "Muster";
	private static Person kunde = null;

	
	private KundeEventsImpl target = new KundeEventsImpl(new KundeRepo() {
		
		@Override
		public KundeReturn removeKunde(Person kunde) {
			assertThat(kunde.getKundenId(), is(kunde.getKundenId()));
			kunde = null;
			return new KundeReturn(true, kunde);
		}
		
		@Override
		public KundeReturn getKundeById(String kundenId) {
			if(kunde != null && kundenId.equals(kunde.getKundenId())) {
				return new KundeReturn(true, kunde);
			}
			return new KundeReturn(false, null);
		}
		
		@Override
		public KundeReturn addKunde(String vorname, String nachname) {
			assertThat(vorname, is(VORNAME));
			assertThat(nachname, is(NACHNAME));
			kunde = new PersonBuilder().vorname(vorname).nachname(nachname).build();
			return new KundeReturn(true, kunde);
		}
	});

	@Test
	@Order(1)
	void testCreateKunde() {
		CommandResult result = target.createNewKunde(VORNAME, NACHNAME);
		assertThat(result.isSuccessful(), is(true));
		assertThat(result.getAdditionalInfo(), is("kunde " + kunde.getKundenId() + " created"));
	}

	@Test
	@Order(2)
	void testKundeFound() {
		CommandResult result = target.getKunde(kunde.getKundenId());
		assertThat(result.isSuccessful(), is(true));
		assertThat(result.getAdditionalInfo(), is("Kunde [KundenID=" + kunde.getKundenId() + "]"));
	}

	@Test
	@Order(3)
	void testKundeDelete() {
		CommandResult result = target.deleteKunde(kunde.getKundenId());
		assertThat(result.isSuccessful(), is(true));
		assertThat(result.getAdditionalInfo(), is("kunde deleted"));
	}

	@Test
	@Order(4)
	void testKundeNotFound2() {
		kundeNotFound();
	}

	private void kundeNotFound() {
		CommandResult result = target.getKunde(kunde.getKundenId());
		assertThat(result.isSuccessful(), is(false));
		assertThat(result.getAdditionalInfo(), is("kunde not found"));
	}

}
