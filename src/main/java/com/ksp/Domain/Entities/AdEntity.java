package com.ksp.Domain.Entities;

import com.ksp.Domain.DTOs.AdDTO;

import java.util.List;

/**
 * The AdEntity class represents an entity containing a list of advertisements, along with search term and site information.
 */
public class AdEntity {
    private List<AdDTO> Ads;
    private String SearchTerm;
    private String Site;

    /**
     * Constructs a new AdEntity object with the specified list of advertisements, search term, and site.
     *
     * @param ads        the list of advertisements
     * @param searchTerm the search term used to fetch the advertisements
     * @param site       the site from which the advertisements were fetched
     */
    public AdEntity(List<AdDTO> ads, String searchTerm, String site) {
        Ads = ads;
        this.SearchTerm = searchTerm;
        this.Site = site;
    }

    /**
     * Retrieves the list of advertisements.
     *
     * @return the list of advertisements
     */
    public List<AdDTO> getAds() {
        return Ads;
    }

    /**
     * Sets the list of advertisements.
     *
     * @param ads the list of advertisements
     */
    public void setAds(List<AdDTO> ads) {
        Ads = ads;
    }

    /**
     * Retrieves the search term.
     *
     * @return the search term
     */
    public String getSearchTerm() {
        return SearchTerm;
    }

    /**
     * Sets the search term.
     *
     * @param searchTerm the search term
     */
    public void setSearchTerm(String searchTerm) {
        this.SearchTerm = searchTerm;
    }

    /**
     * Retrieves the site.
     *
     * @return the site
     */
    public String getSite() {
        return Site;
    }

    /**
     * Sets the site.
     *
     * @param site the site
     */
    public void setSite(String site) {
        Site = site;
    }
}
