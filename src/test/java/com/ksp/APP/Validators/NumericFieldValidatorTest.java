package com.ksp.APP.Validators;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the NumericFieldValidator class.
 */
class NumericFieldValidatorTest extends ApplicationTest {

    /**
     * Starts the JavaFX application for testing.
     *
     * @param stage The primary stage of the JavaFX application.
     */
    @Override
    public void start(Stage stage) {
        // Create a text field and attach the validator to it
        TextField textField = new TextField();
        NumericFieldValidator validator = new NumericFieldValidator();
        textField.textProperty().addListener((observable, oldValue, newValue) ->
                validator.changed(textField.textProperty(), oldValue, newValue));

        // Set the scene with the text field
        stage.setScene(new Scene(textField));
        stage.show();
    }

    /**
     * Test to verify that non-numeric characters are replaced.
     */
    @Test
    void changed_ShouldReplaceNonNumericCharacters() {
        clickOn(".text-field").write("abc123");

        assertEquals("123", lookup(".text-field").queryTextInputControl().getText());
    }

    /**
     * Test to verify that numeric characters are not replaced.
     */
    @Test
    void changed_ShouldNotReplaceNumericCharacters() {
        clickOn(".text-field").write("123");

        assertEquals("123", lookup(".text-field").queryTextInputControl().getText());
    }

    /**
     * Test to verify that invalid characters are replaced with empty string.
     */
    @Test
    void changed_ShouldReplaceInvalidCharactersWithEmptyString() {
        clickOn(".text-field").write("abc!@#");

        assertEquals("", lookup(".text-field").queryTextInputControl().getText());
    }

    /**
     * Test to verify that input with spaces is handled correctly.
     */
    @Test
    void changed_ShouldHandleInputWithSpaces() {
        clickOn(".text-field").write("12 34");

        assertEquals("1234", lookup(".text-field").queryTextInputControl().getText());
    }

}
