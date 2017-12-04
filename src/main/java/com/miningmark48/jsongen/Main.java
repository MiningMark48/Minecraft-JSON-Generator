package com.miningmark48.jsongen;

import com.miningmark48.jsongen.reference.FXMLFiles;
import com.miningmark48.jsongen.reference.Reference;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class Main extends Application {

    public static Main INSTANCE = new Main();
    public static FXMLLoader LOADER_INSTANCE = new FXMLLoader();

    public static Stage mainStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLFiles.initFXML();
        Reference.init();

        stage = Reference.getDefaultStage();
        stage.show();

        mainStage = stage;
    }

    public static Stage getMainStage() {
        return mainStage;
    }
}
