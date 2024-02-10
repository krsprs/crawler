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
 * The JobsCrawler class extends the Crawler class and implements the ICrawler interface.
 * It provides functionality to crawl the jobs.bg website and extract job advertisements based on a search term.
 */
public class JobsCrawler extends Crawler implements ICrawler {

    /**
     * Crawls the jobs.bg website to extract job advertisements based on the specified search term.
     *
     * @param searchTerm   the search term used to query job advertisements
     * @param numberOfAds  the number of job advertisements to retrieve
     * @return a list of AdDTO objects representing the retrieved job advertisements
     * @throws IOException if an I/O error occurs during the crawling process
     */
    @Override
    public List<AdDTO> craw(String searchTerm, int numberOfAds) throws IOException {
        List<AdDTO> ads = new ArrayList<>();
        Document doc = getPageContent("https://www.jobs.bg/front_job_search.php?subm=1&keywords%5B%5D="
                + java.net.URLEncoder.encode(searchTerm, StandardCharsets.UTF_8));
        int i = 0;
        for (Element ad : doc.body().getElementsByClass("left")) {
            // Extract job title
            String title = ad.select("a").attr("title");

            // Extract job link
            String link = ad.select("a").attr("href");

            // Get salary
            String salaryElement = Objects.requireNonNull(ad.select("a div.card-info").first()).html();
            String[] array = salaryElement.split(";");
            String salary = "Не е посочена";
            for (String s : array) {
                if (s.contains("Заплата")) {
                    salary = s.replace("Заплата", "");
                    salary = salary.replace("<b>", "");
                    salary = salary.replace("</b>", "");
                }
            }
            ads.add(new AdDTO(title, salary, link));
            System.out.println(title + "; " + link + "; " + salary);
            if (++i >= numberOfAds)
                break;
        }
        return ads;
    }
}
