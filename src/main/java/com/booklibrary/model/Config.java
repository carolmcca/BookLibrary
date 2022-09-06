package com.booklibrary.model;

import com.booklibrary.controller.DatabaseManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.booklibrary.utils.Utils.isNull;
import static com.booklibrary.utils.Utils.writeToFile;

public class Config {
    private static final String filename = "library_config.txt";
    private String libraryOwner;
    private String libraryAddress;

    public Config() {
        this.libraryOwner = "";
        this.libraryAddress = "";
    }
    public Config(String libraryOwner, String libraryAddress) {
        this.libraryOwner = libraryOwner;
        this.libraryAddress = libraryAddress;
    }
    public String getLibraryOwner() {
        return libraryOwner;
    }
    public String getLibraryAddress() {
        return libraryAddress;
    }
    public void setLibraryOwner(String libraryOwner) {
        this.libraryOwner = libraryOwner;
    }
    public void setLibraryAddress(String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }

    public void loadConfigs() {
        try {
            File file = new File(Config.filename);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split("\\|", -1);

                String key = attributes[0];
                String value = attributes[1];
                if (key.equals("Library Owner")) {
                    this.libraryOwner = value;
                }
                else if (key.equals("Library Address")) {
                    this.libraryAddress = value;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {}
    }

    public void saveConfigs() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Library Owner").append("|").append(this.libraryOwner).append("\n");
        stringBuilder.append("Library Address").append("|").append(this.libraryAddress).append("\n");

        writeToFile(Config.filename, stringBuilder.toString(), true);
    }
}
