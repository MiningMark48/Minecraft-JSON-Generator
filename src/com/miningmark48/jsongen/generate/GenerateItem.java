package com.miningmark48.jsongen.generate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class GenerateItem {

    public static void genItem(String modId, String itemName, String textureName){

        File fileDir = new File(".\\export\\models\\item\\");
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        PrintWriter item;
        try {

            item = new PrintWriter(fileDir + "\\" + itemName + ".json", "UTF-8");
            item.println("{");
            item.println("\t\"parent\": \"item/generated\",");
            item.println("\t\"textures\": {");
            item.println("\t\t\"layer0\": \"" + modId + ":items/" + textureName + "\"");
            item.println("\t}");
            item.println("}");
            item.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void genTool(String modId, String itemName, String textureName){

        File fileDir = new File(".\\export\\models\\item\\");
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        PrintWriter item;
        try {

            item = new PrintWriter(fileDir + "\\" + itemName + ".json", "UTF-8");
            item.println("{");
            item.println("\t\"parent\": \"item/handheld\",");
            item.println("\t\"textures\": {");
            item.println("\t\t\"layer0\": \"" + modId + ":items/" + textureName + "\"");
            item.println("\t}");
            item.println("}");
            item.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
