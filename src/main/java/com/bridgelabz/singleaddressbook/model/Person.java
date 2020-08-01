package com.bridgelabz.singleaddressbook.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class Person {
    /**
     * VARIABLES TO STORE DETAILS OF A PERSON
     */

    @CsvBindByName(required = true, column = "FIRST NAME")
    private final String firstName;

    @CsvBindByName(required = true, column = "LAST NAME")
    private final String lastName;

    @CsvBindByName(required = true, column = "STREET ADDRESS")
    private String streetAddress;

    @CsvBindByName(required = true, column = "CITY")
    private String city;

    @CsvBindByName(required = true, column = "STATE")
    private String state;

    @CsvBindByName(required = true, column = "ZIP")
    private int zip;

    @CsvBindByName(required = true, column = "MOBILE NO.")
    private String phoneNumber;

    /**
     * PARAMETERIZED CONSTRUCTOR TO INITIALISE THE VARIABLES
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @param streetAddress
     * @param city
     * @param state
     * @param zip
     */
    public Person(String firstName, String lastName, String phoneNumber, String streetAddress, String city,
                  String state, int zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        setPhoneNumber(phoneNumber);
        setStreetAddress(streetAddress);
        setCity(city);
        setState(state);
        setZip(zip);
    }

    /**
     * GETTER AND SETTER METHODS FOR EACH VARIABLE RESPECTIVELY
     * @return their respective required fields
     */
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * OVERRIDING toString TO GET RETURN IN DESIRED FORMAT
     */
    @Override
    public String toString() {
        return "\n{First Name: " + firstName + "}" +
                "\t{Last Name: " + lastName + "}" +
                "\n{Phone Number: " + phoneNumber + "}" +
                "\n{Address:" + streetAddress + "}" +
                "\t{City: " + city + "}" +
                "\t{State: " + state + "}" +
                "\t{Zip: " + zip + "}\n";
    }
}
