package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.model.Config;
import com.booklibrary.model.Database;
import com.booklibrary.view.pages.BookAddedPage;

import java.util.Set;

public class OpenBookAddedPageAction extends ButtonAction{
    public OpenBookAddedPageAction(Database database) {
        this.buttonText = "Livro Adicionado";
        this.page = new BookAddedPage(database);
    }
}
