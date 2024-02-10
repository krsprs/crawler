package com.ksp.APP.Crawlers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * The Crawler class provides methods for fetching web page content using Jsoup.
 */
public class Crawler {

    /**
     * Retrieves the content of a web page specified by the URL.
     *
     * @param URL the URL of the web page to fetch
     * @return the Document object representing the fetched web page content
     * @throws IOException if an I/O error occurs while fetching the web page
     */
    public Document getPageContent(String URL) throws IOException {
        // Connect to the specified URL and retrieve the web page content using Jsoup
        return Jsoup
                .connect(URL)
                .userAgent("Mozilla/5.0")
                .get();
    }
}
