package com.booklibrary;

import com.booklibrary.controller.DatabaseManager;
import com.booklibrary.controller.actions.OpenMainPageAction;
import com.booklibrary.model.Book;
import com.booklibrary.model.Config;
import com.booklibrary.model.Database;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Set;

public class Application {
    private final Database database;

    public Application() {
        this.database = new Database();
    }

    public void init(Stage stage) {
        stage.setMaximized(true);
        stage.setTitle("Biblioteca Pessoal");
        stage.setScene(new Scene(new Group(), Color.LIGHTGOLDENRODYELLOW)); // Group could be null if javafx let it

        DatabaseManager databaseManager = new DatabaseManager(this.database);
        databaseManager.loadConfigs();
        databaseManager.loadBooks();
        new OpenMainPageAction(database).execute(stage);
    }
    public void end() {
        DatabaseManager databaseManager = new DatabaseManager(this.database);
        databaseManager.saveBooks();
    }
}