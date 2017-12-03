package com.miningmark48.jsongen.javafx.controllers;

import com.miningmark48.jsongen.Main;
import com.miningmark48.jsongen.reference.Reference;
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
        Reference.aboutAlert.showAndWait();
    }

    @FXML private void handleBlockButtonAction(ActionEvent event) throws IOException {
        Reference.showScene(Reference.getDefaultScene(FXMLLoader.load(getClass().getResource("/fxml/blocks.fxml"))));
    }

    @FXML private void handleItemButtonAction(ActionEvent event) throws IOException {
        Reference.showScene(Reference.getDefaultScene(FXMLLoader.load(getClass().getResource("/fxml/items.fxml"))));
    }

    @FXML private void handleModInfoButtonAction(ActionEvent event) throws IOException {
        Reference.showScene(Reference.getDefaultScene(FXMLLoader.load(getClass().getResource("/fxml/modinfo.fxml"))));
    }

}
