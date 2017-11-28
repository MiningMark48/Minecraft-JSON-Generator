package com.miningmark48.jsongen.javafx.controllers;

import com.miningmark48.jsongen.Reference;
import com.miningmark48.jsongen.javafx.ReferenceAlerts;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
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

        Scene scene = new Scene(root, 800, 400);

        stage.setTitle("Block Generator");
        stage.setScene(scene);
        stage.show();
    }

}