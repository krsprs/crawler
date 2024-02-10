package com.ksp.DAL.DAOs;

import com.ksp.Domain.DTOs.AdDTO;
import com.ksp.Domain.Entities.AdEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * The AdDAO class is a Data Access Object (DAO) responsible for managing advertisements.
 * It provides methods for adding, retrieving, and deleting advertisements.
 */
public class AdDAO implements com.ksp.DAL.Interfaces.IAdDAO {
    private final AdEntity _adEntity;

    /**
     * Constructs a new AdDAO object with the specified AdEntity.
     *
     * @param adEntity the AdEntity associated with this DAO
     */
    public AdDAO(AdEntity adEntity) {
        _adEntity = adEntity;
    }

    /**
     * Adds a new advertisement to the list of ads.
     *
     * @param ad the AdDTO object representing the new advertisement to add
     */
    @Override
    public void AddNewAd(AdDTO ad) {
        List<AdDTO> oldAds = _adEntity.getAds();
        oldAds.add(ad);
        _adEntity.setAds(oldAds);
    }

    /**
     * Adds a list of new advertisements to the list of ads.
     *
     * @param ads the list of AdDTO objects representing the new advertisements to add
     */
    @Override
    public void AddNewAds(List<AdDTO> ads) {
        _adEntity.setAds(ads);
    }

    /**
     * Sets the search term for the advertisements.
     *
     * @param searchTerm the search term to set
     */
    @Override
    public void SetSearchTerm(String searchTerm){
        _adEntity.setSearchTerm(searchTerm);
    }

    /**
     * Retrieves the search term for the advertisements.
     *
     * @return the search term
     */
    @Override
    public String GetSearchTerm(){
        return _adEntity.getSearchTerm();
    }

    /**
     * Sets the site for the advertisements.
     *
     * @param site the site to set
     */
    @Override
    public void SetSite(String site) {
        _adEntity.setSite(site);
    }

    /**
     * Retrieves the site for the advertisements.
     *
     * @return the site
     */
    @Override
    public String GetSite() {
        return _adEntity.getSite();
    }

    /**
     * Deletes an advertisement by its URL.
     *
     * @param URL the URL of the advertisement to delete
     */
    @Override
    public void DeleteAdByURL(String URL) {
        List<AdDTO> filteredAds = _adEntity.getAds().stream()
                .filter(s -> !s.getURL().equals(URL))
                .toList();
        _adEntity.setAds(filteredAds);
    }

    /**
     * Deletes all advertisements.
     */
    @Override
    public void DeleteAllAds() {
        _adEntity.setSearchTerm("");
        _adEntity.setAds(new ArrayList<>());
    }

    /**
     * Retrieves all advertisements.
     *
     * @return a list of all advertisements
     */
    @Override
    public List<AdDTO> GetAllAds() {
        return _adEntity.getAds();
    }

    /**
     * Retrieves all advertisements with a specific title.
     *
     * @param title the title to filter advertisements by
     * @return a list of advertisements with the specified title
     */
    @Override
    public List<AdDTO> GetAllAdsByTitle(String title) {
        return _adEntity.getAds().stream()
                .filter(s -> s.getTitle().contains(title))
                .toList();
    }

    /**
     * Retrieves all advertisements with a specific salary.
     *
     * @param salary the salary to filter advertisements by
     * @return a list of advertisements with the specified salary
     */
    @Override
    public List<AdDTO> GetAllAdsBySalary(String salary) {
        return _adEntity.getAds().stream()
                .filter(s -> s.getSalary() == salary)
                .toList();
    }
}
