package com.booklibrary.model;

public class Place {
    private String address;
    private String room;
    private String cabinet;
    private String shelf;

    public Place(String address, String room, String cabinet, String shelf){
        this.address = address;
        this.room = room;
        this.cabinet = cabinet;
        this.shelf = shelf;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }
    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public String getAddress() {
        return address;
    }
    public String getRoom() {
        return room;
    }
    public String getCabinet() {
        return cabinet;
    }
    public String getShelf() {
        return shelf;
    }

    @Override
    public String toString() {
        return this.address + "|" + this.room + "|" + this.cabinet + "|" + this.shelf;
    }
}
