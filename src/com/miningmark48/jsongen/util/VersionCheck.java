package com.miningmark48.jsongen.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.miningmark48.jsongen.reference.Reference;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class VersionCheck implements Runnable{

    private static boolean isLatestVersion = false;
    private static String latestVersion = "";

    private static String version = Reference.version;

    @Override
    public void run() {
        try {

            URL url = new URL("https://raw.githubusercontent.com/MiningMark48/Minecraft-JSON-Generator/master/src/com/miningmark48/jsongen/versioninfo.json");
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject rootObj = root.getAsJsonObject();

            latestVersion = rootObj.get("version").getAsString();
            isLatestVersion = version.equals(latestVersion);

            System.out.println(latestVersion);
            System.out.println(isLatestVersion);

        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean isLatestVersion(){
        return isLatestVersion;
    }

    public String getLatestVersion(){
        return latestVersion;
    }

}
