package com.codecool;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FileWordAnalyzerTest {

    static FilePartReader filePartReader;

    static FileWordAnalyzer fileWordAnalyzer;

    @BeforeAll
    static void beforeAll() throws IOException {
        filePartReader = mock(FilePartReader.class);
        when(filePartReader.readLines()).thenReturn("wow you look great anna");
        fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    }

    @Test
    public void testIfReturnPalindromes() throws IOException {
        ArrayList<String> expectedOutput = new ArrayList<>(Arrays.asList("wow", "anna"));
        assertEquals(expectedOutput, fileWordAnalyzer.getStringsWhichPalindromes());
    }

    @Test
    public void testIfReturnOnlyExpectedSubstring() throws IOException {
        ArrayList<String> expectedOutput = new ArrayList<>(Collections.singletonList("look"));
        assertEquals(expectedOutput, fileWordAnalyzer.getWordsContainingSubstring("loo"));
    }

    @Test
    public void testIfReturnWordsOrderedFromAtoZ() throws IOException {
        ArrayList<String> expectedOutput = new ArrayList<>(Arrays.asList("anna","great", "look", "wow", "you"));
        assertEquals(expectedOutput, fileWordAnalyzer.getWordsOrderedAlphabetically());
    }
}