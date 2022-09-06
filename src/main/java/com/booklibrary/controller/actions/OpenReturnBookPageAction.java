package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.model.Database;
import com.booklibrary.view.pages.ReturnBookPage;

public class OpenReturnBookPageAction extends ButtonAction {
    public OpenReturnBookPageAction(Database database, Book book){
        this.buttonText = "Devolver";
        this.page = new ReturnBookPage(database, book);
    }
}
