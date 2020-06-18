package com.bridgelabz.singleaddressbook;

public class Person {
//VARIABLES TO STORE DETAILS OF A PERSON

    private String firstname;
    private String lastname;
    private long phoneNumber;
    private String streetAddress;
    private String city;
    private String state;
    private int zip;

    // PARAMETERIZED CONSTRUCTOR TO INITIALISE THE VARIABLES
    public Person (String firstName,String lastName,long phoneNumber,String streetAddress,String city,String state,int zip){
        setFirstname(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setStreetAddress(streetAddress);
        setCity(city);
        setState(state);
        setZip(zip);

}

//GETTER AND SETTER METHODS FOR EACH VARIABLE RESPECTIVELY

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstName(){
        return firstname;
}

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getZip() {
        return zip;
    }
// OVERRIDING toString TO GET RETURN IN DESIRED FORMAT
    @Override
    public String toString() {
        return "<<First Name: " + firstname +">>"+
                "\t<<Lastname: " + lastname +">>"+
                "\n<<Phone Number: " + phoneNumber +">>"+
                "\n<<Address:" + streetAddress +">>"+
                "\t<<City: " + city +">>"+
                "\t<<State: " + state +">>"+
                "\t<<Zip: " + zip+">>";
    }
}
