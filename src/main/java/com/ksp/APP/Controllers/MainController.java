package com.ksp.APP.Controllers;

import com.ksp.APP.Crawlers.ICrawler;
import com.ksp.APP.Crawlers.JobsCrawler;
import com.ksp.APP.Crawlers.JoobleCrawler;
import com.ksp.APP.Crawlers.ZaplataCrawler;
import com.ksp.APP.Models.MainModel;
import com.ksp.DAL.DAOs.AdDAO;
import com.ksp.Domain.DTOs.AdDTO;
import com.ksp.Domain.Entities.AdEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * The MainController class controls the main functionality of the application.
 * It manages the interaction between the user interface, data access objects, models, and crawlers.
 */
public class MainController {

    private final AdDAO _adDAO;
    private final MainModel _mainModel;

    /**
     * Constructs a new MainController with the specified AdDAO and MainModel.
     *
     * @param adDAO     the data access object for advertisements
     * @param mainModel the main model of the application
     */
    public MainController(AdDAO adDAO, MainModel mainModel) {
        _adDAO = adDAO;
        _mainModel = mainModel;
    }

    /**
     * Searches for advertisements based on the specified site, number of ads, and search term.
     *
     * @param site      the site to search for advertisements on
     * @param adsNumber the number of advertisements to retrieve
     * @param searchTerm the search term used to query advertisements
     * @return the main model containing the updated list of advertisements
     * @throws IOException if an I/O exception occurs during the search operation
     */
    public MainModel Search(String site, int adsNumber, String searchTerm) throws IOException, ExecutionException, InterruptedException {
        _adDAO.DeleteAllAds();
        _adDAO.SetSearchTerm(searchTerm);
        _adDAO.SetSite(site);

        ICrawler crawler;
        switch (site) {
            case "Jobs.bg":
                crawler = new JobsCrawler();
                List<AdDTO> jobsAds = crawler.craw(searchTerm, adsNumber);
                _adDAO.AddNewAds(jobsAds);
                break;
            case "Zaplata.bg":
                crawler = new ZaplataCrawler();
                List<AdDTO> zaplataAds = crawler.craw(searchTerm, adsNumber);
                _adDAO.AddNewAds(zaplataAds);
                break;
            case "bg.jooble.org":
                crawler = new JoobleCrawler();
                List<AdDTO> joobleAds = crawler.craw(searchTerm, adsNumber);
                _adDAO.AddNewAds(joobleAds);
                break;
            default:{
                List<AdDTO> allAds = new ArrayList<>();

                // Create a thread pool with 3 threads
                ExecutorService executor = Executors.newFixedThreadPool(3);

                // Submit tasks to the thread pool
                Callable<List<AdDTO>> jobsTask = () -> new JobsCrawler().craw(searchTerm, adsNumber);
                Callable<List<AdDTO>> zaplataTask = () -> new ZaplataCrawler().craw(searchTerm, adsNumber);
                Callable<List<AdDTO>> joobleTask = () -> new JoobleCrawler().craw(searchTerm, adsNumber);

                Future<List<AdDTO>> jobsFuture = executor.submit(jobsTask);
                Future<List<AdDTO>> zaplataFuture = executor.submit(zaplataTask);
                Future<List<AdDTO>> joobleFuture = executor.submit(joobleTask);

                // Get the results from the tasks
                allAds.addAll(jobsFuture.get());
                allAds.addAll(zaplataFuture.get());
                allAds.addAll(joobleFuture.get());

                // Shutdown the executor
                executor.shutdown();

                // Add new ads to the database
                _adDAO.AddNewAds(allAds);
                break;
            }
        }

        AdEntity adEntity = new AdEntity(_adDAO.GetAllAds(), _adDAO.GetSearchTerm(), _adDAO.GetSite());
        List<AdEntity> allSearches = _mainModel.getAds();
        allSearches.add(adEntity);
        _mainModel.setAds(allSearches);

        return _mainModel;
    }
}

