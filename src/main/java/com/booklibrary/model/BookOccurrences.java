package com.booklibrary.model;

public class BookOccurrences implements Comparable<BookOccurrences> {
    private final Book book;
    private final int occurrences;

    public BookOccurrences(Book book, int occurrences) {
        this.book = book;
        this.occurrences = occurrences;
    }

    public Book getBook() {
        return book;
    }
    public int getOccurrences() {
        return occurrences;
    }
    
    @Override
    public int compareTo(BookOccurrences o) {
        if (this.occurrences < o.occurrences)
            return -1;
        else if (this.occurrences > o.occurrences)
            return 1;
        return this.book.compareTo(o.book);
    }
}
