package com.code42homework.model;

import java.util.List;

public interface OrgCollection {
    Org getOrg(int orgId);
    List<Org> getOrgTree(int orgId, boolean inclusive);
}
