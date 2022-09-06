package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.ButtonAction;
import com.booklibrary.controller.actions.OpenAddBookPageAction;
import com.booklibrary.controller.actions.OpenMainPageAction;
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

public class BookAddedPage extends Page {
    private final Database database;

    public BookAddedPage(Database database) {
        this.database = database;
        this.title = "Livro Adicionado";
    }

    @Override
    public Node create(Stage stage) {
        BorderPane borderPane = new BorderPane();

        Text pageTitle = this.createTitle();

        Text text = this.createText("O seu livro foi adicionado com sucesso!");

        ButtonAction openAddBookPageAction = new OpenAddBookPageAction(this.database);
        ButtonAction openMainPageAction = new OpenMainPageAction(this.database);
        Button button1 = openAddBookPageAction.createButton(stage, "Adicionar novo livro");
        Button button2 = openMainPageAction.createButton(stage);

        HBox buttonBox = new HBox(button1, button2);
        buttonBox.setSpacing(30);
        buttonBox.setAlignment(Pos.CENTER);

        borderPane.setTop(pageTitle);
        borderPane.setCenter(text);
        borderPane.setBottom(buttonBox);

        BorderPane.setAlignment(pageTitle, Pos.CENTER);
        BorderPane.setAlignment(text, Pos.CENTER);
        BorderPane.setAlignment(buttonBox, Pos.CENTER);

        BorderPane.setMargin(pageTitle, new Insets(50));
        BorderPane.setMargin(buttonBox, new Insets(50));

        return scrollableRoot(borderPane);
    }
}
