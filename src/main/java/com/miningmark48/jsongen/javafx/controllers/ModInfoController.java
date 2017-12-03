package com.miningmark48.jsongen.javafx.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.miningmark48.jsongen.generate.GenerateModInfo;
import com.miningmark48.jsongen.reference.Reference;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

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
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*.*"),
                new FileChooser.ExtensionFilter("Mod Info", "*.info"),
                new FileChooser.ExtensionFilter("JSON", "*.json")
        );
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
        Reference.aboutAlert.showAndWait();
    }

    @FXML private void handlePathButtonAction(ActionEvent event) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Choose resource directory");
        chooser.setInitialDirectory(new File(System.getProperty("user.home"), "Desktop"));
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
        Reference.generatedAlert.showAndWait();
    }

}
