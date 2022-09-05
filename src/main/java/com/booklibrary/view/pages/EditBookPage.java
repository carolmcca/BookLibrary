package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.*;
import com.booklibrary.model.Book;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Set;

public class EditBookPage extends BookFormPage {
    private final Book book;

    public EditBookPage(Set<Book> books, Book book) {
        super(books);
        this.book = book;
        this.titleControlText = book.getTitle();
        this.authorControlText = book.getAuthor();
        this.editionControlText = book.getEdition() == null ? "" : String.valueOf(book.getEdition());
        this.yearControlText = book.getYear() == null ? "" : String.valueOf(book.getYear());
        this.addressControlText = book.getPlace().getAddress();
        this.roomControlText = book.getPlace().getRoom();
        this.cabinetControlText = book.getPlace().getCabinet();
        this.shelfControlText = book.getPlace().getShelf();
    }

    @Override
    public Scene create(Stage stage) {
        Scene scene = super.create(stage);

        CompositeAction compositeAction = new CompositeAction();
        compositeAction.add(new EditBookAction(books, book));
        compositeAction.add(new OpenSearchBookPageAction(books));
        Button editButton = compositeAction.createButton(stage, "Editar Livro");
        Button backButton = new OpenBookDetailsPageAction(this.book, this.books).createButton(stage, "Voltar");

        HBox buttons = new HBox(backButton, editButton);
        buttons.setSpacing(30);
        buttons.setAlignment(Pos.CENTER);


        BorderPane borderPane = (BorderPane) ((ScrollPane)scene.getRoot()).getContent();
        borderPane.setBottom(buttons);

        BorderPane.setAlignment(buttons, Pos.CENTER);
        BorderPane.setMargin(buttons, new Insets(50));

        return scene;
    }
}
