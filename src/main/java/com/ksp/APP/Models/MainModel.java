package com.ksp.APP.Models;
import com.ksp.Domain.Entities.AdEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * The MainModel class represents the model component of the main application.
 * It manages the list of advertisements retrieved during the application's execution.
 */
public class MainModel {
    /** The list of advertisements stored in the model. */
    private List<AdEntity> Ads = new ArrayList<>();

    /**
     * Retrieves the list of advertisements stored in the model.
     *
     * @return the list of advertisements
     */
    public List<AdEntity> getAds() {
        return Ads;
    }

    /**
     * Sets the list of advertisements stored in the model.
     *
     * @param ads the list of advertisements to set
     */
    public void setAds(List<AdEntity> ads) {
        Ads = ads;
    }
}
