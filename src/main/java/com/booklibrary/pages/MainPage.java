package com.booklibrary.pages;

import com.booklibrary.model.Book;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class MainPage extends Page {
    private final List<Page> options;
    private final List<Button> buttons;

    public MainPage(Set<Book> books){
        this.title = "Bem-vindo à sua biblioteca pessoal\nSelecione uma ação";
        this.options = Arrays.asList(new AddBookPage(books), new RemoveBookPage());
        this.buttons = new ArrayList<>();
    }

    @Override
    public Scene create(Stage stage) {
        Text text = new Text();
        text.setText(this.title);
        text.setFont(Font.font("Arial Narrow", 20));
        text.setFill(Color.SANDYBROWN);
        text.setTextAlignment(TextAlignment.CENTER);

        for (Page page : this.options) {
            this.buttons.add(page.createButton(stage, page.getTitle()));
        }
        // this.button4 = this.createButton("Alterar localização de um livro");
        // this.button5 = this.createButton("Alterar especificações de um livro");

        VBox vBox = new VBox(text);
        vBox.getChildren().addAll(this.buttons);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(110));

        Group layout = new Group();
        layout.getChildren().add(vBox);

        this.scene = new Scene(layout, 500, 500, Color.LIGHTGOLDENRODYELLOW);
        return scene;
    }
}
