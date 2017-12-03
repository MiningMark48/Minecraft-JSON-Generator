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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("javafx/fxml/main.fxml"));

        Scene scene = Reference.getDefaultScene(root);

        stage.setTitle("Minecraft JSON Generator for Minecraft " + Reference.gameVersion + " by " + Reference.author);
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> Platform.exit());
        stage.getIcons().add(new Image(Reference.iconURL));
        stage.show();

        Reference.init();
    }
}
