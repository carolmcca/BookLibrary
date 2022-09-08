package com.booklibrary.model;


public class Book implements Comparable<Book>{
    private String title;
    private String author;
    private String collection;
    private Integer edition;
    private Integer year;
    private String owner;
    private Place place;
    private String lend;

    public Book(String title, String author, String collection, Integer edition, Integer year, String owner, Place place) {
        this.title = title;
        this.author = author;
        this.collection = collection;
        this.edition = edition;
        this.year = year;
        this.owner = owner;
        this.place = place;
        this.lend = null;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setCollection(String collection) { this.collection = collection; }
    public void setEdition(Integer edition) {
        this.edition = edition;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public void setPlace(Place place) {
        this.place = place;
    }
    public void setLend(String lend) { this.lend = lend; }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getCollection() { return collection; }
    public Integer getEdition() {
        return edition;
    }
    public Integer getYear() {
        return year;
    }
    public String getOwner() {
        return owner;
    }
    public Place getPlace() {
        return place;
    }
    public String getLend() { return lend; }

    @Override
    public String toString() {
        return (this.title == null ? "" : this.title) + ";"
                + (this.author == null ? "" : this.author) + ";"
                + (this.collection == null ? "" : this.collection) + ";"
                + (this.edition == null ? "" : this.edition) + ";"
                + (this.year == null ? "" : this.year) + ";"
                + (this.owner == null ? "" : this.owner) + ";"
                + this.place + ";"
                + (this.lend == null ? "" : this.lend);
    }

    @Override
    public int compareTo(Book book) {
        return this.title.compareTo(book.title);
    }
}
