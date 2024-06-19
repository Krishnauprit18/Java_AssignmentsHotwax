package com.wordcount;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Utility class for fetching HTML content from given URL.
 */

public class Fetcher{

    /**
     * Fetches the HTML content of the given URL.
     *
     * @param url           the URL to fetch HTML content from
     * @return              the HTML content as a string, or an empty string if an error occurs
     * @throws IOException  IOException, if an I/O error occurs
     */
    public static String fetchHtmlContent(String url) throws IOException{
        try {
            Document doc = Jsoup.connect(url).get();
            return doc.html();
        }
        catch(IOException e){
            System.out.println("Error fetching content from URL" + url +": "+ e.getMessage());
            return "";
        }
    }
}