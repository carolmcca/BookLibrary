package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.*;
import com.booklibrary.model.Book;
import com.booklibrary.model.Config;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Set;

import static com.booklibrary.utils.Utils.scrollableRoot;

public class SettingsPage extends Page {
    private final Config config;
    private final Set<Book> books;

    public SettingsPage(Config config, Set<Book> books) {
        this.config = config;
        this.books = books;
        this.title = "Configurações pré-definidas";
    }

    @Override
    public Node create(Stage stage) {
        BorderPane borderPane = new BorderPane();

        Text pageTitle = this.createTitle();

        Text ownerMsg = this.createText("Dono da Biblioteca:");
        TextField ownerControl = new TextField(this.config.getLibraryOwner());
        Text addressMsg = this.createText("Morada da Biblioteca");
        TextField addressControl = new TextField(this.config.getLibraryAddress());

        VBox msgs = new VBox(ownerMsg, addressMsg);
        msgs.setAlignment(Pos.CENTER_LEFT);
        msgs.setSpacing(20);

        VBox controls = new VBox(ownerControl, addressControl);
        controls.setAlignment(Pos.CENTER_LEFT);
        controls.setSpacing(20);

        HBox hBox = new HBox(msgs, controls);
        hBox.setSpacing(30);
        hBox.setAlignment(Pos.CENTER);

        CompositeAction compositeAction = new CompositeAction();
        compositeAction.add(new SaveConfigAction(this.config));
        compositeAction.add(new OpenMainPageAction(config, this.books));
        Button saveButton = compositeAction.createButton(stage, "Guardar");
        Button backButton = new OpenMainPageAction(config, this.books).createButton(stage, "Voltar");

        HBox buttons = new HBox(backButton, saveButton);
        buttons.setSpacing(30);
        buttons.setAlignment(Pos.CENTER);

        borderPane.setTop(pageTitle);
        borderPane.setCenter(hBox);
        borderPane.setBottom(buttons);

        BorderPane.setMargin(pageTitle, new Insets(50));
        BorderPane.setMargin(buttons, new Insets(50));

        return scrollableRoot(borderPane);
    }
}
