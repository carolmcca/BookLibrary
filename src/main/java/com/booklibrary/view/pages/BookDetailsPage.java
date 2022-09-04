package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.OpenMainPageAction;
import com.booklibrary.model.Book;
import com.booklibrary.model.Place;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Set;

public class BookDetailsPage extends Page {
    private final Book book;
    private Set<Book> TODO_Remove;


    public BookDetailsPage(Book book, Set<Book> TODO_Remove) {
        this.title = book.getTitle();
        this.book = book;
        this.TODO_Remove = TODO_Remove;
    }

    @Override
    public Scene create(Stage stage) {
        Text pageTitle = this.createTitle();
        Button TODO_mainMenu = new OpenMainPageAction(this.TODO_Remove).createButton(stage);
        HBox infoHBox = new HBox(createMessagesVBox(), createInfoVBox(book));
        VBox vBox = new VBox(infoHBox, TODO_mainMenu);

        Group layout = new Group();
        layout.getChildren().addAll(pageTitle, vBox);

        return new Scene(layout, 500, 500, Color.LIGHTGOLDENRODYELLOW);
    }

    private VBox createMessagesVBox() {
        VBox vBox = new VBox(
                this.createText("Título:"),
                this.createText("Autor(es):"),
                this.createText("Edição:"),
                this.createText("Ano:"),
                this.createText("Morada:"),
                this.createText("Divisão:"),
                this.createText("Armário:"),
                this.createText("Prateleira:")
        );
        return vBox;
    }

    private VBox createInfoVBox(Book book) {
        Place place = book.getPlace();
        VBox vBox = new VBox(
                this.createText(book.getTitle()),
                this.createText(book.getAuthor()),
                this.createText(String.valueOf(book.getEdition())),
                this.createText(String.valueOf(book.getYear())),
                this.createText(place.getAddress()),
                this.createText(place.getRoom()),
                this.createText(place.getCabinet()),
                this.createText(place.getShelf())
        );
        return vBox;
    }

}
