package com.ksp.Domain.Entities;

import com.ksp.Domain.DTOs.AdDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the AdEntity class.
 */
class AdEntityTest {

    /**
     * Test for the getAds method.
     * It checks if the method correctly retrieves the list of advertisements.
     */
    @Test
    void getAds() {
        List<AdDTO> ads = new ArrayList<>();
        ads.add(new AdDTO("Title 1", "Salary 1", "URL 1"));
        ads.add(new AdDTO("Title 2", "Salary 2", "URL 2"));
        AdEntity adEntity = new AdEntity(ads, "SearchTerm", "Site");
        List<AdDTO> result = adEntity.getAds();
        assertEquals(ads, result);
    }

    /**
     * Test for the setAds method.
     * It checks if the method correctly sets the list of advertisements.
     */
    @Test
    void setAds() {
        List<AdDTO> ads = new ArrayList<>();
        ads.add(new AdDTO("Title 1", "", "URL 1"));
        ads.add(new AdDTO("Title 2", "Salary 2", "URL 2"));
        AdEntity adEntity = new AdEntity(new ArrayList<>(), "", "");
        adEntity.setAds(ads);
        assertEquals(ads, adEntity.getAds());
    }

    /**
     * Test for the getSearchTerm method.
     * It checks if the method correctly retrieves the search term.
     */
    @Test
    void getSearchTerm() {
        String searchTerm = "SearchTerm";
        AdEntity adEntity = new AdEntity(new ArrayList<>(), searchTerm, "Site");
        String result = adEntity.getSearchTerm();
        assertEquals(searchTerm, result);
    }

    /**
     * Test for the setSearchTerm method.
     * It checks if the method correctly sets the search term.
     */
    @Test
    void setSearchTerm() {
        String searchTerm = "SearchTerm";
        AdEntity adEntity = new AdEntity(new ArrayList<>(), "", "");
        adEntity.setSearchTerm(searchTerm);
        assertEquals(searchTerm, adEntity.getSearchTerm());
    }

    /**
     * Test for the getSite method.
     * It checks if the method correctly retrieves the site.
     */
    @Test
    void getSite() {
        String site = "Site";
        AdEntity adEntity = new AdEntity(new ArrayList<>(), "SearchTerm", site);
        String result = adEntity.getSite();
        assertEquals(site, result);
    }

    /**
     * Test for the setSite method.
     * It checks if the method correctly sets the site.
     */
    @Test
    void setSite() {
        String site = "Site";
        AdEntity adEntity = new AdEntity(new ArrayList<>(), "", "");
        adEntity.setSite(site);
        assertEquals(site, adEntity.getSite());
    }
}
