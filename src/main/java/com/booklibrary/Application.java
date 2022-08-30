package com.booklibrary;

import com.booklibrary.model.Book;
import com.booklibrary.model.Place;
import com.booklibrary.pages.MainPage;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Application {
    private static final String filename = "books.txt";
    private final Set<Book> books;

    public Application() {
        this.books = new TreeSet<>();
    }

    public void init(Stage stage) {
        stage.setTitle("Biblioteca Pessoal");
        this.loadBooks();
        MainPage mainMenu = new MainPage(books);
        mainMenu.execute(stage);
    }
    public void end() {
        saveBooks();
    }

    private Place loadPlace(String place) {
        String[] attributes = place.split("\\|", -1);
        return new Place(attributes[0], attributes[1], attributes[2], attributes[3]);
    }
    private void loadBooks() {
        try {
            File file = new File(Application.filename);
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
    }

    private void saveBooks(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Book book : books) {
            stringBuilder.append(book.toString()).append("\n");
        }
        for (var book : books) {
            System.out.println(book);
        }
        this.writeToFile(Application.filename, stringBuilder.toString(), false);
    }

    private void writeToFile(String filename, String text, boolean overwrite) {
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

    private boolean isNull(String s) {
        return s.equals("null");
    }

}