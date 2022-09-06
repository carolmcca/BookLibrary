package com.booklibrary.model;

import java.util.Set;
import java.util.TreeSet;

public class Database {
    private final Config config;
    private final Set<Book> books;

    public Database() {
        this.config = new Config();
        this.books = new TreeSet<>();
    }
    public Database(Config config) {
        this.config = config;
        this.books = new TreeSet<>();
    }
    public Database(Config config, Set<Book> books) {
        this.config = config;
        this.books = books;
    }

    public Config getConfig() {
        return config;
    }

    public Set<Book> getBooks() {
        return books;
    }
}
