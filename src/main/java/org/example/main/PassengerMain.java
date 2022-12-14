/*
Write a program on Railway ticket reservation systems,

[Hints: consider a class RailwayReservastion, take attributes as ‘passengerName’, ‘passengerAge’, ‘choosenSeat’, ‘typeOfReservasion’ (AC / Non-AC), ‘amountPaid’, ‘isSeniorCitizen’.
             Take input of passengerName, age, seat, and type, while taking input do proper validation like age provided as integer not any other format like float or String and if age > 60 then
             consider passenger as senior citizen and populate ‘isSeniorCitizen’ as true assign the lower berth/seat. And after taking all the input need to calculate the amount to be paid for booking,
             if ‘AC’ is the type of reservation then rate will be $100 and if non-AC the rate will be $60.

1.	Create one table using jdbc named: ‘railway_reservastion’ with column name as ‘passenger_name’, ‘paggenger_age’, ‘choosen_seat’, ‘reservation_type’, ‘is_senior_citizen’, ‘amount_paid’.
2.	Once take input of passengerName, passengerAge, choosenSeat and typeOfReservation, then please insert those records to database.
3.	Once calculated weather the passenger is senior citizen or not then update the same under column name ‘is_senior_citizen’ in the already inserted row (in point 2) with 0 / 1 value (while true value to be saved 1 and 0 while value will be false)
4.	Once amount been calculated then same would be updated under ‘amount_paid’ column for the inserted row (in point 2).
    ** Make sure you follow the steps mentioned above while inserting and updating the row. */



package org.example.main;

import org.example.basics.RailwayReservation;
import org.example.basics.ReservationTypeAc;
import org.example.basics.ReservationTypeNonAc;
import org.example.database.RailwayReservationDatabase;

import java.sql.*;
import java.util.Scanner;

public class PassengerMain {
    public static void main(String[] args) {
        RailwayReservation railwayReservation = new RailwayReservation();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter name of passenger");
        String name = sc.next();
        railwayReservation.setPassengerName(name);

        System.out.println("enter age");
        int age = sc.nextInt();
        railwayReservation.setPassengerAge(age);

        System.out.println("enter  type of reservation");
        String reservationType = sc.next();
        railwayReservation.setTypeOfReservation(reservationType);

        System.out.println("enter passenger choosen sheat");
        String choosenSeat = sc.next();
        railwayReservation.setChosenSeat(choosenSeat);


        ///what if age is <60  and i want to terminate after entering age i dont want the other option for ac or non ac

        if(age>60) {
            railwayReservation.setSeniorCitizen(true);

        } else {
            railwayReservation.setSeniorCitizen(false);
        }



        if(reservationType.equalsIgnoreCase("Ac")){
            ReservationTypeAc reservationTypeAc = new ReservationTypeAc();
            reservationTypeAc.rateOfReservation(railwayReservation);
        }
        else {
            ReservationTypeNonAc reservationTypeNonAc = new ReservationTypeNonAc();
            reservationTypeNonAc.rateOfReservation(railwayReservation);
        }
        System.out.println(railwayReservation);

        RailwayReservationDatabase railwayReservationDatabase = new RailwayReservationDatabase();
        railwayReservationDatabase.reservation(railwayReservation);
    }

}