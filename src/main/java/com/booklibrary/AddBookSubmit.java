package com.booklibrary;

import com.booklibrary.Menu;
import com.booklibrary.model.Book;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Set;

public class AddBookSubmit extends Menu {
    private Set<Book> books;

    public AddBookSubmit(Set<Book> books) {
        this.books = books;
        this.title = "Adicionar Livro";

    }

    @Override
    public void execute(Stage stage) {
        this.addBook(stage);
    }

    private void addBook(Stage stage) {
        HBox hBox = (HBox) stage.getScene().getRoot().getChildrenUnmodifiable().get(1);
        VBox vBox = (VBox) hBox.getChildren().get(1);
        var inputs = vBox.getChildren();
        String aux;
        String bookTitle = ((TextField)inputs.get(0)).getText();
        String bookAuthor = ((TextField)inputs.get(1)).getText();
        aux = ((TextField)inputs.get(2)).getText();
        Integer bookEdition = aux.isBlank() ? null : Integer.parseInt(aux);
        aux = ((TextField)inputs.get(3)).getText();
        Integer bookYear = aux.isBlank() ? null : Integer.parseInt(aux);
        Book book = new Book(bookTitle, bookAuthor, bookEdition, bookYear, null);
        this.books.add(book);

    }

    @Override
    public Scene create(Stage stage) {
        return null;
    }
}
