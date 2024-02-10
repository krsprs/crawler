package com.ksp.APP.Crawlers;

import com.ksp.Domain.DTOs.AdDTO;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link ICrawler} implementations.
 */
class ICrawlerTest {

    /**
     * Tests the {@link JobsCrawler#craw(String, int)} method to ensure it calls the crawl method for JobsCrawler.
     *
     * @throws IOException if an I/O error occurs.
     */
    @Test
    void craw_ShouldCallCrawMethodForJobsCrawler() throws IOException {
        ICrawler jobsCrawler = new JobsCrawler();

        List<AdDTO> ads = jobsCrawler.craw("searchTerm", 5);

        assertNotNull(ads);
        assertTrue(ads.size() <= 5); // Assuming 5 is the maximum number of ads
    }

    /**
     * Tests the {@link JoobleCrawler#craw(String, int)} method to ensure it calls the crawl method for JoobleCrawler.
     *
     * @throws IOException if an I/O error occurs.
     */
    @Test
    void craw_ShouldCallCrawMethodForJoobleCrawler() throws IOException {
        ICrawler joobleCrawler = new JoobleCrawler();

        List<AdDTO> ads = joobleCrawler.craw("searchTerm", 5);

        assertNotNull(ads);
        assertTrue(ads.size() <= 5); // Assuming 5 is the maximum number of ads
    }

    /**
     * Tests the {@link ZaplataCrawler#craw(String, int)} method to ensure it calls the crawl method for ZaplataCrawler.
     *
     * @throws IOException if an I/O error occurs.
     */
    @Test
    void craw_ShouldCallCrawMethodForZaplataCrawler() throws IOException {
        ICrawler zaplataCrawler = new ZaplataCrawler();

        List<AdDTO> ads = zaplataCrawler.craw("searchTerm", 5);

        assertNotNull(ads);
        assertTrue(ads.size() <= 5); // Assuming 5 is the maximum number of ads
    }

}
