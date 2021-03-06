package de.dhbw.kontoverwaltung.database;

public interface KeyValueDatabase<T> {

	public T get(String key);

	public void set(String key, T object);

	public T remove(String key);

}
