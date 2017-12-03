package com.miningmark48.jsongen.javafx.controllers;

import com.miningmark48.jsongen.Main;
import com.miningmark48.jsongen.generate.block.GenerateBlock;
import com.miningmark48.jsongen.reference.Reference;
import com.sun.org.apache.regexp.internal.RE;
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
        Reference.aboutAlert.showAndWait();
    }

    @FXML private void handleMenuButtonAction(ActionEvent event) {
        Main.mainStage.setScene(Reference.getMainScene());
    }

    @FXML private void handlePathButtonAction(ActionEvent event) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Choose resource directory");
        chooser.setInitialDirectory(new File(System.getProperty("user.home"), "Desktop"));
        File selectedDirectory = chooser.showDialog(new Stage());
        if (selectedDirectory != null) fieldExportPath.setText(selectedDirectory.getPath());
    }

    @FXML private void handleAdvancedButtonAction(ActionEvent event) throws IOException {
        Reference.showScene(Reference.getDefaultScene(FXMLLoader.load(getClass().getResource("/fxml/blocks_advanced.fxml"))));
    }

    @FXML private void handleGenerateButtonAction(ActionEvent event) {
        GenerateBlock.genBlock(fieldModId.getText(), fieldBlockName.getText(), fieldTextureName.getText(), fieldExportPath.getText());

        fieldBlockName.clear();
        fieldTextureName.clear();
        Reference.generatedAlert.showAndWait();
    }

}
