package com.informatica.externalsorting;

import com.informatica.ExternalSorting;
import com.informatica.externalsorting.exception.ExternalSortingException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Map;

public class FileSplit {

    private final PTimer fileSplit;
    private final String inputFile;

    public FileSplit(String fileName) {
        this.fileSplit = new PTimer("FileSplit");
        this.inputFile = fileName;
    }

    public Map<String, File> split() throws ExternalSortingException {
        File tempDir = Paths.get("tempDir").toFile();
        if (!tempDir.exists()) tempDir.mkdirs();

        try (BufferedReader fileReader = Files.newBufferedReader(Paths.get(inputFile))) {

        }catch (IOException e) {
            throw new ExternalSortingException("file opening error, cannot open bufferReader",e);
        }catch (InvalidPathException e){
            throw new ExternalSortingException("Given path is invalid",e);
        }

        return null;
    }
}
