package com.miningmark48.jsongen;

import com.miningmark48.jsongen.reference.Reference;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static Main INSTANCE = new Main();

    public static Stage mainStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage = Reference.getDefaultStage();
        stage.show();

        mainStage = stage;
        Reference.init();
    }

    public static Stage getMainStage() {
        return mainStage;
    }
}
