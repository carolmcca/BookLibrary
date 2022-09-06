package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.model.Config;
import com.booklibrary.view.pages.AddBookPage;
import com.booklibrary.view.pages.BookFormPage;

import java.util.Set;

public class OpenAddBookPageAction extends ButtonAction{
    public OpenAddBookPageAction(Config config, Set<Book> books) {
        this.buttonText = "Adicionar Livro";
        this.page = new AddBookPage(config, books);
    }
}
