package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.model.Place;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Set;

public class EditBookAction extends ButtonAction {
    private final Set<Book> books;
    private final Book book;

    public EditBookAction(Set<Book> books, Book book) {
        super();
        this.books = books;
        this.book = book;
    }

    private void editBook(Stage stage) {
        HBox hBox = (HBox) ((BorderPane)stage.getScene().getRoot()).getCenter();
        VBox vBox = (VBox) hBox.getChildren().get(1);
        var inputs = vBox.getChildren();

        String aux;
        String bookTitle = ((TextField)inputs.get(0)).getText();
        String bookAuthor = ((TextField)inputs.get(1)).getText();
        aux = ((TextField)inputs.get(2)).getText();
        Integer bookEdition = aux.isBlank() ? null : Integer.parseInt(aux);
        aux = ((TextField)inputs.get(3)).getText();
        Integer bookYear = aux.isBlank() ? null : Integer.parseInt(aux);
        String address = ((TextField)inputs.get(4)).getText();
        String room = ((TextField)inputs.get(5)).getText();
        String cabinet = ((TextField)inputs.get(6)).getText();
        String shelf = ((TextField)inputs.get(7)).getText();

        Place place = new Place(address, room, cabinet, shelf);
        this.book.setTitle(bookTitle);
        this.book.setAuthor(bookAuthor);
        this.book.setEdition(bookEdition);
        this.book.setYear(bookYear);
        this.book.setPlace(place);

    }

    @Override
    public void execute(Stage stage) {
        this.editBook(stage);
    }
}
