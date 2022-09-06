package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import javafx.stage.Stage;

import java.util.Set;

public class DeleteBookAction extends ButtonAction {
    private final Set<Book> books;
    private final Book book;

    public DeleteBookAction(Set<Book> books, Book book) {
        this.books = books;
        this.book = book;
    }

    @Override
    public void execute(Stage stage) {
        this.books.remove(book);
    }
}
