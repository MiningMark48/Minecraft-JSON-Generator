package com.miningmark48.jsongen.javafx;

import com.miningmark48.jsongen.Reference;
import com.sun.org.apache.regexp.internal.RE;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.logging.Logger;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));

        Scene scene = ReferenceScenes.getDefaultScene(root);

        stage.setTitle("Minecraft JSON Generator for Minecraft " + Reference.gameVersion + " by " + Reference.author);
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> Platform.exit());
        stage.getIcons().add(new Image(Reference.iconURL));
        stage.show();

        ReferenceAlerts.init();
    }
}
