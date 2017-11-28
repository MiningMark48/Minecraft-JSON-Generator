package com.miningmark48.jsongen.javafx;

import com.miningmark48.jsongen.Reference;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));

        Scene scene = new Scene(root, 800, 400);

        stage.setTitle("Minecraft JSON Generator for Minecraft " + Reference.gameVersion + " by " + Reference.author);
        stage.setScene(scene);
        stage.show();

        ReferenceAlerts.init();
    }
}
