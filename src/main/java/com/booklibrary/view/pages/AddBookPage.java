package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.AddBookAction;
import com.booklibrary.controller.actions.CompositeAction;
import com.booklibrary.controller.actions.OpenBookAddedPageAction;
import com.booklibrary.controller.actions.OpenMainPageAction;
import com.booklibrary.model.Book;
import com.booklibrary.model.Config;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Set;

public class AddBookPage extends BookFormPage {

    private final Config config;

    public AddBookPage(Config config, Set<Book> books) {
        super(books);
        this.config = config;
        this.titleControlText = "";
        this.authorControlText = "";
        this.editionControlText = "";
        this.yearControlText = "";
        this.ownerControlText = config.getLibraryOwner();
        this.addressControlText = config.getLibraryAddress();
        this.roomControlText = "";
        this.cabinetControlText = "";
        this.shelfControlText = "";
    }

    @Override
    public Node create(Stage stage) {
        Node root = super.create(stage);

        CompositeAction compositeAction = new CompositeAction();
        compositeAction.add(new AddBookAction(books));
        compositeAction.add(new OpenBookAddedPageAction(this.config, this.books));
        Button addButton = compositeAction.createButton(stage, "Adicionar Livro");
        Button backButton = new OpenMainPageAction(config, this.books).createButton(stage, "Voltar");

        HBox buttons = new HBox(backButton, addButton);
        buttons.setSpacing(30);
        buttons.setAlignment(Pos.CENTER);

        BorderPane borderPane = (BorderPane) ((ScrollPane)root).getContent();
        borderPane.setBottom(buttons);

        BorderPane.setAlignment(buttons, Pos.CENTER);
        BorderPane.setMargin(buttons, new Insets(50));

        return root;
    }
}
