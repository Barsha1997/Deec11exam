package org.example.basics;

public class ReservationTypeNonAc implements reservationRate{
//    private  static  final String  chosenSeat = "lower berth";
    private  static  final String  reservationType = " Non-AC";
    private static final int rate = 60;


    @Override
    public void rateOfReservation(RailwayReservation railwayReservation) {
       // railwayReservation.setChosenSeat(chosenSeat);
        railwayReservation.setTypeOfReservation(reservationType);
        railwayReservation.setAmountPaid(rate);
    }
}
