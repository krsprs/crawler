package com.ksp.APP.Controllers;

import com.ksp.APP.MainApplication;
import com.ksp.APP.Models.MainModel;
import com.ksp.DAL.DAOs.AdDAO;
import com.ksp.Domain.Entities.AdEntity;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.TableViewMatchers;
import org.testfx.util.WaitForAsyncUtils;


import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;
/**
 * Unit tests for the {@link MainViewController} class.
 */
class MainViewControllerTest extends ApplicationTest {
    /**
     * Initializes the test environment by loading the FXML file and setting up the main window.
     *
     * @param stage the primary stage for this application.
     * @throws IOException if an I/O error occurs.
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
     * Tests the initialization of the main view, ensuring that all necessary UI components are visible and have the correct initial state.
     */
    @Test
    void testInit(){
        WaitForAsyncUtils.waitForFxEvents();
        verifyThat("#numericField", NodeMatchers.isVisible());
        verifyThat("#tableView", NodeMatchers.isVisible());
        verifyThat("#titleColumn", NodeMatchers.isVisible());
        verifyThat("#siteColumn", NodeMatchers.isVisible());
        verifyThat("#salaryColumn", NodeMatchers.isVisible());
        verifyThat("#urlColumn", NodeMatchers.isVisible());
        verifyThat("#keywordColumn", NodeMatchers.isVisible());
        verifyThat("#webSite", NodeMatchers.isVisible());
        verifyThat("#searchTermField", NodeMatchers.isVisible());
        verifyThat("#search", NodeMatchers.isVisible());

        verifyThat("#numericField", hasText(""));
        verifyThat("#searchTermField", hasText(""));

    }
    /**
     * Tests the functionality of the main view, including setting search term, performing a search, and verifying the displayed data in the table view.
     */
    @Test
    void testFunctionality(){
        FxRobot robot = new FxRobot();

        robot.clickOn("#numericField");
        robot.type(KeyCode.getKeyCode("3"));
        WaitForAsyncUtils.waitForFxEvents();

        // set search term
        robot.clickOn("#searchTermField");
        WaitForAsyncUtils.waitForFxEvents();
        robot.clickOn("#searchTermField");
        robot.press(KeyCode.D).release(KeyCode.D).sleep(100).type(KeyCode.E)
                .sleep(100).type(KeyCode.V)
                .sleep(100).type(KeyCode.E)
                .sleep(100).type(KeyCode.L)
                .sleep(100).type(KeyCode.O)
                .sleep(100).type(KeyCode.P)
                .sleep(100).type(KeyCode.E)
                .sleep(100).type(KeyCode.R);

        WaitForAsyncUtils.waitForFxEvents();
        robot.clickOn("#search");

        WaitForAsyncUtils.waitForFxEvents();
        verifyThat("#numericField", hasText("3"));
        verifyThat("#searchTermField", hasText("developer"));

        // към 10.02.2024 14.24 Минава успешно, вероятно няма да мине при тестване, затова е коментирано
        verifyThat("#tableView", TableViewMatchers.containsRow("Jobs.bg", "developer", "https://www.jobs.bg/job/7265335", "C# (.NET) Developer", "Не е посочена"));
    }
    /**
     * Tests the error handling in the main view, ensuring that an error dialog is displayed when an error occurs during the search process.
     */
    @Test
    void testError(){
        FxRobot robot = new FxRobot();

        WaitForAsyncUtils.waitForFxEvents();

        // set search term
        robot.clickOn("#searchTermField");
        WaitForAsyncUtils.waitForFxEvents();
        robot.clickOn("#searchTermField");
        robot.press(KeyCode.D).release(KeyCode.D).sleep(100).type(KeyCode.E)
                .sleep(100).type(KeyCode.V)
                .sleep(100).type(KeyCode.E)
                .sleep(100).type(KeyCode.L)
                .sleep(100).type(KeyCode.O)
                .sleep(100).type(KeyCode.P)
                .sleep(100).type(KeyCode.E)
                .sleep(100).type(KeyCode.R);

        WaitForAsyncUtils.waitForFxEvents();
        robot.clickOn("#search");

        WaitForAsyncUtils.waitForFxEvents();
        System.out.println(robot.lookup(".dialog-pane").queryAll().stream().findFirst().get());
        assertTrue(robot.lookup(".dialog-pane").queryAll().stream()
                .anyMatch(node -> node.isVisible() && node.lookup(".dialog-pane.alert.error") != null));
    }

}
