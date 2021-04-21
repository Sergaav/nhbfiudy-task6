package com.epam.rd.java.basic.practice6.part3;

public class Part3 {
    private static boolean condition;
    private static Parking parking;

    public static void main(String[] args) {
        parking = new Parking(4);
        System.out.print("Initial state of the parking: ");
        parking.print();
        System.out.println();

        condition = parking.arrive(2);
        printOut();
        condition = parking.arrive(3);
        printOut();
        condition = parking.arrive(2);
        printOut();
        condition = parking.arrive(2);
        printOut();
        condition = parking.arrive(2);
        printOut();
        condition = parking.depart(1);
        printOut();
        condition = parking.depart(1);
        printOut();



    }

    public static void printOut (){
        parking.print();
        System.out.println(","+condition);
    }

}
