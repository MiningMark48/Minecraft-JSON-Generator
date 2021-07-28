package com.miningmark48.jsongen.javafx.controllers;

import com.miningmark48.jsongen.Main;
import com.miningmark48.jsongen.reference.FXMLFiles;
import com.miningmark48.jsongen.reference.Reference;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;

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
        Reference.setRoot(FXMLFiles.FXML_MAIN);
    }

    @FXML private void handleOrientedButtonAction(ActionEvent event) throws IOException {
        Main.getMainStage().getScene().setRoot(FXMLFiles.FXML_ADVANCEDBLOCKS_ORIENTED);
    }

    @FXML private void handleFenceButtonAction(ActionEvent event) throws IOException {
        Main.getMainStage().getScene().setRoot(FXMLFiles.FXML_ADVANCEDBLOCKS_FENCE);
    }

    @FXML private void handlePressurePlateButtonAction(ActionEvent event) throws IOException {
        Main.getMainStage().getScene().setRoot(FXMLFiles.FXML_ADVANCEDBLOCKS_PRESSUREPLATE);
    }

    @FXML private void handleSlabButtonAction(ActionEvent event) throws IOException {
        Main.getMainStage().getScene().setRoot(FXMLFiles.FXML_ADVANCEDBLOCKS_SLAB);
    }

}
