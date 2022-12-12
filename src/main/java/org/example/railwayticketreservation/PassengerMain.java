package org.example.railwayticketreservation;

import java.sql.*;
import java.util.Scanner;

public class PassengerMain {
    public static void main(String[] args) {
        RailwayReservation railwayReservation = new RailwayReservation();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter name of passenger");
        String name = sc.next();
        System.out.println("enter age");
        int age = sc.nextInt();
        System.out.println("enter passenger choosen sheat");
        String choosenSeat = sc.next();
        System.out.println("enter  type of reservation");
        String reservationType = sc.next();

        String url = "jdbc:mysql://localhost:3306/Dec11exam";
        String username = "root";
        String password = "password";
        String query = "insert into railway_reservation(passenger_name, passenger_age, choosen_seat, reservation_type ,  is_senior_citizen, amount_paid) values(?,?,?,?,?,?)";
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connection Established");
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, choosenSeat);
            preparedStatement.setString(4, reservationType);
            preparedStatement.setString(5, railwayReservation.getChosenSeat());
            preparedStatement.setDouble(6, railwayReservation.getAmountPaid());
            int noOfRows = preparedStatement.executeUpdate();
            System.out.println("inserted rows" + noOfRows);


        } catch (ClassNotFoundException e1) {
            System.err.println("class not found:" + e1.getMessage());
        } catch (SQLException e) {
            System.err.println("Sql exception::" + e.getMessage());
        } catch (Exception e2) {
            System.err.println("exception::" + e2.getMessage());
            e2.printStackTrace();
        } finally {
            {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                    System.out.println("connection closed!!!");
                } catch (SQLException e) {
                    System.err.println("Error::" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

}