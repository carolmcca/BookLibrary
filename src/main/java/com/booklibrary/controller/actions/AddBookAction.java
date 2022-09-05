package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.model.Place;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Set;

import static com.booklibrary.utils.Utils.toInteger;

public class AddBookAction extends ButtonAction{
    private final Set<Book> books;

    public AddBookAction(Set<Book> books) {
        this.buttonText = "Adicionar Livro";
        this.books = books;
    }

    private void addBook(Stage stage) {
        HBox hBox = (HBox) ((BorderPane)((ScrollPane)stage.getScene().getRoot()).getContent()).getCenter();
        VBox vBox = (VBox) hBox.getChildren().get(1);
        var inputs = vBox.getChildren();

        String bookTitle = ((TextField)inputs.get(0)).getText();
        String bookAuthor = ((TextField)inputs.get(1)).getText();
        Integer bookEdition = toInteger(((TextField)inputs.get(2)).getText());
        Integer bookYear = toInteger(((TextField)inputs.get(3)).getText());
        String bookOwner = ((TextField)inputs.get(4)).getText();
        String address = ((TextField)inputs.get(5)).getText();
        String room = ((TextField)inputs.get(6)).getText();
        String cabinet = ((TextField)inputs.get(7)).getText();
        String shelf = ((TextField)inputs.get(8)).getText();

        Place place = new Place(address, room, cabinet, shelf);
        Book book = new Book(bookTitle, bookAuthor, bookEdition, bookYear, bookOwner, place);
        this.books.add(book);
    }

    @Override
    public void execute(Stage stage) {
        this.addBook(stage);
    }
}
