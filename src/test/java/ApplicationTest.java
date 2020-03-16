import com.code42homework.Main;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.rules.ExpectedException;

import java.io.File;

public class ApplicationTest extends Main {
    private static final String InputFileFolder = "build".concat(File.separator).concat("inputFiles");
    //private static final String InputFileFolder = "build".concat(File.separator).concat("resources");
    private static final String OrgHierarchyDataFile = "OrgHierarchyData.csv";
    private static final String UserDataFile = "UserData.csv";


    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test(expected = RuntimeException.class)
    public void testMainOutFolderNotExist() {
        String inputFileOrgHierachy = InputFileFolder.concat(File.separator).concat(OrgHierarchyDataFile);
        String inputFileUserData = InputFileFolder.concat(File.separator).concat(UserDataFile);
        String outputFileFolder = "build".concat(File.separator).concat("outputFolder");
        String [] args = { inputFileOrgHierachy,inputFileUserData, outputFileFolder };
        main(args);
    }

    /**
     *
     */
    @Test(expected = RuntimeException.class)
    public void systemExitWithSelectedStatusCode1() {
        String inputFileOrgHierachy = InputFileFolder.concat(File.separator).concat(OrgHierarchyDataFile);
        String inputFileUserData = InputFileFolder.concat(File.separator).concat(UserDataFile);
        String [] args = { inputFileOrgHierachy,inputFileUserData };
        main(args);
        exit.expectSystemExitWithStatus(1);
        System.exit(1);
    }
}
