package com.dmitriy.packplanner.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
    public static List<String> readInput() throws IOException {
        System.out.println("Please, enter your data in the following format:\n" +
                "[Sort order],[max pieces per pack],[max weight per pack]\n" +
                "[item id],[item length],[item quantity],[piece weight]\n" +
                "[item id],[item length],[item quantity],[piece weight]\n" +
                "[item id],[item length],[item quantity],[piece weight]\n\n" +
                "Start from next line:\n");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputList = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) {
                break;
            }
            inputList.add(line);
        }
        return inputList;
    }
}
