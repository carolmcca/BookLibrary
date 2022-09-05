package com.booklibrary.controller;

import com.booklibrary.model.Book;
import com.booklibrary.model.Place;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import static com.booklibrary.utils.Utils.isNull;
import static com.booklibrary.utils.Utils.writeToFile;

public class DatabaseManager {
    private static final String filename = "books.txt";
    private final Set<Book> books;

    public DatabaseManager() {
        this.books = new TreeSet<>();
    }

    private Place loadPlace(String place) {
        String[] attributes = place.split("\\|", -1);
        return new Place(attributes[0], attributes[1], attributes[2], attributes[3]);
    }
    public Set<Book> loadBooks() {
        try {
            File file = new File(DatabaseManager.filename);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split(";");

                Place place = loadPlace(attributes[4]);
                String title = isNull(attributes[0]) ? null : attributes[0];
                String author = isNull(attributes[1]) ? null : attributes[1];
                Integer edition = isNull(attributes[2]) ? null : Integer.parseInt(attributes[2]);
                Integer year = isNull(attributes[3]) ? null : Integer.parseInt(attributes[3]);
                Book book = new Book(title, author, edition, year, place);

                this.books.add(book);
            }
            myReader.close();
        } catch (FileNotFoundException e) {}
        return this.books;
    }

    public void saveBooks() {
        this.saveBooks(this.books);
    }

    public void saveBooks(Set<Book> books){
        StringBuilder stringBuilder = new StringBuilder();
        for (Book book : books) {
            stringBuilder.append(book.toString()).append("\n");
        }
        for (var book : books) {
            System.out.println(book);
        }
        writeToFile(DatabaseManager.filename, stringBuilder.toString(), false);
    }
}