package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.*;
import com.booklibrary.model.Book;
import com.booklibrary.model.Database;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.booklibrary.utils.Utils.scrollableRoot;

public class BookDetailsPage extends Page {
    private final Database database;
    private final Book book;

    public BookDetailsPage(Database database, Book book) {
        this.database = database;
        this.book = book;
        this.title = book.getTitle();
    }

    @Override
    public Node create(Stage stage) {
        BorderPane borderPane = new BorderPane();

        Text pageTitle = this.createTitle();

        HBox infoHBox = new HBox(createBookInfoHBox(), createLocalInfoHBox());
        infoHBox.setAlignment(Pos.CENTER);
        infoHBox.setSpacing(100);

        Button backButton = new OpenSearchBookPageAction(this.database).createButton(stage, "Voltar");
        Button editButton = new OpenEditBookPageAction(this.database, this.book).createButton(stage);
        Button deleteButton = new OpenDeleteBookPageAction(this.database, this.book).createButton(stage);
        Button lendButton = new OpenLendBookPageAction(this.database, this.book).createButton(stage);
        Button returnButton = new OpenReturnBookPageAction(this.database, this.book).createButton(stage);

        HBox buttons = new HBox(backButton, editButton, deleteButton, lendButton, returnButton);

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

    private HBox createBookInfoHBox() {
        List<String> msgs = Arrays.asList(
                "Título:",
                "Autor(es):",
                "Edição:",
                "Ano de publicação:"
        );
        List<String> infos = Arrays.asList(
                this.book.getTitle(),
                this.book.getAuthor(),
                this.book.getEdition() == null ? "" : String.valueOf(book.getEdition()),
                book.getYear() == null ? "" : String.valueOf(book.getYear())
        );

        VBox msgsVBox = this.createVBox(msgs, true, 15);
        VBox infosVBox = this.createVBox(infos, false, 15);

        HBox bookInfo = new HBox(msgsVBox, infosVBox);
        bookInfo.setSpacing(20);

        return bookInfo;
    }

    private HBox createLocalInfoHBox() {
        Place place = this.book.getPlace();

        List<String> msgs = Arrays.asList(
                "Dono:",
                "Morada:",
                "Divisão:",
                "Armário:",
                "Prateleira:",
                "Emprestado a:"
        );
        List<String> infos = Arrays.asList(
                this.book.getOwner(),
                place.getAddress(),
                place.getRoom(),
                place.getCabinet(),
                place.getShelf(),
                this.book.getLend() == null ? "Ninguém" : this.book.getLend()
        );

        VBox msgsVBox = this.createVBox(msgs, true, 15);
        VBox infosVBox = this.createVBox(infos, false, 15);

        HBox bookInfo = new HBox(msgsVBox, infosVBox);
        bookInfo.setSpacing(20);

        return bookInfo;
    }

    private VBox createVBox(List<String> texts, boolean bold, int spacing) {
        List<Text> textsText = new ArrayList<>();
        for (String text : texts) {
            textsText.add(this.createText(text, bold));
        }

        VBox vBox = new VBox();
        vBox.getChildren().addAll(textsText);
        vBox.setSpacing(spacing);
        vBox.setAlignment(Pos.CENTER_LEFT);

        return vBox;
    }
}
