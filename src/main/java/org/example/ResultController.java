package org.example;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResultController {

    @FXML
    private Label label;

    private static final String INTER_STRING = " alles Gute zum Geburtstag am ";

    private final DataModel model;

    public ResultController(DataModel model){
        this.model = model;
    }

    @FXML
    private void initialize(){
        label.textProperty().bind(
                Bindings.when(
                        Bindings.and(
                                model.nameProperty().isNotNull(),
                                model.dateProperty().isNotNull())
                        ).then(Bindings.concat(
                                model.nameProperty(),
                                INTER_STRING,
                                model.dateProperty()))
                        .otherwise(""));
    }
}
