package com.bridgelabz.singleaddressbook.controller;

import com.bridgelabz.singleaddressbook.enums.SortTechnique;
import com.bridgelabz.singleaddressbook.service.AddressBook;
import com.bridgelabz.singleaddressbook.service.UserInputAndValidator;
import com.bridgelabz.singleaddressbook.utility.MySQLDatabase;

import java.util.Scanner;

public class AddressBookMain {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("\n\n\t\t\t\t*****WELCOME TO ADDRESS BOOK PROGRAM*****\n\n");
        AddressBook addressBook = new AddressBook();
        AddressBookMain addressBookMain = new AddressBookMain();
        Scanner scanner = new Scanner(System.in);
        boolean choice = true;
        while (choice) {
            System.out.print("\n\t\t\t\tEnter the corresponding number to make the choice: " +
                    "\n\t\t\t\t1 --> Use Csv or Json" +
                    "\n\t\t\t\t2 --> Use DataBase" +
                    "\n\t\t\t\t9 --> To Exit." +
                    "\n\t\t\t\tYOUR CHOICE --> ");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    choice = addressBookMain.addressBookMenu(addressBook);
                    break;
                case 2:
                    choice = addressBookMain.addressBookDataBaseMenu();
                    break;
                case 9:
                    choice = false;
                    break;
                default:
                    System.out.print("\n\t\t\t\t ## INVALID INPUT ##");
            }

        }
    }

    private boolean addressBookMenu(AddressBook addressBook) {
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

    private boolean addressBookDataBaseMenu() {
        UserInputAndValidator userInputAndValidator = new UserInputAndValidator();
        MySQLDatabase mySQLDatabase = new MySQLDatabase();
        boolean choice = true;
        while (choice) {
            System.out.print("\n\t\t\t\tEnter the corresponding number to make the choice: " +
                    "\n\t\t\t\t1 --> Add Details of a new Person" +
                    "\n\t\t\t\t2 --> Edit Details of an existing Person" +
                    "\n\t\t\t\t3 --> Delete an existing Person from AddressBook" +
                    "\n\t\t\t\t4 --> Display all Entries" +
                    "\n\t\t\t\t9 --> Exit" +
                    "\n\t\t\t\tYOUR CHOICE --> ");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    String firstName = userInputAndValidator.getInputForFirstName();
                    String lastName = userInputAndValidator.getInputForLastName();
                    if (!mySQLDatabase.isPersonPresent(firstName, lastName))
                        mySQLDatabase.addAnEntryToDataBase(userInputAndValidator
                                .getConsolidatedPersonInformation(firstName, lastName));
                    else
                        System.out.println("\n\t\t\t\t ENTRY ALREADY PRESENT");
                    choice = true;
                    break;
                case 2:
                    System.out.println("\n\t\t\t\tEnter First Name of the entry to delete -->");
                    String firstname = scanner.nextLine();
                    System.out.println("\n\t\t\t\tEnter Last Name of the entry to delete -->");
                    String lastname = scanner.nextLine();
                    if (mySQLDatabase.isPersonPresent(firstname, lastname)) {
                        System.out.print("\n\t\t\t\tEnter the corresponding number to make the choice:" +
                                "\n\t\t\t\t1 --> PHONE NUMBER" +
                                "\n\t\t\t\t2 --> HOUSE NUMBER & STREET ADDRESS" +
                                "\n\t\t\t\t3 --> CITY" +
                                "\n\t\t\t\t4 --> STATE" +
                                "\n\t\t\t\t5 --> ZIP" +
                                "\n\t\t\t\tYOUR CHOICE --> ");
                        choice = mySQLDatabase.updateFieldSegregation(Integer.parseInt(scanner.nextLine()),
                                firstname, lastname);
                    }
                    break;
                case 3:
                    System.out.print("\n\t\t\t\tEnter First Name of the entry to delete -->");
                    firstname = scanner.nextLine();
                    System.out.print("\n\t\t\t\tEnter Last Name of the entry to delete -->");
                    lastname = scanner.nextLine();
                    if(mySQLDatabase.deleteAnEntryFromDatabase(firstname, lastname))
                        System.out.println("DELETION SUCCESSFUL");
                    break;
                case 4:
                    mySQLDatabase.displayAllEntries();
                    break;
                case 9:
                    System.exit(0);
            }
        }
        return true;
    }
}