package com.booklibrary.model;

public class Book {
    private String title;
    private String author;
    private int edition;
    private int year;
    private Person owner;
    private Place place;

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

    public int getEdition() {
        return edition;
    }
    public int getYear() {
        return year;
    }
    public Person getOwner() {
        return owner;
    }
    public Place getPlace() {
        return place;
    }
}
