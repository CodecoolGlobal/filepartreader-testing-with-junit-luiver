package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    FilePartReader filePartReader;

    @BeforeEach
    void initializeReader() {
        filePartReader = new FilePartReader();
    }

    @Test
    void testIfThrowsIOExceptionForEmptyFilePath() {
        filePartReader.setup("",1,2);
        assertThrows(IOException.class, () -> filePartReader.read());
    }

    @Test
    void testIfThrowsIOExceptionForWrongFileName() {
        filePartReader.setup("src/main/resources/xxx.txt",1,2);
        assertThrows(IOException.class, () -> filePartReader.read());
    }

    @Test
    void testIfThrowsIllegalArgumentExceptionIfNegativeToLine() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("src/main/resources/test.txt",1,-1));
    }

    @Test
    void testIfThrowsIllegalArgumentExceptionIfNegativeFromLine() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("src/main/resources/test.txt",-1,1));
    }

    @Test
    void testIfThrowsIllegalArgumentExceptionIfFromLineIsBiggerThanToLine() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("src/main/resources/test.txt",3,2));
    }

    @Test
    void testIfReadLinesCorrectlyReadOnlyFirstLine() throws IOException {
        filePartReader.setup("src/main/resources/test.txt",1,1);
        assertEquals("line1 anna\n", filePartReader.readLines());
    }

    @Test
    void testIfReadLinesCorrectlyReadIfToLineSuppliedBiggerThanActualNumberOfLines() throws IOException {
        filePartReader.setup("src/main/resources/test.txt",1,99);
        String expectedString = "line1 anna\nline2 level\nline3 noon wow\nline4 refer radar\nline5 rotator\nline6 stats\n";
        assertEquals(expectedString, filePartReader.readLines());
    }

    @Test
    void testIfReadLinesCorrectlyReadOnlyLastLine() throws IOException {
        filePartReader.setup("src/main/resources/test.txt",6,6);
        assertEquals("line6 stats\n", filePartReader.readLines());
    }
}