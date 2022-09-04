package com.booklibrary.model;


public class Book implements Comparable<Book>{
    private String title;
    private String author;
    private Integer edition;
    private Integer year;
    private Person owner;
    private Place place;

    public Book(String title, String author, Integer edition, Integer year, Place place) {
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.year = year;
        this.place = place;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setEdition(int edition) {
        this.edition = edition;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setOwner(Person owner) {
        this.owner = owner;
    }
    public void setPlace(Place place) {
        this.place = place;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public Integer getEdition() {
        return edition;
    }
    public Integer getYear() {
        return year;
    }
    public Person getOwner() {
        return owner;
    }
    public Place getPlace() {
        return place;
    }

    @Override
    public String toString() {
        return this.title + ";" +  this.author + ";" + this.edition + ";" + this.year + ";" + this.place;
    }

    @Override
    public int compareTo(Book book) {
        return this.title.compareTo(book.title);
    }
}
