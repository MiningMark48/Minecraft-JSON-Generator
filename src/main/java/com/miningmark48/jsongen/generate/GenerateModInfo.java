package com.miningmark48.jsongen.generate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import java.io.*;

public class GenerateModInfo {

    public static void genModInfo(String modId, String modName, String version, String gameVersion, String author, String url, String description, String credits, String path){

        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\mcmod.info"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginArray();
            jw.beginObject();

            jw.name("_comment").value("Generated using MiningMark48's JSON Generator.");
            jw.name("modid").value(modId);
            jw.name("name").value(modName);
            jw.name("description").value(description);
            jw.name("version").value(version);
            jw.name("credits").value(credits);
            jw.name("logoFile").value("");
            jw.name("mcversion").value(gameVersion);
            jw.name("url").value(url);
            jw.name("updateUrl").value("");
            jw.name("authorList");
            jw.beginArray();
            jw.value(author);
            jw.endArray();
            jw.name("parent").value("");
            jw.name("screenshots");
            jw.beginArray();
            jw.endArray();
            jw.name("dependencies");
            jw.beginArray();
            jw.value("mod_MinecraftForge");
            jw.endArray();

            jw.endObject();
            jw.endArray();

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
