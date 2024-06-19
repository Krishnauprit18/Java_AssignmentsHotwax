package com.wordcount;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for counting words in a text.
 */
public class Counter{

    /**
     * Counts the occurences of each word in the given text.
     *
     * @param text  the text to count words from
     * @return      a map containing each word and its count
     */
    public static Map<String, Integer> countWords(String text){
        Map<String, Integer> wordCounts = new HashMap<>();
        String[] words = text.split("\\W+");
        try {
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }
        }
        catch(Exception e){
            System.out.println("Error counting words: " + e.getMessage());
        }
        return wordCounts;
    }
}