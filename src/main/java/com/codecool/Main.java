package com.codecool;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final FilePartReader filePartReader = new FilePartReader();
    private static final FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

    public static void main(String[] args) throws IOException {

        filePartReader.setup("src/main/resources/test.txt",1,7);
        System.out.println("TEST1:");
        ArrayList<String> test1 = fileWordAnalyzer.getWordsOrderedAlphabetically();
        test1.forEach(System.out::println);

        System.out.println("TEST2:");
        ArrayList<String> test2 = fileWordAnalyzer.getWordsContainingSubstring("ta");
        test2.forEach(System.out::println);

        System.out.println("TEST3:");
        ArrayList<String> test3 = fileWordAnalyzer.getStringsWhichPalindromes();
        test3.forEach(System.out::println);
    }
}
