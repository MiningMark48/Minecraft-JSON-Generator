package com.miningmark48.jsongen.javafx.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.miningmark48.jsongen.Reference;
import com.miningmark48.jsongen.generate.GenerateBlock;
import com.miningmark48.jsongen.generate.GenerateModInfo;
import com.miningmark48.jsongen.javafx.ReferenceAlerts;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ModInfoController {

    @FXML private MenuBar menu_bar;
    @FXML private TextField fieldModID;
    @FXML private TextField fieldModName;
    @FXML private TextField fieldModVersion;
    @FXML private TextField fieldGameVersion;
    @FXML private TextField fieldAuthor;
    @FXML private TextField fieldURL;
    @FXML private TextArea fieldDesc;
    @FXML private TextArea fieldCredit;
    @FXML private TextField fieldExportPath;

    @FXML private void handleCloseButtonAction(ActionEvent event){
        Platform.exit();
    }

    @FXML private void handleImportButtonAction(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(new Stage());

        try {

            if (file != null && file.exists()) {
                JsonParser jp = new JsonParser();
                JsonElement root = jp.parse(new FileReader(file.getPath()));
                JsonArray rootArray = root.getAsJsonArray();
                JsonObject rootObj = rootArray.get(0).getAsJsonObject();

                fieldModID.setText(rootObj.get("modid").getAsString());
                fieldModName.setText(rootObj.get("name").getAsString());
                fieldModVersion.setText(rootObj.get("version").getAsString());
                fieldGameVersion.setText(rootObj.get("mcversion").getAsString());
                fieldAuthor.setText(rootObj.get("authorList").getAsJsonArray().get(0).getAsString());
                fieldURL.setText(rootObj.get("url").getAsString());
                fieldDesc.setText(rootObj.get("description").getAsString());
                fieldCredit.setText(rootObj.get("credits").getAsString());
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

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

    @FXML private void handleGenerateButtonAction(ActionEvent event) {
        GenerateModInfo.genModInfo(fieldModID.getText(), fieldModName.getText(), fieldModVersion.getText(), fieldGameVersion.getText(), fieldAuthor.getText(), fieldURL.getText(), fieldDesc.getText(), fieldCredit.getText(), fieldExportPath.getText());

        fieldModID.clear();
        fieldModName.clear();
        fieldModVersion.clear();
        fieldGameVersion.clear();
        fieldAuthor.clear();
        fieldURL.clear();
        fieldDesc.clear();
        fieldCredit.clear();
        ReferenceAlerts.generatedAlert.showAndWait();
    }

}