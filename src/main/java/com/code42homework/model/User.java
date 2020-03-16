package com.code42homework.model;

public class User {
    private static final int USER_DATA_TOKENS_PER_LINE = 3;

    private int userId;
    private int orgId;
    private int numFiles;

    public static User generate(String csvLine) {
        String[] tokens = csvLine.split(",");

        if(tokens.length != USER_DATA_TOKENS_PER_LINE) {
            throw new RuntimeException(String.format("Invalid line found in User data input file: %s", csvLine));
        }

        return new User(Integer.parseInt(tokens[0].trim()), Integer.parseInt(tokens[1].trim()), Integer.parseInt(tokens[2].trim()));
    }

    private User(final int userId, final int orgId, final int numFiles) {
        this.userId = userId;
        this.orgId = orgId;
        this.numFiles = numFiles;
    }

    public int getUserId() {
        return userId;
    }

    public int getOrgId() {
        return orgId;
    }

    public int getNumFiles() {
        return numFiles;
    }
}
