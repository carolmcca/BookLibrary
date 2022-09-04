package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.ButtonAction;
import com.booklibrary.controller.actions.OpenAddBookPageAction;
import com.booklibrary.controller.actions.OpenSearchBookPageAction;
import com.booklibrary.model.Book;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class MainPage extends Page {
    private final List<ButtonAction> actions;
    private final List<Button> buttons;

    public MainPage(Set<Book> books){
        this.title = "Bem-vindo à sua biblioteca pessoal\nSelecione uma ação";
        this.actions = Arrays.asList(new OpenAddBookPageAction(books), new OpenSearchBookPageAction(books));
        this.buttons = new ArrayList<>();
    }

    @Override
    public Scene create(Stage stage) {
        Text title = this.createTitle();

        for (ButtonAction action : this.actions) {
            this.buttons.add(action.createButton(stage));
        }
        // this.button4 = this.createButton("Alterar localização de um livro");
        // this.button5 = this.createButton("Alterar especificações de um livro");

        VBox vBox = new VBox(title);
        vBox.getChildren().addAll(this.buttons);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(110));

        Group layout = new Group();
        layout.getChildren().add(vBox);

        return new Scene(layout, 500, 500, Color.LIGHTGOLDENRODYELLOW);
    }
}
