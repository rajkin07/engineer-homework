package com.code42homework.service;

import java.io.File;
import java.util.List;

import com.code42homework.model.Org;
import com.code42homework.model.User;
import org.junit.Assert;
import org.junit.Test;

/*
* Assertions in this test set are based on the specific test files bundled with the project.
 */
public class DataLoadingUtilTest {
	private static final String InputFileFolder = "build".concat(File.separator).concat("inputFiles");
	//private static final String InputFileFolder = "build".concat(File.separator).concat("resources");
	private static final String OrgHierarchyDataFile = "OrgHierarchyData.csv";
	private static final String UserDataFile = "UserData.csv";

	private static final int RootOrgCount = 2;
	private static final int OrgCount = 12;
	private static final int UserCount = 10;
	private static final int FileCount = 220;



	@Test
	public void testLoadData_Org() {
		String inputFileSpec = InputFileFolder.concat(File.separator).concat(OrgHierarchyDataFile);
		final List<Org> orgList = DataLoadingUtil.loadData(inputFileSpec, new OrgEntityBuilder());
		Assert.assertNotNull(orgList);
		Assert.assertEquals(OrgCount, orgList.size());

		// Make sure there is exactly one root Org
		long rootCount = orgList.stream().filter(org -> org.getParentId() == Org.ROOT_ORG_PARENT_ORG_ID).count();
		Assert.assertEquals(RootOrgCount, rootCount);
	}

	@Test
	public void testLoadData_User() {
		String inputFileSpec = InputFileFolder.concat(File.separator).concat(UserDataFile);
		final List<User> userList = DataLoadingUtil.loadData(inputFileSpec, new UserEntityBuilder());
		Assert.assertNotNull(userList);
		Assert.assertEquals(UserCount, userList.size());

		// Make sure the total number of files matches the expected.
		int actualFileCount = userList.stream().mapToInt(User::getNumFiles).sum();
		Assert.assertEquals(FileCount, actualFileCount);
	}

	/**
	 * if File path  invalid or file not exist.
	 *
	 * @throws AssertionError  We expect that AssertionError which is thrown from loadData Method.
	 */
	@Test(expected = AssertionError.class)
	public void fileNotExistRead(){
		String inputFileSpec = File.separator.concat(OrgHierarchyDataFile);
		DataLoadingUtil.loadData(inputFileSpec, new OrgEntityBuilder());
	}
}
