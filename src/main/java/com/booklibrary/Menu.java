package com.booklibrary;

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

public class Menu {

    private Scene scene;

    private Scene sceneOp1, sceneOp2, sceneOp3, sceneOp4, sceneOp5;
    private Button button1, button2, button3, button4, button5;
    private int option;

    public int getOption() {
        return option;
    }

    public Menu(){
        AddBook addBook = new AddBook();
        Scene sceneOp1 = addBook.create();
    }

    private Button createButton(String text, int id){
        Button button = new Button(text);
        button.setTextFill(Color.LIGHTGOLDENRODYELLOW);
        button.setStyle("-fx-background-color: SandyBrown");
        button.setFont(Font.font("Arial Narrow", 15));
        return button;
    }

    public Scene create(Stage stage){

        Text text = new Text();
        text.setText("Bem-vindo à sua biblioteca pessoal\nSelecione uma ação");
        text.setFont(Font.font("Arial Narrow", 20));
        text.setFill(Color.SANDYBROWN);
        text.setTextAlignment(TextAlignment.CENTER);

        this.button1 = this.createButton("Adicionar Livro", 1);
        button1.setOnAction(e -> {stage.setScene(this.sceneOp1); stage.show();});
        this.button2 = this.createButton("Remover Livro", 2);
        this.button3 = this.createButton("Emprestar livro", 3);
        this.button4 = this.createButton("Alterar localização de um livro", 4);
        this.button5 = this.createButton("Alterar especificações de um livro", 5);

        VBox vBox = new VBox(text, button1, button2, button3, button4, button5);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(110));

        Group layout = new Group();
        layout.getChildren().add(vBox);

        this.scene = new Scene(layout, 500, 500, Color.LIGHTGOLDENRODYELLOW);
        return scene;

    }
}
