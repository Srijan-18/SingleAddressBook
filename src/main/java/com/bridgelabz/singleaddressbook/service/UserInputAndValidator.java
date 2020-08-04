package com.bridgelabz.singleaddressbook.service;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInputAndValidator {

    private final Scanner scanner = new Scanner(System.in);
    private final String NAME_PATTERN = "^[A-Z]{1}[a-z]{2,}$";

    /**
     * METHOD TO MATCH PATTERN AND RETURN RESULT
     *
     * @param testInput
     * @param validator
     * @return
     */
    private boolean patternCheck(String testInput, String validator) {
        Pattern pattern = Pattern.compile(validator);
        if (pattern.matcher(testInput).matches())
            return true;
        return false;
    }

    public String inputForLastName() {
        String lastName;
        while (true) {
            System.out.print("\n\t\t\t\tEnter LAST NAME --> ");
            lastName = scanner.nextLine();
            if (patternCheck(lastName, NAME_PATTERN))
                break;
            System.out.print("\n\t\t\t\t ## INVALID INPUT ##");
        }
        return lastName;
    }

    public String getInputForFirstName() {
        String firstName;
        while (true) {
            System.out.print("\n\t\t\t\tEnter FIRST NAME --> ");
            firstName = scanner.nextLine();
            if (patternCheck(firstName, NAME_PATTERN))
                break;
            System.out.print("\n\t\t\t\t ## INVALID INPUT ##");
        }
        return firstName;
    }

    public String getInputForPhoneNumber() {
        String phoneNumber;
        while (true) {
            System.out.print("\n\t\t\t\tEnter PHONE NUMBER --> ");
            phoneNumber = scanner.nextLine();
            String PHONE_NUMBER_PATTERN = "^[1-9][0-9]{9}$";
            if (patternCheck(phoneNumber, PHONE_NUMBER_PATTERN))
                break;
            System.out.print("\n\t\t\t\t ## INVALID INPUT ##");
        }
        return phoneNumber;
    }

    public String getInputForHouseNumberAndStreetAddress() {
        String localAddress;
        while (true) {
            System.out.print("\n\t\t\t\tEnter HOUSE NUMBER AND STREET ADDRESS  --> ");
            localAddress = scanner.nextLine();
            String ADDRESS_PATTERN = "^(([a-zA-Z0-9]+[ /,-]?)+[a-zA-Z0-9]){1,3}$";
            if (patternCheck(localAddress, ADDRESS_PATTERN))
                break;
            System.out.print("\n\t\t\t\t ## INVALID INPUT ##");
        }
        return localAddress;
    }

    public String getInputForCity() {
        String city;
        while(true) {
            System.out.print("\n\t\t\t\tEnter CITY  --> ");
            city = scanner.nextLine();
            String CITY_NAME_PATTERN = "^[A-Z]{1}[A-za-z .]{1,}$";
            if (patternCheck(city, CITY_NAME_PATTERN))
                break;
            System.out.print("\n\t\t\t\t ## INVALID INPUT ##");
        }
        return city;
    }

    public String getInputForState() {
        String state;
        while(true) {
            System.out.print("\n\t\t\t\tEnter STATE  --> ");
            state = scanner.nextLine();
            String STATE_NAME_PATTERN = "^[A-Z]{1}[A-za-z ]{1,}$";
            if (patternCheck(state, STATE_NAME_PATTERN))
                break;
            System.out.print("\n\t\t\t\t ## INVALID INPUT ##");
        }
        return state;
    }

    public int getInputForZIP() {
        String zip;
        while(true) {
            System.out.print("\n\t\t\t\tEnter ZipCode  --> ");
            zip = scanner.nextLine();
            String ZIP_PATTERN = "^[1-9][0-9]{5}$";
            if (patternCheck(zip, ZIP_PATTERN))
                break;
            System.out.print("\n\t\t\t\t ## INVALID INPUT ##");
        }
        return Integer.parseInt(zip);
    }
}