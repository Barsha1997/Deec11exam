package org.example.railwayticketreservation;

public class RailwayReservation {
    private String passengerName;
    private int passengerAge;
    private String chosenSeat;
    private  String typeOfReservation;
    private double amountPaid;
    private  boolean isSeniorCitizen =true;

    public boolean RailwayReservation(String passengerName, int passengerAge, String chosenSeat, String typeOfReservation) {
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.chosenSeat = chosenSeat;
        this.typeOfReservation = typeOfReservation;


        if (passengerAge > 60) {
            this.chosenSeat = "berth";
             boolean isSeniorCitizen = true;
            System.out.println("integer value "+ isSeniorCitizen);
            int val = (isSeniorCitizen)?1:0;
            System.out.println(val);;
            reservationType();
        }
        return false;
    }


    public  void reservationType(){
        if((typeOfReservation=="AC")||(typeOfReservation=="ac")){
            amountPaid =100;
        }else
            amountPaid=50;

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





}
