package com.booklibrary.view.pages;

import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public abstract class Page {
    protected String title;

    public abstract Scene create(Stage stage);

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
        pageTitle.setTextAlignment(TextAlignment.CENTER);

        return pageTitle;
    }
}
