package com.miningmark48.jsongen.javafx.controllers;

import com.miningmark48.jsongen.reference.FXMLFiles;
import com.miningmark48.jsongen.reference.Reference;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;

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
        Reference.setRoot(FXMLFiles.FXML_BLOCKS);
    }

    @FXML private void handleItemButtonAction(ActionEvent event) throws IOException {
        Reference.setRoot(FXMLFiles.FXML_ITEMS);
    }

    @FXML private void handleModInfoButtonAction(ActionEvent event) throws IOException {
        Reference.setRoot(FXMLFiles.FXML_MODINFO);
    }

}
