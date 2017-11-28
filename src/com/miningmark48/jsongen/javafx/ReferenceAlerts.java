package com.miningmark48.jsongen.javafx;

import com.miningmark48.jsongen.Reference;
import javafx.scene.control.Alert;

public class ReferenceAlerts {

    public static Alert aboutAlert = new Alert(Alert.AlertType.INFORMATION);

    public static void init() {
        aboutAlert.setTitle("About");
        aboutAlert.setHeaderText("About Minecraft Json Generator");
        aboutAlert.setContentText("Minecraft JSON Generator v" + Reference.version + " by " + Reference.author);
    }

}
