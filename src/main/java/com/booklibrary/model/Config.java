package com.booklibrary.model;

import com.booklibrary.controller.DatabaseManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.booklibrary.utils.Utils.isNull;
import static com.booklibrary.utils.Utils.writeToFile;

public class Config {
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
}
