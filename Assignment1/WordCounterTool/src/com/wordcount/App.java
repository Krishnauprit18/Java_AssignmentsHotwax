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
     * Main method to count words from urls and save the word counts.
     * @param args          command-line arguments
     * @throws IOException  if an I/O exception occurs
     */
    public static void main(String[] args){
        Properties properties = new Properties();
        try(FileInputStream fs = new FileInputStream(CONFIG_FILE_PATH)){
            properties.load(fs);
        }
        catch(IOException e){
            System.out.println("Error loading configuration file" + e.getMessage());
        }

        String urlsFilePath = properties.getProperty("urlsFilePath");
        String wordsFilePath = properties.getProperty("wordsFilePath");
        
        
        /**
         * readUrls takes file path as argument from config.properties file and return them as list of strings.
         * readAllLines method read all the lines from the text file path and return list of strings of Urls, and converts the string to the path object.
         * catch will return the empty list if an exception occurs.
         */
        try{
            List<String> urls = Input.readUrls(urlsFilePath);
            if (urls.isEmpty()){
                System.out.println("No URL's found or Error reading URL's file");
                return;
            }

            Map<String, Integer> totalWordCounts = new HashMap<>();
            

	    /**
	     * The fetchContentFromHtml method takes the parsed Urls as string as its argument and return HTML content of the page as string.
	     */
            for (String url: urls){
                System.out.println("Fetching content from: " + url);

                String htmlContent = Fetcher.fetchHtmlContent(url);
                if (htmlContent.isEmpty()){
                    System.out.println("Skipping URL's fetching due to fetching error: " + url);
                }
                

		/**
		 * parseHtmlToText method takes HTML string as argument and return the plain text content of the HTML.
		 */
                String plainText = Parser.parseHtmlToPlainText(htmlContent);
                if (plainText.isEmpty()){
                    System.out.println("Skipping URL due to parsing error: " + url);
                }
                
                
                /**
                 * countWords method takes the plain text as an argument and return a map of word counts.
                 */
                Map<String, Integer> wordCounts = Counter.countWords(plainText);
                for (Map.Entry<String, Integer> entry: wordCounts.entrySet()){
                            totalWordCounts.put(entry.getKey(),
                            totalWordCounts.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }

                System.out.println("Top 3 words are:");
                ResultAggregator.printTopWords(wordCounts, 3);
            }
            
            
            /**
             * saveWordCounts method saves the word count to a file. It takes file path and map the word counts.
	     * savingWordsToFile method creates the stream from the entries of the word count map.
	     * And sorted method sorts the entries in descending order based on their word count value.
	     * printtopN method print the top N words (here N = 3) with the highest count.
	     * It takes map of word counts and print the topN words.
	     * Then it prints the list of all words and their count.
	     */
            ResultAggregator.saveWordCounts(wordsFilePath, totalWordCounts);

        } catch (IOException e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
