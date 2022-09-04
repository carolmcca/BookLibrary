package com.booklibrary.view.pages;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class Page {
    protected Scene scene;
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
        pageTitle.relocate(180, 20);
        return pageTitle;
    }

    protected String getTitle(){
        return this.title;
    }
}
