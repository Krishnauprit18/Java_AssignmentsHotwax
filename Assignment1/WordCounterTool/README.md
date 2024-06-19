# Assignment - 1
Problem Statement - 1:
Write a program to count words in web page content.
Inputs:
 - List of URLs (select your own URLs for testing) provided in a text file, e.g. urls.txt
 - List of words (select your own words for testing) provided in a text file, e.g. words.txt
 - Place the files above in such a way that the reviewer can himself get your code and just run without having to alter the source code to adjust the path. In other words, don’t use a hardcoded path  particular to your machine, instead derive the path.

Outputs:
 - For each URL, print:
 - the top 3 words on the given list
 - the number of occurrences of each word
 - List the words sorted by the number of occurrences in descending order.
For each word on the given list, print the total number of occurrences across all the specified URLs. List the words sorted by the total number in descending order.

Code Workflow:
It has resources folder which has 3 files -> config.properties, urls.txt, words.txt.
I). App.java
 - readUrls takes file path as argument from config.properties file and return them as list of strings.
 - readAllLines method read all the lines from the text file path and return list of strings of Urls, and converts the string to the path object.
 - catch will return the empty list if an exception occurs.

II). Fetcher.java
 - Jsoup provides methods to connect to a Url and parse it to HTML content.
 - The fetchContentFromHtml method takes the parsed Urls as string as its argument and return HTML content of the page as string.
 - Jsoup.connect connects to the specified Url and returns the Html content. It return the document Obj. representing the HTML content of the page.
 - doc.HTML return the HTML content of the doc as a string.

III). Parser.java
 - Jsoup is used to parse the HTML content.
 - parseHtmlToText method takes HTML string as argument and return the plain text content of the HTML.
 - Jsoup.parse method parse the HTML string to document object.
 - doc.body.text method extract the plain text content from the body of the doc.
 - toLowercase methods converts the text to lowercase t ensure insensitive word counting.
 
IV). Counter.java
 - countWords method takes the plain text as an argument and return a map of word counts.
 - Then Hashmap is initialized to store both words and their counts.
 - Then the text is splitted to the words using a regular expressions that matches the non word characters("\\W+").
 - This splits the text at any sequence of characters that are not letters or digits.
 - Then for loop is used to iterate over each words in the array, and ensure that the word is not an empty string.
 - It updates the counts for each word. If the word is already in the map, it increments its count by 1, else it adds the word with a count of 1.

V). ResultAggregator.java
 - saveWordCounts method saves the word count to a file. It takes file path and map the word counts.
 - savingWordsToFile method creates the stream from the entries of the word count map.
 - and sorted method sorts the entries in descending order based on their word count value.
 - Map method  maps each entry to string in the format -> "word - count".
 - Collect method collects the mapped entries to the list of strings.
 - It writes the list of strings to the specified file(words.txt).
 - printtopN method print the top N words (here N = 3) with the highest count.
 - It takes map of word counts and print the topN words.
 - Then it prints the list of all words and their count.
