package com.miningmark48.jsongen.reference;

import javafx.scene.control.Alert;

public class ReferenceAlerts {

    public static Alert aboutAlert = new Alert(Alert.AlertType.INFORMATION);
    public static Alert generatedAlert = new Alert(Alert.AlertType.INFORMATION);

    public static void init() {
        aboutAlert.setTitle("About");
        aboutAlert.setHeaderText("About Minecraft Json Generator");
        aboutAlert.setContentText("Minecraft JSON Generator v" + Reference.version + " by " + Reference.author);

        generatedAlert.setTitle("Generated");
        generatedAlert.setHeaderText("Generation Successful");
        generatedAlert.setContentText("JSON was successfully generated.");
    }

}
