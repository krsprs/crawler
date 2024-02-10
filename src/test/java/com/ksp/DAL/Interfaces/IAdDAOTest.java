package com.ksp.DAL.Interfaces;

import com.ksp.DAL.DAOs.AdDAO;
import com.ksp.Domain.DTOs.AdDTO;
import com.ksp.Domain.Entities.AdEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the IAdDAO interface.
 */
class IAdDAOTest {

    /**
     * Test for the addNewAd method.
     */
    @Test
    void addNewAd() {
        AdDTO ad = new AdDTO("Test Title", "Test Salary", "Test URL");
        IAdDAO adDAO = createAdDAO();

        adDAO.AddNewAd(ad);
        List<AdDTO> ads = adDAO.GetAllAds();

        assertEquals(1, ads.size());
        assertEquals(ad, ads.get(0));
    }

    /**
     * Test for the addNewAds method.
     */
    @Test
    void addNewAds() {
        List<AdDTO> ads = new ArrayList<>();
        ads.add(new AdDTO("Title 1", "Salary 1", "URL 1"));
        ads.add(new AdDTO("Title 2", "Salary 2", "URL 2"));
        IAdDAO adDAO = createAdDAO();

        adDAO.AddNewAds(ads);
        List<AdDTO> retrievedAds = adDAO.GetAllAds();

        assertEquals(2, retrievedAds.size());
        assertEquals(ads, retrievedAds);
    }

    /**
     * Test for the SetSearchTerm method.
     */
    @Test
    void SetSearchTerm() {
        String searchTerm = "Test Search Term";
        IAdDAO adDAO = createAdDAO();

        adDAO.SetSearchTerm(searchTerm);

        assertEquals(searchTerm, adDAO.GetSearchTerm());
    }

    /**
     * Test for the GetSearchTerm method.
     */
    @Test
    void GetSearchTerm() {
        String searchTerm = "Test Search Term";
        IAdDAO adDAO = createAdDAO();
        adDAO.SetSearchTerm(searchTerm);

        String retrievedSearchTerm = adDAO.GetSearchTerm();

        assertEquals(searchTerm, retrievedSearchTerm);
    }

    /**
     * Test for the setSite method.
     */
    @Test
    void setSite() {
        String site = "Test Site";
        IAdDAO adDAO = createAdDAO();

        adDAO.SetSite(site);

        assertEquals(site, adDAO.GetSite());
    }

    /**
     * Test for the getSite method.
     */
    @Test
    void getSite() {
        // Arrange
        String site = "Test Site";
        IAdDAO adDAO = createAdDAO();
        adDAO.SetSite(site);

        // Act
        String retrievedSite = adDAO.GetSite();

        // Assert
        assertEquals(site, retrievedSite);
    }

    // Helper method to create an instance of IAdDAO for testing
    private IAdDAO createAdDAO() {
        return new AdDAO(new AdEntity(new ArrayList<>(),"", ""));
    }

}
