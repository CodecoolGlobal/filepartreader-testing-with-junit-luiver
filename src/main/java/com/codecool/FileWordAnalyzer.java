package com.codecool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWordAnalyzer {
    private final FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public ArrayList<String> getWordsOrderedAlphabetically() throws IOException {
        String[] allWords = getWords();
        Arrays.sort(allWords);
        return new ArrayList<>(Arrays.asList(allWords));

    }

    public ArrayList<String> getWordsContainingSubstring(String subString) throws IOException {
        String[] allWords = getWords();
        ArrayList<String> wordWithSubstring = new ArrayList<>();
        for (String word : allWords) {
            if (word.contains(subString)) {
                wordWithSubstring.add(word);
            }
        }
        return wordWithSubstring;
    }

    public ArrayList<String> getStringsWhichPalindromes() throws IOException {
        String[] allWords = getWords();
        ArrayList<String> palindromes = new ArrayList<>();
        for (String word : allWords) {
            if (isPalindrome(word)) {
                palindromes.add(word);
            }
        }
        return palindromes;
    }

    private Boolean isPalindrome(String s){
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

    private String[] getWords() throws IOException {
        return filePartReader.readLines().split("\\s+");
    }

}
