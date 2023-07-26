package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class Main extends Application {

    private static Scene scene;

    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_HEIGHT = 300;

    @Override
    public void start(Stage stage) throws IOException {
        final DataModel model = new DataModel();
        scene = new Scene(loadFXML("primary", model), WINDOW_WIDTH, WINDOW_HEIGHT);
        scene.getStylesheets().add("tab.css");
        stage.setTitle("Geburtstag");
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml, DataModel model) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        fxmlLoader.setControllerFactory(type -> {
            if(type.equals(PrimaryController.class)) return new PrimaryController();
            if(type.equals(InputController.class)) return new InputController(model);
            if(type.equals(ResultController.class)) return new ResultController(model);
            throw new IllegalArgumentException("Unexpected controller type: "+type);
        });
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}