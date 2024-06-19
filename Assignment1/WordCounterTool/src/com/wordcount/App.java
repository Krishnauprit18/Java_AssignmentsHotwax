package com.wordcount;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Main Application class for word counting.
 */
public class App{

    private static final String CONFIG_FILE_PATH = "src/resources/config.properties";

    /**
     * Main method to count words form URLS and save the word counts.
     * @param args          command-line arguments.
     * @throws IOException  if an I/O error occurs
     */
    public static void main(String[] args){
        Properties properties = new Properties();
        try(FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)){
            properties.load(fis);
        }
        catch(IOException e) {
            System.out.println("Error loading configuration file " + e.getMessage());
        }

        String urlsFilePath = properties.getProperty("urlsFilePath");
        String wordsFilePath = properties.getProperty("wordsFilePath");

        try{
            List<String> urls = Input.readUrls(urlsFilePath);
            if (urls.isEmpty()){
                System.out.println("No URL's found or Error reading URL's file");
                return;
            }

            Map<String, Integer> totalWordCounts = new HashMap<>();

            for (String url: urls){
                System.out.println("Fetching content from: " + url);

                String htmlContent = Fetcher.fetchHtmlContent(url);
                if (htmlContent.isEmpty()){
                    System.out.println("Skipping URL's fetching due to fetching error: " + url);
                }

                String plainText = Parser.parseHtmlToPlainText(htmlContent);
                if (plainText.isEmpty()){
                    System.out.println("Skipping URL due to parsing error: " + url);
                }

                Map<String, Integer> wordCounts = Counter.countWords(plainText);

                for (Map.Entry<String, Integer> entry: wordCounts.entrySet()){
                            totalWordCounts.put(entry.getKey(),
                            totalWordCounts.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }

                System.out.println("Top 3 words are:");
                ResultAggregator.printTopWords(wordCounts, 3);
            }

            ResultAggregator.saveWordCounts(wordsFilePath, totalWordCounts);
        } catch (IOException e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}