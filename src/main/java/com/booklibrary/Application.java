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

        stage.setTitle("Biblioteca Pessoal");
        Menu menu = new Menu();
        Scene scene = menu.create(stage);

        stage.setScene(scene);
        stage.show();
    }

}
