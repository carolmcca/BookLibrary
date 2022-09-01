package com.booklibrary.model;

public class BookOccurrences implements Comparable{
    private Book book;
    private int occurrences;

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
    public int compareTo(Object aux) {
        BookOccurrences o = (BookOccurrences) aux;
        if (this.occurrences < o.occurrences)
            return -1;
        else if (this.occurrences > o.occurrences)
            return 1;
        return 0;
    }
}
