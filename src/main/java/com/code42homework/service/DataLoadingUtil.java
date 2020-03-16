package com.code42homework.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


public class DataLoadingUtil {

	public static <T> List<T> loadData(final String inputDataFileSpec, EntityBuilder<T> entityBuilder) {
		assert isInputFileValid(inputDataFileSpec);

		File inputDataFile = new File(inputDataFileSpec);
		if (!inputDataFile.exists() || !inputDataFile.canRead()) {
			throw new RuntimeException(String.format("File data file '%s' does not exist or cannot be read.",
					inputDataFile.getAbsolutePath()));
		}

		try (Scanner scanner = new Scanner(inputDataFile)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				entityBuilder.addEntityFromCsvLine(line);
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(String.format("Error reading input file '%s'", inputDataFile.getAbsolutePath()), e);
		}

		final List<T> entityList = entityBuilder.getEntityList();
		System.out.println(String.format("Loaded data from file '%s'; Entity count: %d", inputDataFileSpec, entityList.size()));
		return entityList;
	}

	private static boolean isInputFileValid(String filespec) {
		File file = new File(filespec);
		boolean success = file.exists() && file.canRead();

		System.out.println(String.format("Validated input file '%s'; success: %s", file.getAbsolutePath(), success));

		return success;
	}
}
