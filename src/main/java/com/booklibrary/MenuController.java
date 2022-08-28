package com.booklibrary;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    public void onButton1Click(String title){
        model.Book book = new model.Book();
        book.setTitle(title);
    }

    public void switchToOption1(){}
}