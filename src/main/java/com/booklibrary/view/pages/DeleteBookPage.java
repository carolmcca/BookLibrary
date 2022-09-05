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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Set;

import static com.booklibrary.utils.Utils.setScene;

public class DeleteBookPage extends Page {
    private Book book;
    private Set<Book> books;

    public DeleteBookPage(Book book, Set<Book> books){
        this.book = book;
        this.books = books;
        this.title = "Eliminar livro";
    }

    @Override
    public Scene create(Stage stage) {
        BorderPane borderPane = new BorderPane();
        Scene scene = setScene(borderPane);


        Text title = this.createTitle();

        Text text = this.createText("Tem a certeza que quer eliminar este livro?");


        CompositeAction compositeAction = new CompositeAction();
        compositeAction.add(new DeleteBookAction(this.book, this.books));
        compositeAction.add(new OpenSearchBookPageAction(books));
        Button yesButton = compositeAction.createButton(stage, "Sim");
        Button noButton = new OpenBookDetailsPageAction(book, books).createButton(stage, "Não");

        HBox buttons = new HBox(yesButton, noButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(30);

        borderPane.setTop(title);
        borderPane.setCenter(text);
        borderPane.setBottom(buttons);

        BorderPane.setAlignment(title, Pos.CENTER);
        BorderPane.setAlignment(text, Pos.CENTER);
        BorderPane.setAlignment(buttons, Pos.CENTER);
        BorderPane.setMargin(title, new Insets(50));
        BorderPane.setMargin(buttons, new Insets(50));

        return scene;
    }
}
