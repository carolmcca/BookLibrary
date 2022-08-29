package com.booklibrary.model;

import java.util.List;

public class Collection {
    private String name;
    private List<Book> books;

    public void setName(String name) {
        this.name = name;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }
    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book){
        this.books.add(book);
    }
}
