package com.miningmark48.jsongen.generate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class GenerateBlock {

    public static void genBlock(String modId, String blockName, String textureName, String path){

        File fileDir = new File(path + "\\blockstates\\");
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        PrintWriter block;
        try {

            block = new PrintWriter(fileDir + "\\" + blockName + ".json", "UTF-8");
            block.println("{");
            block.println("\t\"variants\": {");
            block.println("\t\t\"normal\": { \"model\": \"" + blockName + "\" }");
            block.println("\t}");
            block.println("}");
            block.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        genBlockModel(modId, blockName, textureName, path);
        genBlockItemModel(modId, blockName, path);

    }

    private static void genBlockModel(String modId, String blockName, String textureName, String path){

        File fileDir = new File(path + "\\models\\block\\");
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        PrintWriter block;
        try {

            block = new PrintWriter(fileDir + "\\" + blockName + ".json", "UTF-8");
            block.println("{");
            block.println("\t\"parent\": \"block/cube_all\",");
            block.println("\t\"textures\": {");
            block.println("\t\t\"all\": \"" + modId + ":blocks/" + textureName + "\"");
            block.println("\t}");
            block.println("}");
            block.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    private static void genBlockItemModel(String modId, String blockName, String path) {

        File fileDir = new File(path + "\\models\\item\\");
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        PrintWriter block;
        try {

            block = new PrintWriter(fileDir + "\\" + blockName + ".json", "UTF-8");
            block.println("{");
            block.println("\t\"parent\": \"" + modId + ":block/" + blockName + "\"");
            block.println("}");
            block.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


}
