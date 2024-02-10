package com.ksp.APP;

import com.ksp.APP.Controllers.MainViewController;
import com.ksp.APP.Models.MainModel;
import com.ksp.DAL.DAOs.AdDAO;
import com.ksp.Domain.Entities.AdEntity;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The MainApplication class is the entry point of the application.
 * It extends the JavaFX Application class and is responsible for launching the application.
 */
public class MainApplication extends Application {

    /**
     * The start method is called when the application is launched.
     * It loads the main FXML file, initializes the controller, and displays the main window.
     *
     * @param stage the primary stage for this application
     * @throws IOException if an error occurs while loading the FXML file
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("index.fxml"));
        MainViewController controller = new MainViewController(new AdDAO(new AdEntity(new ArrayList<>(), "", "")), new MainModel());
        loader.setController(controller);
        Parent root = loader.load();

        controller.initialize();

        // Create main window
        stage.setTitle("Web crawler");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method is the entry point of the application.
     * It launches the JavaFX application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
