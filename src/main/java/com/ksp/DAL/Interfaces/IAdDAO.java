package com.ksp.DAL.Interfaces;

import com.ksp.Domain.DTOs.AdDTO;

import java.util.List;

/**
 * The IAdDAO interface defines methods for interacting with advertisement data.
 */
public interface IAdDAO {
    /**
     * Adds a new advertisement.
     *
     * @param ad the AdDTO object representing the new advertisement to add
     */
    void AddNewAd(AdDTO ad);

    /**
     * Adds a list of new advertisements.
     *
     * @param ads the list of AdDTO objects representing the new advertisements to add
     */
    void AddNewAds(List<AdDTO> ads);

    /**
     * Sets the search term for the advertisements.
     *
     * @param searchTerm the search term to set
     */
    void SetSearchTerm(String searchTerm);

    /**
     * Retrieves the search term for the advertisements.
     *
     * @return the search term
     */
    String GetSearchTerm();

    /**
     * Sets the site for the advertisements.
     *
     * @param site the site to set
     */
    void SetSite(String site);

    /**
     * Retrieves the site for the advertisements.
     *
     * @return the site
     */
    String GetSite();

    /**
     * Deletes an advertisement by its URL.
     *
     * @param URL the URL of the advertisement to delete
     */
    void DeleteAdByURL(String URL);

    /**
     * Deletes all advertisements.
     */
    void DeleteAllAds();

    /**
     * Retrieves all advertisements.
     *
     * @return a list of all advertisements
     */
    List<AdDTO> GetAllAds();

    /**
     * Retrieves all advertisements with a specific title.
     *
     * @param title the title to filter advertisements by
     * @return a list of advertisements with the specified title
     */
    List<AdDTO> GetAllAdsByTitle(String title);

    /**
     * Retrieves all advertisements with a specific salary.
     *
     * @param salary the salary to filter advertisements by
     * @return a list of advertisements with the specified salary
     */
    List<AdDTO> GetAllAdsBySalary(String salary);
}
