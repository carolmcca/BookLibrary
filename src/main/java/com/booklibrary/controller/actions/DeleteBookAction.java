package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import javafx.stage.Stage;

import java.util.Set;

public class DeleteBookAction extends ButtonAction {
    private Book book;
    private Set<Book> books;
    public DeleteBookAction(Book book, Set<Book> books) {
        this.book = book;
        this.books = books;
    }

    @Override
    public void execute(Stage stage) {
        this.books.remove(book);
    }
}
