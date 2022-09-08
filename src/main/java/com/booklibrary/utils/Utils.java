package com.booklibrary.utils;


import com.booklibrary.Application;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

import java.io.*;

public class Utils {

    public static boolean isNull(String s) {
        return s.isEmpty();
    }

    public static void writeToFile(String filename, String text, boolean overwrite) {
        int li = filename.lastIndexOf("/");
        File directory = new File(filename.substring(0, li));
        if (!directory.exists()){
            directory.mkdir();
        }
        try {
            File file = new File(filename);
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter(filename, !overwrite);
            myWriter.write(text);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static Integer toInteger(String s) {
        try {
            if (s.isBlank()) return null;
            else return Integer.parseInt(s);
        } catch (Exception e) {
            return null;
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

    public static Node scrollableRoot(Node root) {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(root);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        return scrollPane;
    }

    // TODO try to fix
    public static String readFromResource(String filename) throws IOException {
        InputStreamReader isReader = new InputStreamReader(Utils.class.getResourceAsStream(filename));
        BufferedReader br = new BufferedReader(isReader);
        StringBuilder everything = new StringBuilder();
        String line;
        while( (line = br.readLine()) != null) {
            everything.append(line);
        }
        return everything.toString();
    }
    // TODO try  to fix
    public static void writeToResource(String filename, String text, boolean overwrite) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(Application.class.getResource(filename).getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.write(text);
        writer.close();
    }
}
