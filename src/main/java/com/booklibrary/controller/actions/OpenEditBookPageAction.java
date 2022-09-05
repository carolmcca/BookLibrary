package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.view.pages.EditBookPage;

import java.util.Set;

public class OpenEditBookPageAction extends ButtonAction {
    public OpenEditBookPageAction(Set<Book> books, Book book) {
        this.buttonText = "Editar";
        this.page = new EditBookPage(books, book);
    }
}
