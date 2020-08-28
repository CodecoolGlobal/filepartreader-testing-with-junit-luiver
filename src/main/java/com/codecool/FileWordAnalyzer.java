package com.codecool;

import java.io.IOException;
import java.util.ArrayList;

public class FileWordAnalyzer {
    private final FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public ArrayList<String> getWordsOrderedAlphabetically (){

    }

    public ArrayList<String> getWordsContainingSubstring (String subString ) {

    }

    public ArrayList<String> getStringsWhichPalindromes () {

    }

    private Boolean isPalindrome(){

    }

    private String[] getWords() throws IOException {
        String readText = filePartReader.readLines();
        return readText.replaceAll("[^A-za-z ]", "").split("\\s+");
    }

}
