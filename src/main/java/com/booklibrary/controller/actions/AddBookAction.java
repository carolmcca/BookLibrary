package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.model.Place;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Set;

public class AddBookAction extends ButtonAction{
    private Set<Book> books;

    public AddBookAction(Set<Book> books) {
        this.buttonText = "Adicionar Livro";
        this.books = books;
    }

    private void addBook(Stage stage) {
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
        Book book = new Book(bookTitle, bookAuthor, bookEdition, bookYear, place);
        this.books.add(book);
    }

    @Override
    public void execute(Stage stage) {
        this.addBook(stage);
    }
}
