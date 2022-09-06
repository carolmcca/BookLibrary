package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.model.Config;
import com.booklibrary.view.pages.BookAddedPage;

import java.util.Set;

public class OpenBookAddedPageAction extends ButtonAction{
    public OpenBookAddedPageAction(Config config, Set<Book> books) {
        this.buttonText = "Livro Adicionado";
        this.page = new BookAddedPage(config, books);
    }
}
