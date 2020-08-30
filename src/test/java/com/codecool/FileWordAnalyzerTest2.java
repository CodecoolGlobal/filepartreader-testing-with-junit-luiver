package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FileWordAnalyzerTest2 {

    @Mock
    static FilePartReader filePartReader;

    @InjectMocks
    FileWordAnalyzer fileWordAnalyzer;

    @BeforeEach
    void init() throws IOException {
        when(filePartReader.readLines()).thenReturn("wow you look great anna");
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