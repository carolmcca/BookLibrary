package com.booklibrary;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    //private Button button;

    public static void main(String[] args) {
        launch();
    }

    public static void drawOption1() {

    }

    @Override
    public void start(Stage stage) throws Exception {

        Option1Drawer option1Drawer = new Option1Drawer();
        Scene option1Scene = option1Drawer.getScene();
        Text text = new Text();
        text.setText("Bem-vindo à sua biblioteca pessoal\nSelecione uma ação");
        text.setFont(Font.font("Arial Narrow", 20));
        text.setFill(Color.SANDYBROWN);
        text.setTextAlignment(TextAlignment.CENTER);
        /*
        button = new Button();
        button.setText("Click me");
        button.setLayoutX(120);
        button.setLayoutY(110);*/


        Button button1 = new Button("Adicionar livro");
        button1.setTextFill(Color.LIGHTGOLDENRODYELLOW);
        button1.setStyle("-fx-background-color: SandyBrown");
        button1.setFont(Font.font("Arial Narrow", 15));
        button1.setOnAction(e -> Option1Drawer.draw(stage, option1Scene));

        Button button2 = new Button("Remover livro");
        button2.setTextFill(Color.LIGHTGOLDENRODYELLOW);
        button2.setStyle("-fx-background-color: SandyBrown");
        button2.setFont(Font.font("Arial Narrow", 15));

        Button button3 = new Button("Emprestar livro");
        button3.setTextFill(Color.LIGHTGOLDENRODYELLOW);
        button3.setStyle("-fx-background-color: SandyBrown");
        button3.setFont(Font.font("Arial Narrow", 15));

        Button button4 = new Button("Alterar localização de um livro");
        button4.setTextFill(Color.LIGHTGOLDENRODYELLOW);
        button4.setStyle("-fx-background-color: SandyBrown");
        button4.setFont(Font.font("Arial Narrow", 15));

        Button button5 = new Button("Alterar especificações de um livro");
        button5.setTextFill(Color.LIGHTGOLDENRODYELLOW);
        button5.setStyle("-fx-background-color: SandyBrown");
        button5.setFont(Font.font("Arial Narrow", 15));

        VBox vBox = new VBox(text, button1, button2, button3, button4, button5);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(110));

        Group layout = new Group();
        layout.getChildren().add(vBox);

        Scene scene = new Scene(layout, 500, 500, Color.LIGHTGOLDENRODYELLOW);

        stage.setTitle("Biblioteca Pessoal");
        stage.setScene(scene);
        //stage.setFullScreen(true);
        stage.show();

    }

}
