package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.model.Database;
import com.booklibrary.view.pages.ReturnBookPage;

public class OpenReturnBookPageAction extends ButtonAction {
    public OpenReturnBookPageAction(Book book, Database database){
        this.buttonText = "Devolver";
        this.page = new ReturnBookPage(book, database);
    }
}
