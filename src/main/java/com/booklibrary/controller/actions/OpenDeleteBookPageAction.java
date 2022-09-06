package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.model.Database;
import com.booklibrary.view.pages.DeleteBookPage;

public class OpenDeleteBookPageAction extends ButtonAction {
    public OpenDeleteBookPageAction(Database database, Book book) {
        this.buttonText = "Eliminar";
        this.page = new DeleteBookPage(database, book);
    }
}
