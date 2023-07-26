package org.example;

import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;

public class PrimaryController {

    private static final String[] LIST_ITEMS = {"Dateneingabe", "Ergebnis"};
    @FXML
    private TabPane tabPane;

    @FXML
    private Tab inputTab, resultTab;

    public void initialize(){
        tabPane.setSide(Side.LEFT);
        tabPane.setRotateGraphic(true);

        setUpTab(inputTab, LIST_ITEMS[0]);
        setUpTab(resultTab, LIST_ITEMS[1]);


        tabPane.setTabMinHeight(200);
        tabPane.setTabMaxHeight(200);

    }

    private void setUpTab(Tab tab, String title){

        Label l = new Label(title);
        l.setRotate(90);
        StackPane stp = new StackPane(new Group(l));
        stp.setRotate(90);
        tab.setGraphic(stp);
        tab.setClosable(false);
    }
}
