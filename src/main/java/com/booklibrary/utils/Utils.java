package com.booklibrary.utils;


import javafx.scene.Node;
import javafx.scene.Scene;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {

    public static boolean isNull(String s) {
        return s.equals("null");
    }

    public static void writeToFile(String filename, String text, boolean overwrite) {
        try {
            File file = new File(filename);
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter(filename, overwrite);
            myWriter.write(text);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static boolean containsIgnoreCase(String str, String searchStr) {
        if(str == null || searchStr == null) return false;

        final int length = searchStr.length();
        if (length == 0) return true;

        for (int i = str.length() - length; i >= 0; i--) {
            if (str.regionMatches(true, i, searchStr, 0, length))
                return true;
        }
        return false;
    }

    public static void centerNodeInWindow(Node node, Scene scene) {
        node.layoutXProperty().bind(scene.widthProperty().subtract(node.prefWidth(-1)).divide(2));
        //node.layoutYProperty().bind(scene.heightProperty().subtract(node.prefHeight(-1)).divide(2));
    }
}
