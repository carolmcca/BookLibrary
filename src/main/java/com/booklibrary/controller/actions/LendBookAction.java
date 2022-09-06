package com.booklibrary.controller.actions;


import com.booklibrary.model.Book;
import com.booklibrary.model.Database;
import com.booklibrary.view.pages.SearchBookPage;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LendBookAction extends ButtonAction {
    private Book book;
    public LendBookAction(Database database, Book book) {
        this.book = book;
        this.buttonText = "Emprestar Livro";
        this.page = new SearchBookPage(database);
    }
    private void lendBook(Stage stage){
        VBox center = (VBox) ((BorderPane) ((ScrollPane) stage.getScene().getRoot()).getContent()).getCenter();
        TextField textField = (TextField) ((HBox) center.getChildren().get(1)).getChildren().get(1);
        this.book.setLend(textField.getText());
    }

    @Override
    public void execute(Stage stage) {
        this.lendBook(stage);
    }
}
