package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.*;
import com.booklibrary.model.Book;
import com.booklibrary.model.Database;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.booklibrary.utils.Utils.scrollableRoot;

public class DeleteBookPage extends Page {
    private final Database database;
    private final Book book;

    public DeleteBookPage(Database database, Book book){
        this.database = database;
        this.book = book;
        this.title = "Eliminar livro";
    }

    @Override
    public Node create(Stage stage) {
        BorderPane borderPane = new BorderPane();

        Text title = this.createTitle();

        Text text = this.createText("Tem a certeza que quer eliminar este livro?");

        CompositeAction compositeAction = new CompositeAction();
        compositeAction.add(new DeleteBookAction(this.database.getBooks(), this.book));
        compositeAction.add(new OpenSearchBookPageAction(this.database));
        Button yesButton = compositeAction.createButton(stage, "Sim");
        Button noButton = new OpenBookDetailsPageAction(this.database, this.book).createButton(stage, "Não");

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

        return scrollableRoot(borderPane);
    }
}
