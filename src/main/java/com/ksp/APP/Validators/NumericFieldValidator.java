package com.ksp.APP.Validators;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import javafx.beans.property.StringProperty;

/**
 * The NumericFieldValidator class implements a change listener for numeric input validation.
 * It restricts the input of a TextField to numeric characters only.
 */
public class NumericFieldValidator implements ChangeListener<String> {

    /**
     * This method is called whenever the value of the observed property changes.
     * It restricts the input of the TextField to numeric characters only.
     *
     * @param observable the observable value
     * @param oldValue   the old value of the property
     * @param newValue   the new value of the property
     */
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        if (!newValue.matches("\\d*")) {
            TextField textField = (TextField) ((StringProperty) observable).getBean();
            textField.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }
}
