package com.booklibrary.model;

import javafx.beans.property.SimpleStringProperty;

public class Book implements Comparable{
    private SimpleStringProperty title;
    private SimpleStringProperty author;
    private Integer edition;
    private Integer year;
    private Person owner;
    private Place place;

    public Book(String title, String author, Integer edition, Integer year, Place place) {
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.edition = edition;
        this.year = year;
        this.place = place;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }
    public void setAuthor(String author) {
        this.author.set(author);
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
        return title.get();
    }
    public String getAuthor() {
        return author.get();
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
    public int compareTo(Object book) {
        return this.title.get().compareTo(((Book)book).title.get());
    }
}
