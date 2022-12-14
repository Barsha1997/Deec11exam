package org.example.database;

import org.example.basics.RailwayReservation;
import org.example.main.PassengerMain;

import java.sql.*;

public class RailwayReservationDatabase {
    public void reservation(RailwayReservation railwayReservation) {
        String url = "jdbc:mysql://localhost:3306/Railway";
        String username = "root";
        String password = "password";
        String query = "insert into railway_reservation(passenger_name, passenger_age, chosen_seat, reservation_type ,  is_senior_citizen, amount_paid) values(?,?,?,?,?,?)";
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connection Established");
            //create table statement
            statement = connection.createStatement();
            //to check if table exists;
            String checkDbTableExists ="select count(*) from information_schema.tables where table_name =?";
            preparedStatement = connection.prepareStatement(checkDbTableExists);
            preparedStatement.setString(1,"Railway_reservation_System");
            boolean ifTableExists = false;
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                if(resultSet.getInt(1)!=0){
                    ifTableExists = true;
                }
            }
            System.out.println("if table exists:::"+ ifTableExists);


            if(!ifTableExists) {
                String createQuery = "create table Railway_Reservation_System(passengerName varchar(60),passengerAge int(10),chosenSeat varchar(20),TypeOfReservation varchar(60),isSeniorCitizen BIT(1) ,amountPaid decimal(10,2))";
                int noOfRows = statement.executeUpdate(createQuery);
                System.out.println("created no of rows::" + noOfRows);
            }
            String insertQuery = "insert into Railway_reservation_System values(?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1,railwayReservation.getPassengerName());
            preparedStatement.setInt(2, railwayReservation.getPassengerAge());
            preparedStatement.setString(3, railwayReservation.getChosenSeat());
            preparedStatement.setString(4, railwayReservation.getTypeOfReservation());
            preparedStatement.setBoolean(5,railwayReservation.isSeniorCitizen());
            preparedStatement.setDouble(6, railwayReservation.getAmountPaid());
            int noOfRows = preparedStatement.executeUpdate();
            System.out.println("inserted rows" + noOfRows);


        } catch (ClassNotFoundException e1) {
            System.err.println("class not found:" + e1.getMessage());
        } catch (
                SQLException e) {
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
