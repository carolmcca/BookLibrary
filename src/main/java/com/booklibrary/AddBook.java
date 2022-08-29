package com.booklibrary;

import com.booklibrary.model.Book;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class AddBook extends Menu {
    private final Set<Book> books;

    public AddBook(Set<Book> books) {
        this.title = "Adicionar Livro";
        this.books = books;
    }

    @Override
    public Scene create(Stage stage){
        Text pageTitle = this.createTitle();

        Text titleMsg = this.createText("Título:");
        TextField titleControl = new TextField();

        Text authorMsg = this.createText("Autor(es):");
        TextField authorControl = new TextField();

        Text editionMsg = this.createText("Edição:");
        TextField editionControl = new TextField();

        Text yearMsg = this.createText("Ano de publicação:");
        TextField yearControl = new TextField();

        Menu addBookSubmit = new AddBookSubmit(books);
        Button submitButton = addBookSubmit.createButton(stage);
        submitButton.relocate(350, 420);

        VBox msgs = new VBox(titleMsg, authorMsg, editionMsg, yearMsg);
        msgs.setAlignment(Pos.CENTER_LEFT);
        msgs.setSpacing(30);

        VBox controls = new VBox(titleControl, authorControl, editionControl, yearControl);
        controls.setAlignment(Pos.CENTER_LEFT);
        controls.setSpacing(30);

        HBox hBox = new HBox(msgs, controls);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(100));


        Group layout = new Group();
        layout.getChildren().addAll(pageTitle, hBox, submitButton);

        return new Scene(layout, 500, 500, Color.LIGHTGOLDENRODYELLOW);
    }
}
