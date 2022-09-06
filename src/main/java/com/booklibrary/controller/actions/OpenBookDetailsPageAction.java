package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.model.Database;
import com.booklibrary.view.pages.BookDetailsPage;

public class OpenBookDetailsPageAction extends ButtonAction{
    public OpenBookDetailsPageAction(Database database, Book book) {
        this.page = new BookDetailsPage(database, book);
    }
}
