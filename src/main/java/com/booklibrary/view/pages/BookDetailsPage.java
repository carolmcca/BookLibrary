package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.OpenDeleteBookPageAction;
import com.booklibrary.controller.actions.OpenEditBookPageAction;
import com.booklibrary.controller.actions.OpenSearchBookPageAction;
import com.booklibrary.model.Book;
import com.booklibrary.model.Config;
import com.booklibrary.model.Place;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Set;

import static com.booklibrary.utils.Utils.scrollableRoot;

public class BookDetailsPage extends Page {
    private final Book book;
    private final Set<Book> books;
    private final Config config;


    public BookDetailsPage(Book book, Config config, Set<Book> books) {
        this.title = book.getTitle();
        this.config = config;
        this.book = book;
        this.books = books;
    }

    @Override
    public Node create(Stage stage) {
        BorderPane borderPane = new BorderPane();

        Text pageTitle = this.createTitle();

        HBox infoHBox = new HBox(createMessagesVBox(), createInfoVBox(book));
        infoHBox.setAlignment(Pos.CENTER);
        infoHBox.setSpacing(40);

        Button backButton = new OpenSearchBookPageAction(this.config, this.books).createButton(stage, "Voltar");
        Button editButton = new OpenEditBookPageAction(config, books, this.book).createButton(stage);
        Button deleteButton = new OpenDeleteBookPageAction(config, books, this.book).createButton(stage);

        HBox buttons = new HBox(backButton, editButton, deleteButton);

        buttons.setSpacing(30);
        buttons.setAlignment(Pos.CENTER);

        borderPane.setTop(pageTitle);
        borderPane.setCenter(infoHBox);
        borderPane.setBottom(buttons);

        BorderPane.setAlignment(pageTitle, Pos.CENTER);
        BorderPane.setAlignment(infoHBox, Pos.CENTER);
        BorderPane.setAlignment(buttons, Pos.CENTER);

        BorderPane.setMargin(pageTitle, new Insets(50));
        BorderPane.setMargin(buttons, new Insets(50));

        return scrollableRoot(borderPane);
    }

    private VBox createMessagesVBox() {
        VBox vBox = new VBox(
                this.createText("Título:"),
                this.createText("Autor(es):"),
                this.createText("Edição:"),
                this.createText("Ano de publicação:"),
                this.createText("Dono:"),
                this.createText("Morada:"),
                this.createText("Divisão:"),
                this.createText("Armário:"),
                this.createText("Prateleira:")
        );
        vBox.setSpacing(15);
        return vBox;
    }

    private VBox createInfoVBox(Book book) {
        Place place = book.getPlace();
        VBox vBox = new VBox(
                this.createText(book.getTitle()),
                this.createText(book.getAuthor()),
                this.createText(book.getEdition() == null ? "" : String.valueOf(book.getEdition())),
                this.createText(book.getYear() == null ? "" : String.valueOf(book.getYear())),
                this.createText(book.getOwner()),
                this.createText(place.getAddress()),
                this.createText(place.getRoom()),
                this.createText(place.getCabinet()),
                this.createText(place.getShelf())
        );
        vBox.setSpacing(15);
        return vBox;
    }

}
