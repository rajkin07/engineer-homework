package com.code42homework.model;

import java.util.Random;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class OrgGenerationTest {

	@Test
	public void generateOrg() {
		Random random = new Random();
		int parentOrgId = random.nextInt(1000);
		int orgId = random.nextInt(1000);
		String name = UUID.randomUUID().toString();

		String csvLine = String.format("%d, %d, %s", orgId, parentOrgId, name);
		Org org = Org.generate(csvLine);

		Assert.assertEquals(parentOrgId, org.getParentId());
		Assert.assertEquals(orgId, org.getId());
		Assert.assertEquals(name, org.getName());
	}
}
