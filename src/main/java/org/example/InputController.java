package org.example;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.time.LocalDate;

public class InputController {

    @FXML
    TextField nameTextField;

    @FXML
    DatePicker birthdayDatePicker;

    private final DataModel model;

    public InputController(DataModel model){
        this.model = model;
    }

    @FXML
    private void initialize(){

        birthdayDatePicker.setEditable(false);

        nameTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                model.nameProperty().set(newValue);
            }
        });

        birthdayDatePicker.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> ov, LocalDate oldValue, LocalDate newValue) {
                model.dateProperty().set(newValue.getDayOfMonth()+"."+newValue.getMonthValue()+"."+newValue.getYear());
            }
        });
    }

}
