package com.ksp.APP.Crawlers;

import com.ksp.Domain.DTOs.AdDTO;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The ZaplataCrawler class extends the Crawler class and implements the ICrawler interface.
 * It provides functionality to crawl the www.zaplata.bg website and extract job advertisements based on a search term.
 */
public class ZaplataCrawler extends Crawler implements ICrawler {

    /**
     * Crawls the www.zaplata.bg website to extract job advertisements based on the specified search term.
     *
     * @param searchTerm   the search term used to query job advertisements
     * @param numberOfAds  the number of job advertisements to retrieve
     * @return a list of AdDTO objects representing the retrieved job advertisements
     * @throws IOException if an I/O error occurs during the crawling process
     */
    @Override
    public List<AdDTO> craw(String searchTerm, int numberOfAds) throws IOException {
        List<AdDTO> ads = new ArrayList<>();
        Document doc = getPageContent("https://www.zaplata.bg/search/?go=&q="
                + java.net.URLEncoder.encode(searchTerm, StandardCharsets.UTF_8));
        int i = 0;
        for (Element ad : doc.body().getElementsByClass("item")) {

            String title = ad.select("div.title a").html();

            // Extract job link
            String link = ad.select("div.title a").attr("href");

            // Get salary
            Elements salaryElement = ad.select("div.salary strong");
            String salary = "Не е посочена";
            if (!salaryElement.isEmpty())
                salary = Objects.requireNonNull(salaryElement.first()).html() + " - " + Objects.requireNonNull(salaryElement.last()).html();

            ads.add(new AdDTO(title, salary, link));
            System.out.println(title + "; " + link + "; " + salary);
            if (++i >= numberOfAds)
                break;
        }
        return ads;
    }
}
