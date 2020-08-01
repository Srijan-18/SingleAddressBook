package com.bridgelabz.singleaddressbook.model;

public class Person {
    /**
     * VARIABLES TO STORE DETAILS OF A PERSON
     */
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String streetAddress;
    private String city;
    private String state;
    private int zip;

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
    public Person(String firstName, String lastName, String phoneNumber, String streetAddress, String city, String state, int zip) {
        setFirstName(firstName);
        setLastName(lastName);
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
