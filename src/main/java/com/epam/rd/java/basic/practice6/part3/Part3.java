package com.epam.rd.java.basic.practice6.part3;

public class Part3 {

    public static void main(String[] args) {
        Parking parking = new Parking(4);
        System.out.print("Initial state of the parking: ");
        parking.print();
        System.out.println();
        boolean condition;
        condition = parking.arrive(2);
        parking.print();
        System.out.println(","+condition);

        condition = parking.arrive(3);
        parking.print();
        System.out.println(","+condition);

        condition = parking.arrive(2);
        parking.print();
        System.out.println(","+condition);

        condition = parking.arrive(2);
        parking.print();
        System.out.println(","+condition);

        condition = parking.arrive(2);
        parking.print();
        System.out.println(","+condition);

        condition = parking.depart(1);
        parking.print();
        System.out.println(","+condition);

        condition = parking.depart(1);
        parking.print();
        System.out.println(","+condition);


    }

}
