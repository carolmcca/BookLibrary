package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.*;
import com.booklibrary.model.Book;
import com.booklibrary.model.Database;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.booklibrary.utils.Utils.scrollableRoot;

public class LendBookPage extends Page {
    private Book book;
    private Database database;
    public LendBookPage(Database database, Book book) {
        this.database = database;
        this.title = "Emprestar livro";
        this.book = book;
    }

    @Override
    public Node create(Stage stage) {
        Text pageTitle = this.createTitle();

        Text bookTitle = this.createText(this.book.getTitle());
        Text nameText = this.createText("Emprestar a:");
        TextField nameField = new TextField();

        CompositeAction compositeAction = new CompositeAction();
        compositeAction.add(new LendBookAction(this.database, this.book));
        compositeAction.add(new OpenSearchBookPageAction(this.database));
        Button lendButton = compositeAction.createButton(stage, "Emprestar Livro");

        BorderPane borderPane = new BorderPane();

        HBox field = new HBox(nameText, nameField);
        field.setSpacing(30);
        field.setAlignment(Pos.CENTER);
        VBox center = new VBox(bookTitle, field);
        center.setSpacing(40);
        center.setAlignment(Pos.CENTER);

        borderPane.setTop(pageTitle);
        borderPane.setCenter(center);
        borderPane.setBottom(lendButton);

        BorderPane.setAlignment(pageTitle, Pos.CENTER);
        BorderPane.setMargin(pageTitle, new Insets(50));
        BorderPane.setAlignment(center, Pos.CENTER);
        BorderPane.setAlignment(lendButton, Pos.CENTER);
        BorderPane.setMargin(lendButton, new Insets(50));


        return scrollableRoot(borderPane);
    }
}
