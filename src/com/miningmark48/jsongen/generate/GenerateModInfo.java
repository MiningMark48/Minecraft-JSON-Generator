package com.miningmark48.jsongen.generate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class GenerateModInfo {

    public static void genModInfo(String modId, String modName, String version, String gameVersion, String author, String url, String description, String credits, String path){

        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        PrintWriter item;
        try {

            item = new PrintWriter(fileDir + "\\mcmod.info", "UTF-8");
            item.println("[");
            item.println("{");
            item.println("\"modid\": \"" + modId + "\",");
            item.println("\"name\": \"" + modName + "\",");
            item.println("\"description\": \"" + description + "\",");
            item.println("\"version\": \"" + version + "\",");
            item.println("\"credits\": \"" + credits + "\",");
            item.println("\"logoFile\": \"\",");
            item.println("\"mcversion\": \"" + gameVersion + "\",");
            item.println("\"url\": \"" + url + "\",");
            item.println("\"updateUrl\": \"\",");
            item.println("\"authorList\": [ \"" + author + "\" ],");
            item.println("\"parent\": \"\",");
            item.println("\"screenshots\": [],");
            item.println("\"dependencies\": [");
            item.println("\"mod_MinecraftForge\"");
            item.println("]");
            item.println("}");
            item.println("]");
            item.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
