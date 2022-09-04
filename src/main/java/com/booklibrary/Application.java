package com.booklibrary;

import com.booklibrary.controller.DatabaseManager;
import com.booklibrary.controller.actions.OpenMainPageAction;
import com.booklibrary.model.Book;
import javafx.stage.Stage;

import java.util.Set;

public class Application {
    private DatabaseManager databaseManager;

    public Application() {
        this.databaseManager = new DatabaseManager();
    }

    public void init(Stage stage) {
        stage.setTitle("Biblioteca Pessoal");
        Set<Book> books = databaseManager.loadBooks();
        new OpenMainPageAction(books).execute(stage);
    }
    public void end() {
        databaseManager.saveBooks();
    }
}