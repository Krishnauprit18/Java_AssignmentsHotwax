package com.wordcount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * Utility class for reading Urls from a file.
 */
public class Input{

    /**
     * Read Urls from a specified file.
     *
     * @param filePath      the path to the file containing Urls
     * @return              a list of Urls read from the file, of an empty list if an error occurs
     * @throws IOException  IOEception if an I/O error occurs reading from the file
     */
    public static List<String> readUrls(String filePath) throws IOException{
        try {
            return Files.readAllLines(Paths.get(filePath));
        }
        catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}