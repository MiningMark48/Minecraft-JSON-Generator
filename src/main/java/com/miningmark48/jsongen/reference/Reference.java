package com.miningmark48.jsongen.reference;

import com.miningmark48.jsongen.Main;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Reference {

    public static String author = "MiningMark48";
    public static String version = "1.0.0";
    public static String gameVersion = "1.9.4+";
    public static String iconURL = "http://miningmark48.xyz/img/projects/mcjsongen/icon.png";
    public static String styleSheetURL = "http://miningmark48.xyz/projects/mcjsongen/res/theme.css";

    public static Alert aboutAlert = new Alert(Alert.AlertType.INFORMATION);
    public static Alert generatedAlert = new Alert(Alert.AlertType.INFORMATION);

    public static void init() {
        aboutAlert.setTitle("About");
        aboutAlert.setHeaderText("About Minecraft Json Generator");
        aboutAlert.setContentText("Minecraft JSON Generator v" + Reference.version + " by " + Reference.author);

        generatedAlert.setTitle("Generated");
        generatedAlert.setHeaderText("Generation Successful");
        generatedAlert.setContentText("JSON was successfully generated.");
    }

    public static Scene getDefaultScene(Parent root) {
        Scene scene = new Scene(root, 800, 400);
        scene.getStylesheets().add(styleSheetURL);
        return scene;
    }

    public static Scene getMainScene() {
        Scene scene = null;
        try {
            scene = getDefaultScene(FXMLLoader.load(Main.INSTANCE.getClass().getResource("/fxml/main.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return scene;
    }

    public static Stage getDefaultStage() {
        Scene scene = null;
        try {
            scene = getDefaultScene(FXMLLoader.load(Main.INSTANCE.getClass().getResource("/fxml/main.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Minecraft JSON Generator for Minecraft " + Reference.gameVersion + " by " + Reference.author);
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> Platform.exit());
        stage.getIcons().add(new Image(Reference.iconURL));
        return stage;
    }

    public static void showScene(Scene scene) {
        Stage stage = Main.getMainStage();
        stage.setScene(scene);
        stage.show();
    }

}
