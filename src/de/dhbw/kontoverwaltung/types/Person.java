package de.dhbw.kontoverwaltung.types;

import java.io.Serializable;

import de.dhbw.kontoverwaltung.util.UniqueIdGenerator;

public class Person implements Serializable {

	protected String vorname;
	protected String nachname;

	private String kundenId;

	public String getKundenId() {
		return kundenId;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	@Override
	public String toString() {
		return "Kunde [KundenID=" + kundenId + "]";
	}

	public static class PersonBuilder {

		private String vorname;
		private String nachname;
		private String kundenId;

		public PersonBuilder vorname(String vorname) {
			this.vorname = vorname;
			return PersonBuilder.this;
		}

		public PersonBuilder nachname(String nachname) {
			this.nachname = nachname;
			return PersonBuilder.this;
		}

		public PersonBuilder kundenId(String kundenId) {
			this.kundenId = kundenId;
			return PersonBuilder.this;
		}

		public Person build() {
			if (this.vorname == null) {
				throw new NullPointerException();
			}
			if (this.nachname == null) {
				throw new NullPointerException();
			}
			if (this.kundenId == null) {
				this.kundenId = UniqueIdGenerator.next();
			}
			return new Person(this);
		}
	}

	private Person(PersonBuilder builder) {
		this.vorname = builder.vorname;
		this.nachname = builder.nachname;
		this.kundenId = builder.kundenId;
	}

}
