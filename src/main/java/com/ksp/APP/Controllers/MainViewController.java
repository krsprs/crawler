package com.ksp.APP.Controllers;

import com.ksp.APP.Models.MainModel;
import com.ksp.APP.Validators.NumericFieldValidator;
import com.ksp.DAL.DAOs.AdDAO;
import com.ksp.Domain.Entities.AdEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import javafx.beans.property.SimpleStringProperty;
/**
 * The MainViewController class controls the main view of the application.
 * It handles user interactions and updates the UI accordingly.
 */
public class MainViewController {
    MainController controller;
    @FXML
    private TextField numericField;
    @FXML
    private TableView<String[]> tableView;
    @FXML
    private TableColumn<String[], String> titleColumn;
    @FXML
    private TableColumn<String[], String> siteColumn;
    @FXML
    private TableColumn<String[], String> salaryColumn;
    @FXML
    private TableColumn<String[], String> urlColumn;
    @FXML
    private TableColumn<String[], String>  keywordColumn;
    @FXML
    private ComboBox<String> webSite;
    @FXML
    private TextField searchTermField;
    @FXML
    private Button search;
    /**
     * Initializes the controller after its root element has been completely processed.
     * It sets up listeners, event handlers, and initial data.
     */
    public void initialize() {
        // Initialize numericField value listener
        numericField.textProperty().addListener(new NumericFieldValidator());

        // Set columns data
        siteColumn.setCellValueFactory(cellData -> {
            String ads = cellData.getValue()[0];
            if (ads != null) {
                return new SimpleStringProperty(ads);
            } else {
                return new SimpleStringProperty("");
            }
        });

        titleColumn.setCellValueFactory(cellData -> {
            String ads = cellData.getValue()[2];
            if (ads != null) {
                return new SimpleStringProperty(ads);
            } else {
                return new SimpleStringProperty("");
            }
        });

        salaryColumn.setCellValueFactory(cellData -> {
            String ads = cellData.getValue()[3];
            if (ads != null) {
                return new SimpleStringProperty(ads);
            } else {
                return new SimpleStringProperty("");
            }
        });

        urlColumn.setCellValueFactory(cellData -> {
            String ads = cellData.getValue()[4];
            if (ads != null) {
                return new SimpleStringProperty(ads);
            } else {
                return new SimpleStringProperty("");
            }
        });

        keywordColumn.setCellValueFactory(cellData -> {
            String ads = cellData.getValue()[1];
            if (ads != null) {
                return new SimpleStringProperty(ads);
            } else {
                return new SimpleStringProperty("");
            }
        });

        // Set search button handler
        search.setOnAction(event -> {
            String site = webSite.getValue();
            int adsNumber = 0;
            if(numericField.getText() != null && !Objects.equals(numericField.getText(), "")) {
                adsNumber = Integer.parseInt(numericField.getText());
                String searchTerm = searchTermField.getText();
                if (site != null) {
                    MainModel mdl = null;
                    try {
                        mdl = controller.Search(site, adsNumber, searchTerm);
                    } catch (IOException | ExecutionException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    // Create an observable list to hold the data for the TableView.
                    ObservableList<String[]> observableList = FXCollections.observableArrayList(new String[][]{});

                    // Iterate through the list of ads in the MainModel.
                    for (int i = 0; i < mdl.getAds().size(); i++) {
                        // Get the current AdEntity from the list.
                        AdEntity rowData = mdl.getAds().get(i);
                        // Iterate through the list of AdDTOs in the AdEntity.
                        for (int j = 0; j < rowData.getAds().size(); j++) {
                            // Extract relevant data from the AdEntity and its AdDTOs and add them to a String array.
                            String[] rowDataArray = new String[]{
                                    rowData.getSite(),                      // Site of the ad
                                    rowData.getSearchTerm(),               // Search term used
                                    rowData.getAds().get(j).getTitle(),   // Title of the ad
                                    rowData.getAds().get(j).getSalary(), // Salary of the ad
                                    rowData.getAds().get(j).getURL()    // URL of the ad
                            };
                            // Add the created String array to the observable list.
                            observableList.add(rowDataArray);
                            // Set the items of the TableView to the updated observable list.
                            // Note: This line is inside the inner loop, which might not be necessary.
                            // It should ideally be placed outside the loop to set the items once after all data is collected.
                            tableView.setItems(observableList);
                        }
                    }
                } else {
                    showErrorDialog("Invalid Input", "Oops Something went wrong...");
                }
            }
            else{
                showErrorDialog("Invalid Input", "Моля, въведете брой на обявите за извличане...");
            }
        });

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    /**
     * Displays an error dialog with the specified title and message.
     *
     * @param title   the title of the error dialog
     * @param message the error message to display
     */
    private void showErrorDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    /**
     * Constructs a new MainViewController with the specified AdDAO and MainModel.
     *
     * @param adDAO     the data access object for advertisements
     * @param mainModel the main model of the application
     */
    public MainViewController(AdDAO adDAO, MainModel mainModel){
        controller = new MainController(adDAO, mainModel);
    }
}
