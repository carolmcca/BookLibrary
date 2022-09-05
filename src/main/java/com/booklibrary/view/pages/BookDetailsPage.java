package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.OpenBookDetailsPageAction;
import com.booklibrary.controller.actions.OpenDeleteBookPageAction;
import com.booklibrary.controller.actions.OpenEditBookPageAction;
import com.booklibrary.controller.actions.OpenMainPageAction;
import com.booklibrary.model.Book;
import com.booklibrary.model.Place;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Set;

public class BookDetailsPage extends Page {
    private final Book book;
    private final Set<Book> books;


    public BookDetailsPage(Book book, Set<Book> books) {
        this.title = book.getTitle();
        this.book = book;
        this.books = books;
    }

    @Override
    public Scene create(Stage stage) {
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, Color.LIGHTGOLDENRODYELLOW);

        Text pageTitle = this.createTitle();

        HBox infoHBox = new HBox(createMessagesVBox(), createInfoVBox(book));
        infoHBox.setAlignment(Pos.CENTER);

        Button mainMenuButton = new OpenMainPageAction(this.books).createButton(stage);
        Button editButton = new OpenEditBookPageAction(books, this.book).createButton(stage);
        Button deleteButton = new OpenDeleteBookPageAction(this.book, this.books).createButton(stage);

        HBox buttons = new HBox(deleteButton, editButton, mainMenuButton);
        buttons.setSpacing(30);
        buttons.setAlignment(Pos.CENTER);

        borderPane.setTop(pageTitle);
        borderPane.setCenter(infoHBox);
        borderPane.setBottom(buttons);

        BorderPane.setAlignment(pageTitle, Pos.CENTER);
        BorderPane.setAlignment(infoHBox, Pos.CENTER);
        BorderPane.setAlignment(buttons, Pos.CENTER);

        return scene;
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
                this.createText(book.getEdition() == null ? "" : String.valueOf(book.getEdition())),
                this.createText(book.getYear() == null ? "" : String.valueOf(book.getYear())),
                this.createText(place.getAddress()),
                this.createText(place.getRoom()),
                this.createText(place.getCabinet()),
                this.createText(place.getShelf())
        );
        return vBox;
    }

}
