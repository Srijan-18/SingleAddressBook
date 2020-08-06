package com.bridgelabz.singleaddressbook.utility;

import com.bridgelabz.singleaddressbook.enums.UpdateCategory;
import com.bridgelabz.singleaddressbook.model.Person;
import com.bridgelabz.singleaddressbook.service.UserInputAndValidator;

import java.sql.*;

public class MySQLDatabase {

    private Statement statement;

    public MySQLDatabase() {
        try {
            String DB_URL = "jdbc:mysql://localhost:3306/address_book";
            String USER = "root";
            String PASS = "";
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void add (Person person) {
        String query = "INSERT INTO address_book_data VALUES('" + person.getFirstName() + "', '"
                + person.getLastName() + "', '"
                + person.getPhoneNumber() + "', '"
                + person.getStreetAddress() + "', '"
                + person.getCity() + "', '"
                + person.getState() + "', "
                + person.getZip() + ")";
        try {
            statement.executeUpdate(query);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public boolean delete (String firstName, String lastName) {
        String query = "DELETE FROM address_book_data WHERE First_Name ='" + firstName
                +"' AND Last_Name ='" + lastName + "'";
        boolean deletionStatus = false;
        try {
            deletionStatus = statement.executeUpdate(query) > 0;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return deletionStatus;
    }

    public boolean isPersonPresent(String firstName, String lastName) {
        String query = "SELECT * FROM address_book_data WHERE First_Name ='" + firstName
                +"' AND Last_Name ='" + lastName + "'";
        int count = 0;
        try {
            ResultSet rs = statement.executeQuery(query);
            if(rs.next())
                count++;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return count != 0;
    }

    private boolean updateDetails (String firstName, String lastName, UpdateCategory updateCategory, String updateData) {
        String query;
        try {
            switch (updateCategory) {
                case PHONE_NUMBER:
                    query = "UPDATE address_book_data "
                            + "SET Phone_Number ='" + updateData
                            + "' WHERE First_Name ='" + firstName
                            + "' AND Last_Name ='" + lastName + "';";
                    statement.executeUpdate(query);
                    return true;
                case ZIP:
                    query = "UPDATE address_book_data "
                            + "SET Zip ='" +Integer.parseInt(updateData)
                            + "' WHERE First_Name ='" + firstName
                            + "' AND Last_Name ='" + lastName + "';";
                    statement.executeUpdate(query);
                    return true;
                case STATE:
                    query = "UPDATE address_book_data "
                            + "SET State ='" + updateData
                            + "' WHERE First_Name ='" + firstName
                            + "' AND Last_Name ='" + lastName + "';";
                    statement.executeUpdate(query);
                    return true;
                case CITY:
                    query = "UPDATE address_book_data "
                            + "SET City ='" + updateData
                            + "' WHERE First_Name ='" + firstName
                            + "' AND Last_Name ='" + lastName + "';";
                    statement.executeUpdate(query);
                    return true;
                case HOUSE_ADDRESS:
                    query = "UPDATE address_book_data "
                            + "SET Address ='" + updateData
                            + "' WHERE First_Name ='" + firstName
                            + "' AND Last_Name ='" + lastName + "';";
                    statement.executeUpdate(query);
                    return true;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

    public void display() {
        String query = "SELECT * FROM address_book_data";
        try {
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                System.out.print("\n\nName :" + rs.getString("First_Name") + " "
                                              + rs.getString("Last_Name")+
                                    "\nPhone Number :" + rs.getString("Phone_Number") +
                                    "\nAddress :"+ rs.getString("Address") +
                                    "\nCity :" + rs.getString("City") +
                                    "\nState :" + rs.getString("State") +
                                    "\nZip Code :" + rs.getInt("Zip"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public boolean updateFieldSegregation(int inputChoice, String firstname, String lastname) {
        switch (inputChoice) {
            case 1:
                if (this.updateDetails(firstname, lastname, UpdateCategory.PHONE_NUMBER,
                        new UserInputAndValidator().getInputForPhoneNumber()))
                    System.out.print("\n\t\t\t\tUPDATE SUCCESSFUL");
                return true;
            case 2:
                if (this.updateDetails(firstname, lastname, UpdateCategory.HOUSE_ADDRESS,
                        new UserInputAndValidator().getInputForHouseNumberAndStreetAddress()))
                    System.out.print("\n\t\t\t\tUPDATE SUCCESSFUL");
                return true;
            case 3:
                if (this.updateDetails(firstname, lastname, UpdateCategory.CITY,
                        new UserInputAndValidator().getInputForCity()))
                    System.out.print("\n\t\t\t\tUPDATE SUCCESSFUL");
                return true;
            case 4:
                if (this.updateDetails(firstname, lastname, UpdateCategory.STATE,
                        new UserInputAndValidator().getInputForState()))
                    System.out.print("\n\t\t\t\tUPDATE SUCCESSFUL");
                return true;
            case 5:
                if (this.updateDetails(firstname, lastname, UpdateCategory.ZIP,
                        String.valueOf(new UserInputAndValidator().getInputForZIP())))
                    System.out.print("\n\t\t\t\tUPDATE SUCCESSFUL");
                return true;
            default:
                System.out.println("\n\t\t\t\t ## INVALID INPUT ##");
        }
        return false;
    }
}