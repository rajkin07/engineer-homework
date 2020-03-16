package com.code42homework.service;

import java.util.List;

public interface EntityBuilder<T> {
	void addEntityFromCsvLine(String csvLine);
	List<T> getEntityList();
}
