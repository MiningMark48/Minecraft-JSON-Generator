package com.miningmark48.jsongen.javafx.controllers;

import com.miningmark48.jsongen.Reference;
import com.miningmark48.jsongen.generate.GenerateBlock;
import com.miningmark48.jsongen.javafx.ReferenceAlerts;
import com.miningmark48.jsongen.javafx.ReferenceScenes;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class BlockController {

    @FXML private MenuBar menu_bar;
    @FXML private TextField fieldModId;
    @FXML private TextField fieldBlockName;
    @FXML private TextField fieldTextureName;
    @FXML private TextField fieldExportPath;

    @FXML private void handleCloseButtonAction(ActionEvent event){
        Platform.exit();
    }

    @FXML private void handleAboutButtonAction(ActionEvent event){
        ReferenceAlerts.aboutAlert.showAndWait();
    }

    @FXML private void handlePathButtonAction(ActionEvent event) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Choose resource directory");
        File defaultDirectory = new File("./export");
        chooser.setInitialDirectory(defaultDirectory);
        File selectedDirectory = chooser.showDialog(new Stage());
        if (selectedDirectory != null) fieldExportPath.setText(selectedDirectory.getPath());
    }

    @FXML private void handleAdvancedButtonAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/blocks_advanced.fxml"));

        Scene scene = ReferenceScenes.getDefaultScene(root);

        stage.setTitle("Block Generator - Advanced");
        stage.setScene(scene);
        stage.getIcons().add(new Image(Reference.iconURL));
        stage.show();
    }

    @FXML private void handleGenerateButtonAction(ActionEvent event) {
        GenerateBlock.genBlock(fieldModId.getText(), fieldBlockName.getText(), fieldTextureName.getText(), fieldExportPath.getText());

        fieldBlockName.clear();
        fieldTextureName.clear();
        ReferenceAlerts.generatedAlert.showAndWait();
    }

}
