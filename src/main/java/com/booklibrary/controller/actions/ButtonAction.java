package com.booklibrary.controller.actions;

import com.booklibrary.view.pages.Page;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public abstract class ButtonAction {
    protected String buttonText;
    protected Page page;

    public void execute(Stage stage) {
        if (this.page == null) return;
        Scene scene = stage.getScene();
        scene.setRoot((Parent)this.page.create(stage));
        stage.show();
    }

    public Button createButton(Stage stage) {
        return this.createButton(stage, this.buttonText);
    }

    public Button createButton(Stage stage, String text){
        Button button = new Button(text);
        button.setTextFill(Color.LIGHTGOLDENRODYELLOW);
        button.setStyle("-fx-background-color: SandyBrown");
        button.setFont(Font.font("Arial Narrow", 20));

        button.setOnAction(e -> this.execute(stage));
        return button;
    }
}
