package com.code42homework.service;

import java.util.ArrayList;
import java.util.List;

import com.code42homework.model.Org;

public class OrgEntityBuilder implements EntityBuilder<Org> {
	private List<Org> orgList = new ArrayList<>();

	@Override
	public void addEntityFromCsvLine(final String csvLine) {
		this.orgList.add(Org.generate(csvLine));
	}

	@Override
	public List<Org> getEntityList() {
		return this.orgList;
	}
}
