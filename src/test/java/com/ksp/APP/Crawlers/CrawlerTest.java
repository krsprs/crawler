package com.ksp.APP.Crawlers;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Crawler} class.
 */
class CrawlerTest {

    /**
     * Tests the {@link Crawler#getPageContent(String)} method with a valid URL, ensuring it returns the content of the page.
     *
     * @throws IOException if an I/O error occurs.
     */
    @Test
    void getPageContent_ValidURL_ReturnsContent() throws IOException {
        String validURL = "https://example.com";
        Crawler crawler = new Crawler();

        Document pageContent = crawler.getPageContent(validURL);

        assertNotNull(pageContent);
        assertEquals(pageContent.getElementsByTag("h1").html(), "Example Domain");
    }

    /**
     * Tests the {@link Crawler#getPageContent(String)} method with an invalid URL, ensuring it throws Exception.
     *
     * @throws IOException if an I/O error occurs.
     */
    @Test
    void getPageContent_InvalidURL() throws IOException {
        String invalidURL = "https://invalidurl123.com";
        Crawler crawler = new Crawler();

        try {
            crawler.getPageContent(invalidURL);

            fail("Expected IOException was not thrown");
        } catch (IOException e) {
            assertNotNull(e);
        }
    }
}
