package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.model.Config;
import com.booklibrary.view.pages.SearchBookPage;

import java.util.Set;

public class OpenSearchBookPageAction extends ButtonAction{
    public OpenSearchBookPageAction(Config config, Set<Book> books) {
        this.buttonText = "Procurar Livro";
        this.page = new SearchBookPage(config, books);
    }
}
