package com.booklibrary;

import com.booklibrary.controller.DatabaseManager;
import com.booklibrary.controller.actions.OpenMainPageAction;
import com.booklibrary.model.Book;
import com.booklibrary.model.Config;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Set;

public class Application {
    private final DatabaseManager databaseManager;
    private final Config config;

    public Application() {
        this.databaseManager = new DatabaseManager();
        this.config = new Config();
    }

    public void init(Stage stage) {
        stage.setMaximized(true);
        stage.setTitle("Biblioteca Pessoal");
        stage.setScene(new Scene(new Group(), Color.LIGHTGOLDENRODYELLOW)); // Group could be null if javafx let it

        config.loadConfigs();
        Set<Book> books = databaseManager.loadBooks();
        new OpenMainPageAction(config, books).execute(stage);
    }
    public void end() {
        databaseManager.saveBooks();
    }
}