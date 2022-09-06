package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import javafx.stage.Stage;

public class ReturnBookAction extends ButtonAction{
    private Book book;
    public ReturnBookAction(Book book){
        this.book = book;
    }

    @Override
    public void execute(Stage stage) {
        this.book.setLend(null);
    }
}
