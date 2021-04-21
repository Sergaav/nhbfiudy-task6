package com.epam.rd.java.basic.practice6.part3;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private final List<Integer> listParkingSlots = new ArrayList<>();

    public Parking(int capacity) {
        for (int i = 0; i < capacity; i++) {
            listParkingSlots.add(0);
        }
    }

    public List<Integer> getListParkingSlots() {
        return listParkingSlots;
    }

    public boolean arrive(int k) {
        if (k < 0 || k >= listParkingSlots.size()) {
            throw new IllegalArgumentException();
        }
        if (listParkingSlots.get(k) == 0) {
            listParkingSlots.set(k, 1);
            return true;
        } else {
            for (int i = k + 1; i < listParkingSlots.size(); i++) {
                if (listParkingSlots.get(i) == 0) {
                    listParkingSlots.set(i, 1);
                    return true;
                }
            }
            for (int i = 0; i < k; i++) {
                if (listParkingSlots.get(i) == 0) {
                    listParkingSlots.set(i, 1);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean depart(int k) {
        if (k < 0 || k >= listParkingSlots.size()) {
            throw new IllegalArgumentException();
        }
        if (listParkingSlots.get(k) == 1) {
            listParkingSlots.set(k, 0);
            return true;
        }
        return false;
    }

    public void print() {
        for (Integer listParkingSlot : listParkingSlots) {
            System.out.print(listParkingSlot);
        }
    }
}
