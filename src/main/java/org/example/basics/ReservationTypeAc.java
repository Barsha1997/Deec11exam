package org.example.basics;

public class ReservationTypeAc implements  reservationRate{
  //  private  static  final String  chosenSeat = "lower berth";
    private  static  final String  reservationType = "AC";
    private static final int rate = 100;

    @Override
    public void rateOfReservation(RailwayReservation railwayReservation) {
       // railwayReservation.setChosenSeat(chosenSeat);
        railwayReservation.setTypeOfReservation(reservationType);
        railwayReservation.setAmountPaid(rate);
    }
}
