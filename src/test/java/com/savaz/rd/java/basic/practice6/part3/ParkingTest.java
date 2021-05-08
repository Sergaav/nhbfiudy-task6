package com.savaz.rd.java.basic.practice6.part3;

import org.junit.Assert;
import org.junit.Test;

public class ParkingTest {

    @Test
    public void shouldCorrectBookParkingPlace() {
        Parking parking = new Parking(4);
        parking.arrive(2);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < parking.getListParkingSlots().size(); i++) {
            stringBuilder.append(parking.getListParkingSlots().get(i));
        }
        Assert.assertEquals("0010", stringBuilder.toString());
    }

    @Test
    public void shouldCorrectDeleteCar() {
        Parking parking = new Parking(4);
        parking.arrive(2);
        parking.depart(2);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < parking.getListParkingSlots().size(); i++) {
            stringBuilder.append(parking.getListParkingSlots().get(i));
        }
        Assert.assertEquals("0000", stringBuilder.toString());
    }

    @Test
    public void shouldCorrectBookWhenBusy() {
        Parking parking = new Parking(4);
        parking.arrive(2);
        parking.arrive(2);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < parking.getListParkingSlots().size(); i++) {
            stringBuilder.append(parking.getListParkingSlots().get(i));
        }
        Assert.assertEquals("0011", stringBuilder.toString());
    }

    @Test
    public void shouldCorrectBookWhenBusyToEnd() {
        Parking parking = new Parking(4);
        parking.arrive(2);
        parking.arrive(2);
        parking.arrive(2);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < parking.getListParkingSlots().size(); i++) {
            stringBuilder.append(parking.getListParkingSlots().get(i));
        }
        Assert.assertEquals("1011", stringBuilder.toString());
    }

    @Test
    public void shouldReturnFalseWhenParkingFull() {
        Parking parking = new Parking(4);
        parking.arrive(0);
        parking.arrive(1);
        parking.arrive(2);
        parking.arrive(3);
        boolean test = parking.arrive(2);
        Assert.assertFalse(test);
    }


}