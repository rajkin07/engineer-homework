package com.code42homework.model;

public class Org {
    public static final int ROOT_ORG_PARENT_ORG_ID = 0;
    private static final int ORG_DATA_TOKENS_PER_LINE = 3;

    private int parentId;
    private int id;
    private String name;

    private Org(int parentId, int id, String name) {
        this.parentId = parentId;
        this.id = id;
        this.name = name;
    }

    public static Org generate(final String csvLine) {
        String[] tokens = csvLine.split(",");

        if(tokens.length != ORG_DATA_TOKENS_PER_LINE) {
            throw new RuntimeException(String.format("Invalid line found in Org hierarchy input file: %s", csvLine));
        }

        int orgId = Integer.parseInt(tokens[0].trim());
        int parentOrgId;

        try {
            parentOrgId = Integer.parseInt(tokens[1].trim());
        } catch (NumberFormatException e) {
            // This is where we catch 'null' parent Org ID
            parentOrgId = Org.ROOT_ORG_PARENT_ORG_ID;
        }

        String orgName = tokens[2].trim();

        return new Org(parentOrgId, orgId, orgName);
    }

    public int getParentId() {
        return parentId;
    }

    public int getId() {
        return id;
    }

    public String  getName() {
        return name;
    }

}
