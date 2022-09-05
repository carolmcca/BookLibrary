package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.view.pages.DeleteBookPage;

import java.util.Set;

public class OpenDeleteBookPageAction extends ButtonAction {
        public OpenDeleteBookPageAction(Book book, Set<Book> books) {
            this.buttonText = "Eliminar";
            this.page = new DeleteBookPage(book, books);
        }
}
