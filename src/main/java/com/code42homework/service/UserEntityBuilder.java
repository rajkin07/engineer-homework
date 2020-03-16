package com.code42homework.service;

import java.util.ArrayList;
import java.util.List;

import com.code42homework.model.User;

public class UserEntityBuilder implements EntityBuilder<User> {
	private List<User> userList = new ArrayList<>();

	@Override
	public void addEntityFromCsvLine(final String csvLine) {
		this.userList.add(User.generate(csvLine));
	}

	@Override
	public List<User> getEntityList() {
		return this.userList;
	}
}
