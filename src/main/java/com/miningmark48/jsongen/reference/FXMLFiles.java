package com.miningmark48.jsongen.reference;

import com.miningmark48.jsongen.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class FXMLFiles {

    public static Parent FXML_MAIN;
    public static Parent FXML_BLOCKS;
    public static Parent FXML_ITEMS;
    public static Parent FXML_MODINFO;
    public static Parent FXML_ADVANCEDBLOCKS;
    public static Parent FXML_ADVANCEDBLOCKS_FENCE;
    public static Parent FXML_ADVANCEDBLOCKS_ORIENTED;
    public static Parent FXML_ADVANCEDBLOCKS_PRESSUREPLATE;
    public static Parent FXML_ADVANCEDBLOCKS_SLAB;

    public static void initFXML() {
        try {
            FXML_MAIN = FXMLLoader.load(Main.INSTANCE.getClass().getResource("/fxml/main.fxml"));
            FXML_BLOCKS = FXMLLoader.load(Main.INSTANCE.getClass().getResource("/fxml/blocks.fxml"));
            FXML_ITEMS = FXMLLoader.load(Main.INSTANCE.getClass().getResource("/fxml/items.fxml"));
            FXML_MODINFO = FXMLLoader.load(Main.INSTANCE.getClass().getResource("/fxml/modinfo.fxml"));
            FXML_ADVANCEDBLOCKS = FXMLLoader.load(Main.INSTANCE.getClass().getResource("/fxml/blocks_advanced.fxml"));
            FXML_ADVANCEDBLOCKS_FENCE = FXMLLoader.load(Main.INSTANCE.getClass().getResource("/fxml/blocks_advanced/fence.fxml"));
            FXML_ADVANCEDBLOCKS_ORIENTED = FXMLLoader.load(Main.INSTANCE.getClass().getResource("/fxml/blocks_advanced/oriented.fxml"));
            FXML_ADVANCEDBLOCKS_PRESSUREPLATE = FXMLLoader.load(Main.INSTANCE.getClass().getResource("/fxml/blocks_advanced/pressure_plate.fxml"));
            FXML_ADVANCEDBLOCKS_SLAB = FXMLLoader.load(Main.INSTANCE.getClass().getResource("/fxml/blocks_advanced/slab.fxml"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
