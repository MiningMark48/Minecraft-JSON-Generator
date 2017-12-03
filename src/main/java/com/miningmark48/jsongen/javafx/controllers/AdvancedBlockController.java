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

public class AdvancedBlockController {

    @FXML private MenuBar menu_bar;

    @FXML private void handleCloseButtonAction(ActionEvent event){
        Platform.exit();
    }

    @FXML private void handleAboutButtonAction(ActionEvent event){
        Reference.aboutAlert.showAndWait();
    }

    @FXML private void handleMenuButtonAction(ActionEvent event) {
        Main.mainStage.setScene(Reference.getMainScene());
    }

    @FXML private void handleOrientedButtonAction(ActionEvent event) throws IOException {
        Reference.showScene(Reference.getDefaultScene(FXMLLoader.load(getClass().getResource("/fxml/blocks_advanced/oriented.fxml"))));
    }

    @FXML private void handleFenceButtonAction(ActionEvent event) throws IOException {
        Reference.showScene(Reference.getDefaultScene(FXMLLoader.load(getClass().getResource("/fxml/blocks_advanced/fence.fxml"))));
    }

    @FXML private void handlePressurePlateButtonAction(ActionEvent event) throws IOException {
        Reference.showScene(Reference.getDefaultScene(FXMLLoader.load(getClass().getResource("/fxml/blocks_advanced/pressure_plate.fxml"))));
    }

    @FXML private void handleSlabButtonAction(ActionEvent event) throws IOException {
        Reference.showScene(Reference.getDefaultScene(FXMLLoader.load(getClass().getResource("/fxml/blocks_advanced/slab.fxml"))));
    }

}
