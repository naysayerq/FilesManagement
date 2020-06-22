/*
 *
 * Classname Main
 *
 * Version 1.0
 *
 * Copyright Skryp Andriy
 *
 *
 *   Module 4 Task 1
 *
 *   Home task. Files management.
 *
 *  1. Parse the file logs.txt (see the attachment).  Extract to a separate file all the logs from October 2019.
 *
 *  2. Calculate the total number of logs (lines).
 *
 *  3. Calculate the total number of ERROR logs. Use previous skills - String.split
 *
 *  4. Calculate the total number of ERROR logs. Use Files.lines.
 *
 *  5. Compare two results.
 *
 */

package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) throws IOException {


        // 1. Parse the file logs.txt (see the attachment). Extract to a separate file all the logs from October 2019.

        LocalDateTime startStringSplitTime = LocalDateTime.now();

	    String myString = new String(Files.readAllBytes(Paths
                .get("C:/Users/Intel/Downloads/logs.txt")));


	    // 2. Calculate the total number of logs (lines).

	    String[] lines = myString.split("\n");
        System.out.println("Total number of logs (lines): " + lines.length);


        // 3. Calculate the total number of ERROR logs. Use previous skills - String.split

        int errorLinesCount = 0;

        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains("ERROR")){
                errorLinesCount++;
            }
        }

        System.out.println("Total number of ERROR logs (first method): "
                + errorLinesCount);

        LocalDateTime finishStringSplitTime = LocalDateTime.now();


        // 4. Calculate the total number of ERROR logs. Use Files.lines.

        LocalDateTime startFilesLinesTime = LocalDateTime.now();

        long errors = Files.lines(Paths.get("C:/Users/Intel/Downloads/logs.txt"))
                .filter(line -> line.contains("ERROR"))
                .count();

        LocalDateTime finishFilesLinesTime = LocalDateTime.now();

        System.out.println("Total number of ERROR logs (second method): "
                + errors);


        // 5. Compare two results.

        System.out.println("-----COMPARING-----");
        System.out.println("String.split result is: " + ChronoUnit.MILLIS.between
                (startStringSplitTime, finishStringSplitTime) + " milliseconds");
        System.out.println("Files.lines result is: " + ChronoUnit.MILLIS.between
                (startFilesLinesTime, finishFilesLinesTime) + " milliseconds");


    }
}
