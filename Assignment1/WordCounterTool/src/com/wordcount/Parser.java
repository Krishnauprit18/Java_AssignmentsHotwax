package com.wordcount;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Utility class for parsing HTML content to plain text.
 */
public class Parser{

    /**
     * Parses HTML content to plain text, converting to lowercase.
     *
     * @param html      the HTML content to parse
     * @return          the parsed plain text in lowercase, or an empty string if an error occurs
     */
    public static String parseHtmlToPlainText(String html){
        try {
            Document doc = Jsoup.parse(html);
            return doc.body().text().toLowerCase();
        }
        catch(Exception e){
            System.out.println("Error parsing HTML content: " + e.getMessage());
            return "";
        }
    }
}
