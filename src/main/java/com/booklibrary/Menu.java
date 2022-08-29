package com.booklibrary;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class Menu implements Command {
    protected Scene scene;
    protected String title;

    @Override
    public void execute(Stage stage) {
        stage.setScene(this.create(stage));
        stage.show();
    }

    public abstract Scene create(Stage stage);

    protected Button createButton(Stage stage){
        Button button = new Button(this.title);
        button.setTextFill(Color.LIGHTGOLDENRODYELLOW);
        button.setStyle("-fx-background-color: SandyBrown");
        button.setFont(Font.font("Arial Narrow", 15));

        button.setOnAction(e -> this.execute(stage));
        return button;
    }

    protected Text createText(String t){
        Text text = new Text(t);
        text.setFill(Color.SANDYBROWN);
        text.setFont(Font.font("Arial Narrow", 15));
        return text;
    }

    protected Text createTitle(){
        Text pageTitle = new Text(this.title);
        pageTitle.setFill(Color.SANDYBROWN);
        pageTitle.setFont(Font.font("Arial Black", 20));
        pageTitle.relocate(180, 20);
        return pageTitle;
    }
}
