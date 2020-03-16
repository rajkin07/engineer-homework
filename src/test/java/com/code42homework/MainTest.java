package com.code42homework;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainTest {

    //@Test
    public void testMain() throws IOException {
        System.out.println("main");
        String[] args = null;
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File("[path_to_file]"));
        System.setIn(fips);
        Main.main(args);
        System.setIn(original);
    }

  /*  @Test
    public void testMain() {
        instance = new CrashAndBurn();
        String [] args = { "one", "two", "three" };
        exit.expectSystemExitWithStatus(1);
        main(args);
    }*/
}
