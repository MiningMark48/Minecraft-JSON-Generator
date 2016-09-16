package com.miningmark48.jsongen.generate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import java.io.*;

public class GenerateBlockOriented {

    public static void genBlock(String modId, String blockName, String topTextureName, String bottomTextureName, String frontTextureName, String sidesTextureName, String path){

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

            jw.name("facing=north");
            jw.beginObject();
            jw.name("model").value(blockName);
            jw.endObject();

            jw.name("facing=south");
            jw.beginObject();
            jw.name("model").value(blockName);
            jw.name("y").value(180);
            jw.endObject();

            jw.name("facing=west");
            jw.beginObject();
            jw.name("model").value(blockName);
            jw.name("y").value(270);
            jw.endObject();

            jw.name("facing=east");
            jw.beginObject();
            jw.name("model").value(blockName);
            jw.name("y").value(90);
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

        genBlockModel(modId, blockName, topTextureName, bottomTextureName, frontTextureName, sidesTextureName, path);
        genBlockItemModel(modId, blockName, path);

    }

    private static void genBlockModel(String modId, String blockName, String topTextureName, String bottomTextureName, String frontTextureName, String sidesTextureName, String path){

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
            jw.name("parent").value("block/orientable");
            jw.name("textures");
            jw.beginObject();
            jw.name("top").value(modId + ":blocks/" + topTextureName);
            jw.name("front").value(modId + ":blocks/" + frontTextureName);
            jw.name("side").value(modId + ":blocks/" + sidesTextureName);
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
