package com.booklibrary.pages;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class Page implements Command {
    protected Scene scene;
    protected String title;

    @Override
    public void execute(Stage stage) {
        stage.setScene(this.create(stage));
        stage.show();
    }

    public abstract Scene create(Stage stage);

    protected Button createButton(Stage stage, String text){
        Button button = new Button(text);
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

    protected String getTitle(){
        return this.title;
    }
}
