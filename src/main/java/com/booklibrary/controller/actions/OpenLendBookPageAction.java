package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.model.Database;
import com.booklibrary.view.pages.LendBookPage;

public class OpenLendBookPageAction extends ButtonAction{
    public OpenLendBookPageAction(Database database, Book book) {
        this.buttonText = "Emprestar";
        this.page = new LendBookPage(database, book);
    }
}
