package de.dhbw.kontoverwaltung.database;

import java.util.List;

public interface FileHandler {

	public abstract void appendLine(String line);

	public abstract void deleteLine(String line);

	public boolean contains(String line);

	public List<String> readAllLines();

}
