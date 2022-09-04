package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.AddBookAction;
import com.booklibrary.controller.actions.CompositeAction;
import com.booklibrary.controller.actions.OpenBookAddedPage;
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

public class AddBookPage extends Page {
    private final Set<Book> books;

    public AddBookPage(Set<Book> books) {
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

        Text addressMsg = this.createText("Morada:");
        TextField addressControl = new TextField("Rua de Bustes");

        Text roomMsg = this.createText("Divisão:");
        TextField roomControl = new TextField();

        Text cabinetMsg = this.createText("Armário:");
        TextField cabinetControl = new TextField();

        Text shelfMsg = this.createText("Prateleira:");
        TextField shelfControl = new TextField();

        CompositeAction compositeAction = new CompositeAction();
        compositeAction.add(new AddBookAction(books));
        compositeAction.add(new OpenBookAddedPage(books));
        Button submitButton = compositeAction.createButton(stage, "Adicionar Livro");
        submitButton.relocate(350, 420);

        VBox msgs = new VBox(titleMsg, authorMsg, editionMsg, yearMsg, addressMsg, roomMsg, cabinetMsg, shelfMsg);
        msgs.setAlignment(Pos.CENTER_LEFT);
        msgs.setSpacing(25);

        VBox controls = new VBox(titleControl, authorControl, editionControl, yearControl, addressControl, roomControl, cabinetControl, shelfControl);
        controls.setAlignment(Pos.CENTER_LEFT);
        controls.setSpacing(20);

        HBox hBox = new HBox(msgs, controls);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(100));


        Group layout = new Group();
        layout.getChildren().addAll(pageTitle, hBox, submitButton);

        return new Scene(layout, 500, 500, Color.LIGHTGOLDENRODYELLOW);
    }
}
