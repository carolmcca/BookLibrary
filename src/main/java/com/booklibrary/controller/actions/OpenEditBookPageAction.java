package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.model.Database;
import com.booklibrary.view.pages.EditBookPage;

public class OpenEditBookPageAction extends ButtonAction {
    public OpenEditBookPageAction(Database database, Book book) {
        this.buttonText = "Editar";
        this.page = new EditBookPage(database, book);
    }
}
