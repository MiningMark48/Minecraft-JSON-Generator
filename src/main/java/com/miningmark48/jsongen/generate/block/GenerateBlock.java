package com.miningmark48.jsongen.generate.block;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import java.io.*;

public class GenerateBlock {

    public static void genBlock(String modId, String blockName, String textureName, String path){

        File fileDir = new File(path + "\\blockstates\\");
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("_comment").value("Generated using MiningMark48's JSON Generator.");
            jw.name("variants");
            jw.beginObject();
            jw.name("normal");
            jw.beginObject();
            jw.name("model").value(modId + ":" + blockName);
            jw.endObject();
            jw.endObject();
            jw.endObject();

            writer.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("_comment").value("Generated using MiningMark48's JSON Generator.");
            jw.name("parent").value("block/cube_all");
            jw.name("textures");
            jw.beginObject();
            jw.name("all").value(modId + ":blocks/" + textureName);
            jw.endObject();
            jw.endObject();

            writer.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void genBlockItemModel(String modId, String blockName, String path){

        File fileDir = new File(path + "\\models\\item\\");
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();

            jw.name("_comment").value("Generated using MiningMark48's JSON Generator.");
            jw.name("parent").value(modId + ":block/" + blockName);

            jw.endObject();

            writer.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
