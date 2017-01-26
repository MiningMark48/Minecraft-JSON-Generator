package com.miningmark48.jsongen.generate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import java.io.*;

public class GenerateBlockFence {

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
            jw.name("multipart");
            jw.beginArray();
            jw.beginObject();
            jw.name("apply");
            jw.beginObject();
            jw.name("model").value(modId + ":" + blockName + "_post");
            jw.endObject();
            jw.endObject();
            jw.beginObject();
            jw.name("when");
            jw.beginObject();
            jw.name("north").value("true");
            jw.endObject();
            jw.name("apply");
            jw.beginObject();
            jw.name("model").value(modId + ":" + blockName + "_side");
            jw.name("uvlock").value(true);
            jw.endObject();
            jw.endObject();
            jw.beginObject();
            jw.name("when");
            jw.beginObject();
            jw.name("east").value("true");
            jw.endObject();
            jw.name("apply");
            jw.beginObject();
            jw.name("model").value(modId + ":" + blockName + "_side");
            jw.name("y").value(90);
            jw.name("uvlock").value(true);
            jw.endObject();
            jw.endObject();
            jw.beginObject();
            jw.name("when");
            jw.beginObject();
            jw.name("south").value("true");
            jw.endObject();
            jw.name("apply");
            jw.beginObject();
            jw.name("model").value(modId + ":" + blockName + "_side");
            jw.name("y").value(180);
            jw.name("uvlock").value(true);
            jw.endObject();
            jw.endObject();
            jw.beginObject();
            jw.name("when");
            jw.beginObject();
            jw.name("west").value("true");
            jw.endObject();
            jw.name("apply");
            jw.beginObject();
            jw.name("model").value(modId + ":" + blockName + "_side");
            jw.name("y").value(270);
            jw.name("uvlock").value(true);
            jw.endObject();
            jw.endObject();
            jw.endArray();
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

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + "_post" + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("_comment").value("Generated using MiningMark48's JSON Generator.");
            jw.name("parent").value("block/fence_post");
            jw.name("textures");
            jw.beginObject();
            jw.name("texture").value(modId + ":blocks/" + textureName);
            jw.endObject();
            jw.endObject();

            writer.close();

            Writer writer2 = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + "_side" + ".json"), "UTF-8");
            JsonWriter jw2 = gson.newJsonWriter(writer2);

            jw2.beginObject();
            jw2.name("_comment").value("Generated using MiningMark48's JSON Generator.");
            jw2.name("parent").value("block/fence_side");
            jw2.name("textures");
            jw2.beginObject();
            jw2.name("texture").value(modId + ":blocks/" + textureName);
            jw2.endObject();
            jw2.endObject();

            writer2.close();

            Writer writer3 = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + blockName + "_inventory" + ".json"), "UTF-8");
            JsonWriter jw3 = gson.newJsonWriter(writer3);

            jw3.beginObject();
            jw3.name("_comment").value("Generated using MiningMark48's JSON Generator.");
            jw3.name("parent").value("block/fence_inventory");
            jw3.name("textures");
            jw3.beginObject();
            jw3.name("texture").value(modId + ":blocks/" + textureName);
            jw3.endObject();
            jw3.endObject();

            writer3.close();

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
            jw.name("parent").value(modId + ":block/" + blockName + "_inventory");

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
