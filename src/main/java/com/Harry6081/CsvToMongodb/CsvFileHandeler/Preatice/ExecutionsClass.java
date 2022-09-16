package com.Harry6081.CsvToMongodb.CsvFileHandeler.Preatice;

import java.io.IOException;

public class ExecutionsClass {

    public static void execute(String command){
try {
    Runtime r = Runtime.getRuntime();
    Process p = null;
        p = r.exec(command);
        System.out.println("Reading csv into Database "+p);
    } catch (
    IOException e) {
        throw new RuntimeException(e);
    }

    }
}
