package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.model.Database;
import com.booklibrary.view.pages.LendBookPage;

public class OpenLendBookPageAction extends ButtonAction{
    public OpenLendBookPageAction(Book book, Database database) {
        this.buttonText = "Emprestar";
        this.page = new LendBookPage(book, database);
    }
}
