package de.dhbw.kontoverwaltung.database;

import java.util.ArrayList;
import java.util.List;

public class FileHandlerMock implements FileHandler {

	private List<String> list = new ArrayList<String>();

	@Override
	public void appendLine(String line) {
		list.add(line);
	}

	@Override
	public void deleteLine(String line) {
		list.remove(line);
	}

	@Override
	public boolean contains(String line) {
		return list.contains(line);
	}

	@Override
	public List<String> readAllLines() {
		return new ArrayList<>(list);
	}

}
