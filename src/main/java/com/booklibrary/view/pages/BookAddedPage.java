package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.ButtonAction;
import com.booklibrary.controller.actions.OpenAddBookPageAction;
import com.booklibrary.controller.actions.OpenMainPageAction;
import com.booklibrary.model.Book;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Set;

public class BookAddedPage extends Page {
    private Set<Book> books;

    public BookAddedPage(Set<Book> books) {
        this.title = "Livro Adicionado";
        this.books = books;
    }

    @Override
    public Scene create(Stage stage) {
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, Color.LIGHTGOLDENRODYELLOW);

        Text pageTitle = this.createTitle();

        Text text = this.createText("O seu livro foi adicionado com sucesso!");

        ButtonAction openAddBookPageAction = new OpenAddBookPageAction(this.books);
        ButtonAction openMainPageAction = new OpenMainPageAction(this.books);
        Button button1 = openAddBookPageAction.createButton(stage, "Adicionar novo livro");
        Button button2 = openMainPageAction.createButton(stage);

        HBox buttonBox = new HBox(button1, button2);
        buttonBox.setSpacing(30);

        borderPane.setTop(pageTitle);
        borderPane.setCenter(text);
        borderPane.setBottom(buttonBox);

        BorderPane.setAlignment(pageTitle, Pos.CENTER);
        BorderPane.setAlignment(text, Pos.CENTER);
        BorderPane.setAlignment(buttonBox, Pos.CENTER);
        return scene;
    }
}
