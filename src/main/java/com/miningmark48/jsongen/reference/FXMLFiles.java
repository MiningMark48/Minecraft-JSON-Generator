package com.miningmark48.jsongen.reference;

import com.miningmark48.jsongen.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

import static com.miningmark48.jsongen.Main.LOADER_INSTANCE;

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
            FXML_MAIN = LOADER_INSTANCE.load(Main.INSTANCE.getClass().getResource("/fxml/main.fxml"));
            FXML_BLOCKS = LOADER_INSTANCE.load(Main.INSTANCE.getClass().getResource("/fxml/blocks.fxml"));
            FXML_ITEMS = LOADER_INSTANCE.load(Main.INSTANCE.getClass().getResource("/fxml/items.fxml"));
            FXML_MODINFO = LOADER_INSTANCE.load(Main.INSTANCE.getClass().getResource("/fxml/modinfo.fxml"));
            FXML_ADVANCEDBLOCKS = LOADER_INSTANCE.load(Main.INSTANCE.getClass().getResource("/fxml/blocks_advanced.fxml"));
            FXML_ADVANCEDBLOCKS_FENCE = LOADER_INSTANCE.load(Main.INSTANCE.getClass().getResource("/fxml/blocks_advanced/fence.fxml"));
            FXML_ADVANCEDBLOCKS_ORIENTED = LOADER_INSTANCE.load(Main.INSTANCE.getClass().getResource("/fxml/blocks_advanced/oriented.fxml"));
            FXML_ADVANCEDBLOCKS_PRESSUREPLATE = LOADER_INSTANCE.load(Main.INSTANCE.getClass().getResource("/fxml/blocks_advanced/pressure_plate.fxml"));
            FXML_ADVANCEDBLOCKS_SLAB = LOADER_INSTANCE.load(Main.INSTANCE.getClass().getResource("/fxml/blocks_advanced/slab.fxml"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
