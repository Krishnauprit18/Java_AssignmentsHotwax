package com.wordcount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Utility class for aggregating and processing word counts.
 */
public class ResultAggregator {

    /**
     * Save words count to specified file path
     * @param filePath      the file path to save the word counts
     * @param wordCounts    a map containing word counts
     * @throws IOException  if an I/O error occurs while writing to the file
     */
    public static void saveWordCounts(String filePath,
                                      Map<String, Integer> wordCounts) throws IOException {
        try {
            List<String> lines = wordCounts.entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .map(e -> e.getKey() + "-" + e.getValue())
                    .collect(Collectors.toList());
            Files.write(Paths.get(filePath), lines);
        } catch(IOException e){
            System.out.println("Error saving words to file: " + e.getMessage());
        }
    }

    /**
     * Prints the top N words and all words with their counts.
     * @param wordCounts    a map containing word counts
     * @param topN          the number of top words to print
     */
    public static void printTopWords(Map<String, Integer> wordCounts,
                                     int topN) {
        try {
            List<Map.Entry<String, Integer>> sortedEntries = wordCounts.entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .collect(Collectors.toList());

            for (int i = 0; i < Math.min(topN, sortedEntries.size()); i++) {
                Map.Entry<String, Integer> entry = sortedEntries.get(i);
                System.out.println(entry.getKey() + "-" + entry.getValue());
            }

            System.out.println();
            System.out.println("All words:");
            for (Map.Entry<String, Integer> entry : sortedEntries) {
                System.out.println(entry.getKey() + "-" + entry.getValue());
            }
        }
        catch (Exception e){
            System.out.println("Error printing top words: " + e.getMessage());
        }
    }
}