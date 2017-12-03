package com.miningmark48.jsongen.reference;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class ReferenceScenes {

    public static Scene getDefaultScene(Parent root) {
        Scene scene = new Scene(root, 800, 400);
        scene.getStylesheets().add("http://miningmark48.xyz/projects/mcjsongen/res/theme.css");
        return scene;
    }

}
