package com.miningmark48.jsongen.generate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.util.*;

public class GenerateRecipes {

    public static void genShaped(String path, String name, String row1, String row2, String row3, String[] keys, String[] values, String result, int resultCount){

        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\ " + name + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();

            jw.name("_comment").value("Generated using MiningMark48's JSON Generator.");
            jw.name("type").value("crafting_shaped");
            jw.name("pattern");
            jw.beginArray();
            jw.value(row1);
            jw.value(row2);
            jw.value(row3);
            jw.endArray();
            jw.name("key");
            jw.beginObject();

            for (int i = 0; i <= keys.length - 1; i++){
                if (!values[i].equalsIgnoreCase("")) {
                    jw.name(keys[i]);
                    jw.beginObject();
                    jw.name("item").value(values[i]);
                    jw.endObject();
                }
            }

            jw.endObject();

            jw.name("result");
            jw.beginObject();

            jw.name("item").value(result);
            if (resultCount > 1) jw.name("count").value(resultCount);

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
