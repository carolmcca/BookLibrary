package com.booklibrary.controller;

import com.booklibrary.model.Book;
import com.booklibrary.model.Config;
import com.booklibrary.model.Database;
import com.booklibrary.model.Place;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

import static com.booklibrary.utils.Utils.*;

public class DatabaseManager {
    private static final String booksFilename = "library_books.txt";
    private static final String configFilename = "library_config.txt";
    private final Database database;

    public DatabaseManager(Database database) {
        this.database = database;
    }
    public DatabaseManager(Config config) {
        this.database = new Database(config);
    }


    private Place loadPlace(String place) {
        String[] attributes = place.split("\\|", -1);
        return new Place(attributes[0], attributes[1], attributes[2], attributes[3]);
    }
    public void loadBooks() {
        try {
            File file = new File(DatabaseManager.booksFilename);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split(";", -1);

                Place place = loadPlace(attributes[5]);
                String title = isNull(attributes[0]) ? null : attributes[0];
                String author = isNull(attributes[1]) ? null : attributes[1];
                Integer edition = isNull(attributes[2]) ? null : Integer.parseInt(attributes[2]);
                Integer year = isNull(attributes[3]) ? null : Integer.parseInt(attributes[3]);
                String owner = isNull(attributes[4]) ? null : attributes[4];
                Book book = new Book(title, author, edition, year, owner, place);

                this.database.getBooks().add(book);
            }
            myReader.close();
        } catch (FileNotFoundException e) {}
    }

    public void saveBooks() {
        this.saveBooks(this.database.getBooks());
    }
    public void saveBooks(Set<Book> books){
        StringBuilder stringBuilder = new StringBuilder();
        for (Book book : books) {
            stringBuilder.append(book.toString()).append("\n");
        }
        writeToFile(DatabaseManager.booksFilename, stringBuilder.toString(), true);
    }

    public void loadConfigs() {
        try {
            File file = new File(DatabaseManager.configFilename);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split("\\|", -1);

                String key = attributes[0];
                String value = attributes[1];
                if (key.equals("Library Owner")) {
                    this.database.getConfig().setLibraryOwner(value);
                }
                else if (key.equals("Library Address")) {
                    this.database.getConfig().setLibraryAddress(value);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {}
    }

    public void saveConfig() {
        String s = "Library Owner" + "|" + this.database.getConfig().getLibraryOwner() + "\n" +
                "Library Address" + "|" + this.database.getConfig().getLibraryAddress() + "\n";

        writeToFile(DatabaseManager.configFilename, s, true);
    }
}
