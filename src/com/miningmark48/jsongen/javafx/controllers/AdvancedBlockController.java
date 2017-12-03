package com.miningmark48.jsongen.javafx.controllers;

import com.miningmark48.jsongen.Reference;
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
import javafx.stage.Stage;

import java.io.IOException;

public class AdvancedBlockController {

    @FXML private MenuBar menu_bar;

    @FXML private void handleCloseButtonAction(ActionEvent event){
        Platform.exit();
    }

    @FXML private void handleAboutButtonAction(ActionEvent event){
        ReferenceAlerts.aboutAlert.showAndWait();
    }

    @FXML private void handleOrientedButtonAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/blocks_advanced/oriented.fxml"));

        Scene scene = ReferenceScenes.getDefaultScene(root);

        stage.setTitle("Block - Oriented Generator");
        stage.setScene(scene);
        stage.getIcons().add(new Image(Reference.iconURL));
        stage.show();
    }

    @FXML private void handleFenceButtonAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/blocks_advanced/fence.fxml"));

        Scene scene = ReferenceScenes.getDefaultScene(root);

        stage.setTitle("Block - Fence Generator");
        stage.setScene(scene);
        stage.getIcons().add(new Image(Reference.iconURL));
        stage.show();
    }

    @FXML private void handlePressurePlateButtonAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/blocks_advanced/pressure_plate.fxml"));

        Scene scene = ReferenceScenes.getDefaultScene(root);

        stage.setTitle("Block - Pressure Plate Generator");
        stage.setScene(scene);
        stage.getIcons().add(new Image(Reference.iconURL));
        stage.show();
    }

    @FXML private void handleSlabButtonAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/blocks_advanced/slab.fxml"));

        Scene scene = ReferenceScenes.getDefaultScene(root);

        stage.setTitle("Block - Slab Generator");
        stage.setScene(scene);
        stage.getIcons().add(new Image(Reference.iconURL));
        stage.show();
    }

}
