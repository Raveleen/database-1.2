package com.raveleen;

import java.util.ArrayList;
import java.util.List;

public class ApartmentList {
    private static ApartmentList apartmentList;
    private List<Apartment> apartments;

    static {
        apartmentList = new ApartmentList();
    }

    private ApartmentList() {
        apartments = DataBaseController.getInstance().getAll();
    }

    public static ApartmentList getInstance() {
        return apartmentList;
    }

    public void addApartment(int rooms, int area, String district, String address, int price) {
        DataBaseController.getInstance().addToBase(rooms, area, district, address, price);
        apartments = DataBaseController.getInstance().getAll();
    }

    public List<Apartment> getRoomsList(int rooms) {
        List<Apartment> arrayList = new ArrayList<Apartment>();

        for (Apartment a : apartments) {
            if (a.getRooms() == rooms) {
                arrayList.add(a);
            }
        }

        return arrayList;
    }

    public List<Apartment> getAreaList(int min, int max) {
        ArrayList<Apartment> arrayList = new ArrayList<Apartment>();

        for (Apartment a : apartments) {
            if ((a.getArea() >= min) && (a.getArea() <= max)) {
                arrayList.add(a);
            }
        }

        return arrayList;
    }

    public List<Apartment> getDistrictList(String district) {
        ArrayList<Apartment> arrayList = new ArrayList<Apartment>();

        for (Apartment a : apartments) {
            if (a.getDistrict().equals(district)) {
                arrayList.add(a);
            }
        }

        return arrayList;
    }

    public List<Apartment> getAddressList(String address) {
        ArrayList<Apartment> arrayList = new ArrayList<Apartment>();

        for (Apartment a : apartments) {
            if (a.getAddress().equals(address)) {
                arrayList.add(a);
            }
        }

        return arrayList;
    }

    public List<Apartment> getPriceList(int min, int max) {
        ArrayList<Apartment> arrayList = new ArrayList<Apartment>();

        for (Apartment a : apartments) {
            if ((a.getPrice() >= min) && (a.getPrice() <= max)) {
                arrayList.add(a);
            }
        }

        return arrayList;
    }

    public List<Apartment> getList() {
        return apartments;
    }
}
