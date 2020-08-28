package com.codecool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        setup("src/main/resources/test.txt",1,1);
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) throws IllegalArgumentException {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException("toLine must be greater or equals to fromLine and fromLine must be > 0");
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public String readLines() throws IOException {
        String[] splitLines = read().split("\n");
        StringBuilder stringBuilder = new StringBuilder();

        if (toLine>splitLines.length) {
            throw new ArrayIndexOutOfBoundsException("toLine must be lower or equals to number of lines in text file ");
        }

        for (int line = fromLine; line <= toLine; line++){
            try {
                stringBuilder.append(splitLines[line - 1]).append("\n");
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return stringBuilder.toString();
    }
}
