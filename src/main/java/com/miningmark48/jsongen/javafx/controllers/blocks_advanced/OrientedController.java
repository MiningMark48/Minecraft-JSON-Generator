package com.miningmark48.jsongen.javafx.controllers;

import com.miningmark48.jsongen.generate.block.GenerateBlockOriented;
import com.miningmark48.jsongen.reference.Reference;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class OrientedController {

    @FXML private MenuBar menu_bar;
    @FXML private TextField fieldModId;
    @FXML private TextField fieldBlockName;
    @FXML private TextField fieldTopTexture;
    @FXML private TextField fieldBottomTexture;
    @FXML private TextField fieldFrontTexture;
    @FXML private TextField fieldSideTexture;
    @FXML private TextField fieldExportPath;

    @FXML private void handleCloseButtonAction(ActionEvent event){
        Platform.exit();
    }

    @FXML private void handleAboutButtonAction(ActionEvent event){
        Reference.aboutAlert.showAndWait();
    }

    @FXML private void handlePathButtonAction(ActionEvent event) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Choose resource directory");
        File defaultDirectory = new File("./export");
        chooser.setInitialDirectory(defaultDirectory);
        File selectedDirectory = chooser.showDialog(new Stage());
        if (selectedDirectory != null) fieldExportPath.setText(selectedDirectory.getPath());
    }

    @FXML private void handleGenerateButtonAction(ActionEvent event) {
        GenerateBlockOriented.genBlock(fieldModId.getText(), fieldBlockName.getText(), fieldTopTexture.getText(), fieldBottomTexture.getText(), fieldFrontTexture.getText(), fieldSideTexture.getText(), fieldExportPath.getText());

        fieldBlockName.clear();
        fieldTopTexture.clear();
        fieldBottomTexture.clear();
        fieldFrontTexture.clear();
        fieldSideTexture.clear();
        Reference.generatedAlert.showAndWait();
    }

}
