package com.miningmark48.jsongen.javafx.controllers;

import com.miningmark48.jsongen.javafx.ReferenceAlerts;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

import java.io.IOException;

public class BlockController {

    @FXML private MenuBar menu_bar;

    @FXML private void handleCloseButtonAction(ActionEvent event){
        Platform.exit();
    }

    @FXML private void handleAboutButtonAction(ActionEvent event){
        ReferenceAlerts.aboutAlert.showAndWait();
    }

    @FXML private void handleAdvancedButtonAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/blocks_advanced/blocks_advanced.fxml"));

        Scene scene = new Scene(root, 800, 400);

        stage.setTitle("Block Generator - Advanced");
        stage.setScene(scene);
        stage.show();
    }

}
