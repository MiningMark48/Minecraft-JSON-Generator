package com.miningmark48.jsongen.generate.block;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import java.io.*;

public class GenerateBlockSlab {

    public static void genBlock(String modId, String blockName, String textureName, String blockMockName, String path){

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

            jw.name("half=bottom");
            jw.beginObject();
            jw.name("model").value("half_" + blockName);
            jw.endObject();

            jw.name("half=top");
            jw.beginObject();
            jw.name("model").value("upper_" + blockName);
            jw.endObject();

            jw.endObject();
            jw.endObject();

            writer.close();

            Writer writer2 = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + "_double" + ".json"), "UTF-8");
            Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw2 = gson2.newJsonWriter(writer2);

            jw2.beginObject();
            jw2.name("_comment").value("Generated using MiningMark48's JSON Generator.");
            jw2.name("variants");
            jw2.beginObject();

            jw2.name("normal");
            jw2.beginObject();
            jw2.name("model").value(blockMockName);
            jw2.endObject();

            jw2.name("all");
            jw2.beginObject();
            jw2.name("model").value(blockMockName);
            jw2.endObject();

            jw2.endObject();
            jw2.endObject();

            writer2.close();

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

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + "half_" + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("_comment").value("Generated using MiningMark48's JSON Generator.");
            jw.name("parent").value("block/half_slab");
            jw.name("textures");
            jw.beginObject();
            jw.name("bottom").value(modId + ":blocks/" + textureName);
            jw.name("top").value(modId + ":blocks/" + textureName);
            jw.name("side").value(modId + ":blocks/" + textureName);
            jw.endObject();
            jw.endObject();

            writer.close();

            Writer writer2 = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + "upper_" + blockName + ".json"), "UTF-8");
            JsonWriter jw2 = gson.newJsonWriter(writer2);

            jw2.beginObject();
            jw2.name("_comment").value("Generated using MiningMark48's JSON Generator.");
            jw2.name("parent").value("block/upper_slab");
            jw2.name("textures");
            jw2.beginObject();
            jw2.name("bottom").value(modId + ":blocks/" + textureName);
            jw2.name("top").value(modId + ":blocks/" + textureName);
            jw2.name("side").value(modId + ":blocks/" + textureName);
            jw2.endObject();
            jw2.endObject();

            writer2.close();

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
            jw.name("parent").value(modId + ":block/" + "half_" + blockName);

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
