package com.booklibrary.view.pages;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public abstract class Page {
    protected String title;

    public abstract Node create(Stage stage);

    protected Text createText(String t){
        return this.createText(t, false);
    }
    protected Text createText(String t, boolean bold){
        Text text = new Text(t);
        text.setFill(Color.SANDYBROWN);
        if (bold) text.setFont(Font.font("Arial Narrow", FontWeight.BOLD, 20));
        else text.setFont(Font.font("Arial Narrow", 20));
        return text;
    }

    protected Text createTitle(){
        Text pageTitle = new Text(this.title);
        pageTitle.setFill(Color.SANDYBROWN);
        pageTitle.setFont(Font.font("Arial Black", 40));
        pageTitle.setTextAlignment(TextAlignment.CENTER);

        return pageTitle;
    }
}
