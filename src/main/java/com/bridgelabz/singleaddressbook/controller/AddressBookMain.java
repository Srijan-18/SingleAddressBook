package com.bridgelabz.singleaddressbook.controller;

import com.bridgelabz.singleaddressbook.enums.SortTechnique;
import com.bridgelabz.singleaddressbook.service.AddressBook;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {
        System.out.print("\n\n\t\t\t\t*****WELCOME TO ADDRESS BOOK PROGRAM*****\n\n");
        AddressBook obj = new AddressBook();
        AddressBookMain addressBookMain = new AddressBookMain();
        boolean choice = true;
        while (choice) {
            choice = addressBookMain.addressBookMenu(obj);
        }
    }

    /**
     * METHOD TO DISPLAY MENU OF OPERATIONS
     *
     * @return
     */
    public boolean addressBookMenu(AddressBook addressBook) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n\t\t\t\tEnter the corresponding number to make the choice: " +
                "\n\t\t\t\t1 --> Add Details of a new Person" +
                "\n\t\t\t\t2 --> Edit Details of an existing Person" +
                "\n\t\t\t\t3 --> Delete an existing Person from AddressBook" +
                "\n\t\t\t\t4 --> Sort AddressBook" +
                "\n\t\t\t\t5 --> Display AddressBook" +
                "\n\t\t\t\t6 --> Search for a person" +
                "\n\t\t\t\t7 --> Read From Existing File" +
                "\n\t\t\t\tAny other number to go to main menu." +
                "\n\t\t\t\tYOUR CHOICE --> ");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                addressBook.addPerson();
                break;
            case 2:
                addressBook.editPersonDetails();
                break;
            case 3:
                addressBook.deletePerson();
                break;
            case 4:
                System.out.print("\n\t\t\t\tEnter the corresponding Number to make the choice: " +
                        "\n\t\t\t\t1 --> Sort by NAME" +
                        "\n\t\t\t\t2 --> Sort by CITY" +
                        "\n\t\t\t\t3 --> Sort by STATE" +
                        "\n\t\t\t\t4 --> Sort by ZIP");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        addressBook.sortTheData(SortTechnique.SORT_BY_NAME);
                        addressBook.displayAddressBook();
                        break;
                    case 2:
                        addressBook.sortTheData(SortTechnique.SORT_BY_CITY);
                        addressBook.displayAddressBook();
                        break;
                    case 3:
                        addressBook.sortTheData(SortTechnique.SORT_BY_STATE);
                        addressBook.displayAddressBook();
                        break;
                    case 4:
                        addressBook.sortTheData(SortTechnique.SORT_BY_ZIP);
                        addressBook.displayAddressBook();
                        break;
                    default:
                        System.out.print("\n\t\t\t\t ## INVALID INPUT ##");
                }
                break;
            case 5:
                System.out.print("\n\t\t\t\tEnter the corresponding Number to make the choice: " +
                        "\n\t\t\t\t1 --> Display complete list " +
                        "\n\t\t\t\t2 --> Display only of particular CITY and STATE" +
                        "\n\t\t\t\tYOUR CHOICE --> ");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        addressBook.displayAddressBook();
                        break;
                    case 2:
                        addressBook.viewByCityAndState();
                        break;
                    default:
                        System.out.print("\n\t\t\t\t ## INVALID INPUT ##");
                }
                break;
            case 6:
                addressBook.searchInCityOrState();
                break;
            case 7:
                System.out.print("\n\t\t\t\tEnter the corresponding Number to make the choice: " +
                        "\n\t\t\t\t1 --> Read From JSON" +
                        "\n\t\t\t\t2 --> Read From CSV" +
                        "\n\t\t\t\tYOUR CHOICE --> ");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        addressBook.readFromJson();
                        break;
                    case 2:
                        addressBook.readFromCSV();
                        break;
                    default:
                        System.out.print("\n\t\t\t\t ## INVALID INPUT ##");
                }
            default:
        }
        System.out.print("\n\n\t\t\t\tEnter the corresponding number to make the choice:" +
                "\n\t\t\t\t1 --> Display AddressBook and go to AddressBook Menu" +
                "\n\t\t\t\t2 --> Go To AddressBook Menu" +
                "\n\t\t\t\tAny Other Number to save and exit " +
                "\n\t\t\t\tYOUR CHOICE :");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                addressBook.displayAddressBook();
            case 2:
                return true;
            default:
                System.out.print("\n\t\t\t\tEnter the corresponding Number to make the choice: " +
                        "\n\t\t\t\t1 --> Write in JSON Format" +
                        "\n\t\t\t\t2 --> Write in CSV Format" +
                        "\n\t\t\t\tYOUR CHOICE --> ");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        addressBook.writeInJSON();
                        break;
                    case 2:
                        addressBook.writeInCSV();
                        break;
                    default:
                        System.out.println("\n\t\t\t\t ## INVALID INPUT , FILE NOT SAVED ##");
                }
                return false;
        }
    }
}