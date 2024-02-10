package com.ksp.APP.Crawlers;

import com.ksp.Domain.DTOs.AdDTO;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The JoobleCrawler class extends the Crawler class and implements the ICrawler interface.
 * It provides functionality to crawl the bg.jooble.org website and extract job advertisements based on a search term.
 */
public class JoobleCrawler extends Crawler implements ICrawler {

    /**
     * Crawls the bg.jooble.org website to extract job advertisements based on the specified search term.
     *
     * @param searchTerm   the search term used to query job advertisements
     * @param numberOfAds  the number of job advertisements to retrieve
     * @return a list of AdDTO objects representing the retrieved job advertisements
     * @throws IOException if an I/O error occurs during the crawling process
     */
    @Override
    public List<AdDTO> craw(String searchTerm, int numberOfAds) throws IOException {
        List<AdDTO> ads = new ArrayList<>();
        Document doc = getPageContent("https://bg.jooble.org/SearchResult?ukw="
                + java.net.URLEncoder.encode(searchTerm, StandardCharsets.UTF_8));
        int i = 0;
        for (Element ad : doc.body().getElementsByAttributeValue("data-test-name", "_jobCard")) {

            String title = ad.select("a").html();

            // Extract job link
            String link = ad.select("a").attr("href");

            // Get salary
            String salaryElement = Objects.requireNonNull(ad.select("p").first()).html();
            String salary = "Не е посочена";
            if (!salaryElement.isEmpty())
                salary = salaryElement;

            ads.add(new AdDTO(title, salary, link));
            System.out.println(title + "; " + link + "; " + salary);
            if (++i >= numberOfAds)
                break;
        }
        return ads;
    }
}
