package com.miningmark48.jsongen.javafx.controllers;

import com.miningmark48.jsongen.reference.Reference;
import com.miningmark48.jsongen.reference.ReferenceAlerts;
import com.miningmark48.jsongen.reference.ReferenceScenes;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML private MenuBar menu_bar;

    @FXML private void handleCloseButtonAction(ActionEvent event){
        Platform.exit();
    }

    @FXML private void handleAboutButtonAction(ActionEvent event){
        ReferenceAlerts.aboutAlert.showAndWait();
    }

    @FXML private void handleBlockButtonAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/blocks.fxml"));

        Scene scene = ReferenceScenes.getDefaultScene(root);

        stage.setTitle("Block Generator");
        stage.setScene(scene);
        stage.getIcons().add(new Image(Reference.iconURL));
        stage.show();
    }

    @FXML private void handleItemButtonAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/items.fxml"));

        Scene scene = ReferenceScenes.getDefaultScene(root);

        stage.setTitle("Item Generator");
        stage.setScene(scene);
        stage.getIcons().add(new Image(Reference.iconURL));
        stage.show();
    }

    @FXML private void handleModInfoButtonAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/modinfo.fxml"));

        Scene scene = ReferenceScenes.getDefaultScene(root);

        stage.setTitle("Mod Info Generator");
        stage.setScene(scene);
        stage.getIcons().add(new Image(Reference.iconURL));
        stage.show();
    }

}
