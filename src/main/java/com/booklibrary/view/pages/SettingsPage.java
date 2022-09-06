package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.*;
import com.booklibrary.model.Database;
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

import static com.booklibrary.utils.Utils.scrollableRoot;

public class SettingsPage extends Page {
    private final Database database;

    public SettingsPage(Database database) {
        this.database = database;
        this.title = "Configurações pré-definidas";
    }

    @Override
    public Node create(Stage stage) {
        BorderPane borderPane = new BorderPane();

        Text pageTitle = this.createTitle();

        Text ownerMsg = this.createText("Dono da Biblioteca:");
        TextField ownerControl = new TextField(this.database.getConfig().getLibraryOwner());
        Text addressMsg = this.createText("Morada da Biblioteca");
        TextField addressControl = new TextField(this.database.getConfig().getLibraryAddress());

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
        compositeAction.add(new SaveConfigAction(this.database.getConfig()));
        compositeAction.add(new OpenMainPageAction(this.database));
        Button saveButton = compositeAction.createButton(stage, "Guardar");
        Button backButton = new OpenMainPageAction(this.database).createButton(stage, "Voltar");

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
