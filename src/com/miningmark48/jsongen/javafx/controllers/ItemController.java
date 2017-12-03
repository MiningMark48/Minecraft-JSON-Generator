package com.miningmark48.jsongen.javafx.controllers;

import com.miningmark48.jsongen.generate.GenerateItem;
import com.miningmark48.jsongen.reference.Reference;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class ItemController {

    @FXML private MenuBar menu_bar;
    @FXML private TextField fieldModId;
    @FXML private TextField fieldBlockName;
    @FXML private TextField fieldTextureName;
    @FXML private TextField fieldExportPath;
    @FXML private CheckBox checkBoxTool;

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
        if (checkBoxTool.isSelected()) {
            GenerateItem.genTool(fieldModId.getText(), fieldBlockName.getText(), fieldTextureName.getText(), fieldExportPath.getText());
            checkBoxTool.setSelected(false);
        } else {
            GenerateItem.genItem(fieldModId.getText(), fieldBlockName.getText(), fieldTextureName.getText(), fieldExportPath.getText());
        }

        fieldBlockName.clear();
        fieldTextureName.clear();
        Reference.generatedAlert.showAndWait();
    }

}
