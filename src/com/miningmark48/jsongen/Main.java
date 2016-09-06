package com.miningmark48.jsongen;

import com.miningmark48.jsongen.gui.MainWindow;
import com.miningmark48.jsongen.util.VersionCheck;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {

    // Version checking instance
    public static VersionCheck versionCheck;
    public static boolean haveWarnedVersionOutOfDate = false;

    public static void main(String[] args){

        versionCheck = new VersionCheck();
        Thread versionCheckThread = new Thread(versionCheck, "Version Check");
        versionCheckThread.start();

        MainWindow mainWindow = new MainWindow();
        mainWindow.setSize(800, 400);
        mainWindow.setVisible(true);
        mainWindow.setLocationRelativeTo(null);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        checkForUpdates();

    }

    public static void checkForUpdates(){

        if(!Main.haveWarnedVersionOutOfDate) {
            if (!versionCheck.isLatestVersion()) {

                JOptionPane opt = new JOptionPane();

                int result = opt.showConfirmDialog(null, "There is an update available, download now?", "Updates Available", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.YES_OPTION) {
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().browse(new URI("http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-tools/2733203-minecraft-json-generator"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }

}

