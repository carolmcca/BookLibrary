package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.ButtonAction;
import com.booklibrary.controller.actions.OpenAddBookPageAction;
import com.booklibrary.controller.actions.OpenSearchBookPageAction;
import com.booklibrary.model.Book;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.booklibrary.utils.Utils.scrollableRoot;

public class MainPage extends Page {
    private final List<ButtonAction> actions;
    private final List<Button> buttons;

    public MainPage(Set<Book> books){
        this.title = "Bem-vindo à sua biblioteca pessoal";
        this.actions = Arrays.asList(new OpenAddBookPageAction(books), new OpenSearchBookPageAction(books));
        this.buttons = new ArrayList<>();
    }

    @Override
    public Node create(Stage stage) {
        BorderPane borderPane = new BorderPane();

        Text title = this.createTitle();

        for (ButtonAction action : this.actions) {
            this.buttons.add(action.createButton(stage));
        }
        // this.button4 = this.createButton("Alterar localização de um livro");
        // this.button5 = this.createButton("Alterar especificações de um livro");

        VBox vBox = new VBox();
        vBox.getChildren().addAll(this.buttons);
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);

        borderPane.setTop(title);
        borderPane.setCenter(vBox);
        BorderPane.setAlignment(title, Pos.CENTER);
        BorderPane.setAlignment(vBox, Pos.CENTER);
        BorderPane.setMargin(title, new Insets(50));

        return scrollableRoot(borderPane);
    }
}
