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
            item.println("\t},");
            item.println("\t\"display\": {");
            item.println("\t\t\"thirdperson_righthand\": {");
            item.println("\t\t\t\"rotation\": [ 0, -90, 55 ],");
            item.println("\t\t\t\"translation\": [ 0, 4.0, 0.5 ],");
            item.println("\t\t\t\"scale\": [ 0.85, 0.85, 0.85 ]");
            item.println("\t\t},");
            item.println("\t\t\"firstperson_righthand\": {");
            item.println("\t\t\t\"rotation\": [ 0, -90, 25 ],");
            item.println("\t\t\t\"translation\": [ 1.13, 3.2, 1.13 ],");
            item.println("\t\t\t\"scale\": [ 0.68, 0.68, 0.68 ]");
            item.println("\t\t}");
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
