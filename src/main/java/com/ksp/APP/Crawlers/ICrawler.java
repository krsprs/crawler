package com.ksp.APP.Crawlers;

import com.ksp.Domain.DTOs.AdDTO;

import java.io.IOException;
import java.util.List;

/**
 * The ICrawler interface defines methods for crawling web pages to extract advertisements.
 */
public interface ICrawler {

    /**
     * Crawls web pages based on the specified search term and retrieves a list of advertisements.
     *
     * @param searchTerm   the search term used to query advertisements
     * @param numberOfAds  the number of advertisements to retrieve
     * @return a list of AdDTO objects representing the retrieved advertisements
     * @throws IOException if an I/O error occurs during the crawling process
     */
    List<AdDTO> craw(String searchTerm, int numberOfAds) throws IOException;
}
