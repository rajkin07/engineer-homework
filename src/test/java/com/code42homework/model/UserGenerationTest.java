package com.code42homework.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class UserGenerationTest {
    @Test
    public void generateUser() {
        Random random = new Random();
        int orgId = random.nextInt(100);
        int userId = random.nextInt(1000000);
        int numFiles = random.nextInt(50);

        String csvLine = String.format("%d, %d, %d", userId, orgId, numFiles);
        User user = User.generate(csvLine);

        Assert.assertEquals(orgId, user.getOrgId());
        Assert.assertEquals(userId, user.getUserId());
        Assert.assertEquals(numFiles, user.getNumFiles());
    }
}
