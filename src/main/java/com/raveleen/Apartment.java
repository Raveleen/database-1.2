package com.raveleen;

public class Apartment {
    private int id;
    private int rooms;
    private int area;
    private String district;
    private String address;
    private int price;

    public Apartment(int id, int rooms, int area, String district, String address, int price) {
        this.id = id;
        this.rooms = rooms;
        this.area = area;
        this.district = district;
        this.address = address;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", rooms=" + rooms +
                ", area=" + area +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                '}';
    }
}