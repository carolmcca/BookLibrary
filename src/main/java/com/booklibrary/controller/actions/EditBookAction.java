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

public class EditBookAction extends ButtonAction {
    private final Set<Book> books;
    private final Book book;

    public EditBookAction(Set<Book> books, Book book) {
        this.books = books;
        this.book = book;
    }

    private void editBook(Stage stage) {
        HBox hBox = (HBox) ((BorderPane)((ScrollPane)stage.getScene().getRoot()).getContent()).getCenter();

        var inputsInfo = ((VBox)((HBox) hBox.getChildren().get(0)).getChildren().get(1)).getChildren();
        var inputsLocal = ((VBox)((HBox) hBox.getChildren().get(1)).getChildren().get(1)).getChildren();

        String bookTitle = ((TextField)inputsInfo.get(0)).getText();
        String bookAuthor = ((TextField)inputsInfo.get(1)).getText();
        Integer bookEdition = toInteger(((TextField)inputsInfo.get(2)).getText());
        Integer bookYear = toInteger(((TextField)inputsInfo.get(3)).getText());

        String bookOwner = ((TextField)inputsLocal.get(0)).getText();
        String address = ((TextField)inputsLocal.get(1)).getText();
        String room = ((TextField)inputsLocal.get(2)).getText();
        String cabinet = ((TextField)inputsLocal.get(3)).getText();
        String shelf = ((TextField)inputsLocal.get(4)).getText();

        Place place = new Place(address, room, cabinet, shelf);
        this.book.setTitle(bookTitle);
        this.book.setAuthor(bookAuthor);
        this.book.setEdition(bookEdition);
        this.book.setYear(bookYear);
        this.book.setOwner(bookOwner);
        this.book.setPlace(place);
    }

    @Override
    public void execute(Stage stage) {
        this.editBook(stage);
    }
}
