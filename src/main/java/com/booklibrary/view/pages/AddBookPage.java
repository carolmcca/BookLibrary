package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.AddBookAction;
import com.booklibrary.controller.actions.CompositeAction;
import com.booklibrary.controller.actions.OpenBookAddedPageAction;
import com.booklibrary.model.Book;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Set;

public class AddBookPage extends BookFormPage {

    public AddBookPage(Set<Book> books) {
        super(books);
        this.titleControlText = "";
        this.authorControlText = "";
        this.editionControlText = "";
        this.yearControlText = "";
        this.addressControlText = "";
        this.roomControlText = "";
        this.cabinetControlText = "";
        this.shelfControlText = "";
    }

    @Override
    public Scene create(Stage stage) {
        Scene scene = super.create(stage);

        CompositeAction compositeAction = new CompositeAction();
        compositeAction.add(new AddBookAction(books));
        compositeAction.add(new OpenBookAddedPageAction(books));
        Button submitButton = compositeAction.createButton(stage, "Adicionar Livro");

        BorderPane  borderPane = (BorderPane) scene.getRoot();
        borderPane.setBottom(submitButton);
        BorderPane.setAlignment(submitButton, Pos.CENTER);

        return scene;
    }
}
