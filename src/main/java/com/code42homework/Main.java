package com.code42homework;

import java.io.File;
import java.util.List;

import com.code42homework.model.Org;
import com.code42homework.model.User;
import com.code42homework.service.DataLoadingUtil;
import com.code42homework.service.OrgEntityBuilder;
import com.code42homework.service.UserEntityBuilder;

public class Main {
    private static final int NUM_ARGS_EXPECTED = 3;

    /**
     * Parameters:
     *  Fully qualified path to the input test file OrgHierarchyData.csv
     *  Fully qualified path to the input test file UserData.csv
     *  Fully qualified path to the output folder
     */
    public static void main(String args[]) {
        if (args.length != NUM_ARGS_EXPECTED) {
            System.err.println(String.format("Wrong number of command arguments; expected: %d; actual: %d", NUM_ARGS_EXPECTED, args.length));
            System.err.println("Expected arguments: [Org Hierarchy file spec] [User Data file spec] [Output file folder]");
            System.exit(1);
        }

        String orgHierarchyFileSpec = args[0];
        String userDataFileSpec = args[1];
        String outputFolderSpec = args[2];

        File outputFolder = new File(outputFolderSpec);
        if (!outputFolder.exists() || !outputFolder.isDirectory()) {
            throw new RuntimeException(String.format("Output folder '%s' does not exist or is not a folder.",
                    outputFolder.getAbsolutePath()));
        }

        List<Org> orgList = DataLoadingUtil.loadData(orgHierarchyFileSpec, new OrgEntityBuilder());
        List<User> userList = DataLoadingUtil.loadData(userDataFileSpec, new UserEntityBuilder());

        // TODO: Implement the specified functionality using the two linear lists above.
    }
}
