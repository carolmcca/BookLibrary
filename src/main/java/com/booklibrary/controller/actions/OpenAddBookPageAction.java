package com.booklibrary.controller.actions;

import com.booklibrary.model.Database;
import com.booklibrary.view.pages.AddBookPage;

public class OpenAddBookPageAction extends ButtonAction{
    public OpenAddBookPageAction(Database database) {
        this.buttonText = "Adicionar Livro";
        this.page = new AddBookPage(database);
    }
}
