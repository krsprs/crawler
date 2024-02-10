package com.ksp.APP.Models;

import com.ksp.Domain.Entities.AdEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the {@link MainModel} class.
 */
class MainModelTest {

    /**
     * Tests the {@link MainModel#getAds()} method to ensure it returns the correct list of ads.
     */
    @Test
    void getAds_ReturnsCorrectAds() {
        List<AdEntity> expectedAds = new ArrayList<>();
        expectedAds.add(new AdEntity(new ArrayList<>(), "SearchTerm 1", "Site 1"));
        expectedAds.add(new AdEntity(new ArrayList<>(), "SearchTerm 2", "Site 2"));
        MainModel mainModel = new MainModel();
        mainModel.setAds(expectedAds);

        List<AdEntity> actualAds = mainModel.getAds();

        assertEquals(expectedAds, actualAds);
    }

    /**
     * Tests the {@link MainModel#setAds(List)} method to ensure it sets the correct list of ads.
     */
    @Test
    void setAds_SetsCorrectAds() {
        List<AdEntity> ads = new ArrayList<>();
        ads.add(new AdEntity(new ArrayList<>(), "SearchTerm 1", "Site 1"));
        ads.add(new AdEntity(new ArrayList<>(), "SearchTerm 2", "Site 2"));
        MainModel mainModel = new MainModel();

        mainModel.setAds(ads);

        assertEquals(ads, mainModel.getAds());
    }
}
