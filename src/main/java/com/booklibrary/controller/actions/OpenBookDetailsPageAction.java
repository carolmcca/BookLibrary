package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.view.pages.BookDetailsPage;

import java.util.Set;

public class OpenBookDetailsPageAction extends ButtonAction{
    public OpenBookDetailsPageAction(Book book, Set<Book> books) {
        this.page = new BookDetailsPage(book, books);
    }
}
