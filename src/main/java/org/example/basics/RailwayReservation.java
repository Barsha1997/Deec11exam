package org.example.basics;

public class RailwayReservation {
    private String passengerName;
    private int passengerAge;

    private String chosenSeat;
    private  String typeOfReservation;
    private double amountPaid;
    private  boolean isSeniorCitizen;

    public void RailwayReservation(String passengerName, int passengerAge, String chosenSeat, String typeOfReservation) {
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.chosenSeat = chosenSeat;
        this.typeOfReservation = typeOfReservation;

    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(int passengerAge) {
        this.passengerAge = passengerAge;
    }

    public String getChosenSeat() {
        return chosenSeat;
    }

    public void setChosenSeat(String chosenSeat) {
        this.chosenSeat = chosenSeat;
    }

    public String getTypeOfReservation() {
        return typeOfReservation;
    }

    public void setTypeOfReservation(String typeOfReservation) {
        this.typeOfReservation = typeOfReservation;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public boolean isSeniorCitizen() {
        return isSeniorCitizen;
    }

    public void setSeniorCitizen(boolean seniorCitizen) {
        isSeniorCitizen = seniorCitizen;
    }

    @Override
    public String toString() {
        return "RailwayReservation{" +
                "passengerName='" + passengerName + '\n' +
                " passengerAge=" + passengerAge +'\n'+
                " chosenSeat=" + chosenSeat + '\n' +
                " typeOfReservation='" + typeOfReservation + '\n' +
                " amountPaid=" + amountPaid +'\n'+
                " isSeniorCitizen=" + isSeniorCitizen +
                '}';


    }

    public boolean isnotSeniorCitizen() {
        return false;

    }
}
