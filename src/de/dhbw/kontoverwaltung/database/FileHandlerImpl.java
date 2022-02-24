package de.dhbw.kontoverwaltung.database;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class FileHandlerImpl implements FileHandler {

	private File file;

	public FileHandlerImpl(String fileName) {
		file = new File(fileName);
		createFileIfNotExists();
	}

	private void createFileIfNotExists() {
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void appendLine(String line) {
		try {
			line+="\n";
			Files.write(file.toPath(), line.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteLine(String line) {
		try {
			List<String> out = Files.lines(file.toPath()).filter(l -> !l.equals(line)).collect(Collectors.toList());
			Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> readAllLines() {
		try {
			return Files.readAllLines(file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean contains(String line) {
		return readAllLines().contains(line);
	}

}
