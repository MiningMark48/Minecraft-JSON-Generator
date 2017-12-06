package com.miningmark48.jsongen.reference;

import com.miningmark48.jsongen.Main;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Reference {

    public static String author = "MiningMark48";
    public static String version = "1.0.0";
    public static String gameVersion = "1.9.4+";
    public static String iconURL = "http://miningmark48.xyz/img/projects/mcjsongen/icon.png";
    public static String styleSheetResource = Main.INSTANCE.getClass().getResource("/bootstrap2.css").toString();

    public static Alert aboutAlert = new Alert(Alert.AlertType.INFORMATION);
    public static Alert generatedAlert = new Alert(Alert.AlertType.INFORMATION);


    public static void init() {
        aboutAlert.setTitle("About");
        aboutAlert.setHeaderText("About Minecraft JSON Generator");
        aboutAlert.setContentText("Minecraft JSON Generator v" + Reference.version + " by " + Reference.author);
        Stage aboutStage = (Stage) aboutAlert.getDialogPane().getScene().getWindow();
        aboutStage.getIcons().add(new Image(Reference.iconURL));

        generatedAlert.setTitle("Generated");
        generatedAlert.setHeaderText("Generation Successful");
        generatedAlert.setContentText("JSON was successfully generated.");
        Stage generatedStage = (Stage) generatedAlert.getDialogPane().getScene().getWindow();
        generatedStage.getIcons().add(new Image(Reference.iconURL));
    }

    public static Scene getDefaultScene(Parent root) {
        Scene scene = new Scene(root, 800, 400);
        scene.getStylesheets().add(styleSheetResource);
        return scene;
    }

    public static Scene getMainScene() {
        return getDefaultScene(FXMLFiles.FXML_MAIN);
    }

    public static Stage getDefaultStage() {
        Scene scene = getMainScene();
        Stage stage = new Stage();
        stage.setTitle("Minecraft JSON Generator for Minecraft " + Reference.gameVersion + " by " + Reference.author);
        stage.setScene(scene);
        stage.getIcons().add(new Image(Reference.iconURL));

        Text textVersion = (Text) scene.lookup("#textInfo");
        if (textVersion != null) {
            textVersion.setText("v" + Reference.version + " by " + Reference.author);
        }

        return stage;
    }

    public static void setRoot(Parent root) {
        Main.getMainStage().getScene().setRoot(root);
    }

}
