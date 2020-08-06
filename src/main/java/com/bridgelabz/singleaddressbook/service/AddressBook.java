package com.bridgelabz.singleaddressbook.service;

import com.bridgelabz.singleaddressbook.enums.SortTechnique;
import com.bridgelabz.singleaddressbook.model.Person;
import com.bridgelabz.singleaddressbook.utility.CSVUsingOpenCSV;
import com.bridgelabz.singleaddressbook.utility.JSONUsingGson;
import com.bridgelabz.singleaddressbook.utility.JSONUsingJavaFileHandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class AddressBook {
    private List<Person> personList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addPerson() {
        UserInputAndValidator userInputAndValidator = new UserInputAndValidator();
        System.out.print("\n\t\t\t\tEnter Details of new Individual :");
        String firstName = userInputAndValidator.getInputForFirstName();
        String lastName = userInputAndValidator.getInputForLastName();
        if (!equals(firstName + " " + lastName)) {
            String phoneNumber = userInputAndValidator.getInputForPhoneNumber();
            String streetAddress = userInputAndValidator.getInputForHouseNumberAndStreetAddress();
            String city = userInputAndValidator.getInputForCity();
            String state = userInputAndValidator.getInputForState();
            int zip = userInputAndValidator.getInputForZIP();
            Person currentPerson = new Person(firstName, lastName, phoneNumber, streetAddress, city, state, zip);
            personList.add(currentPerson);

        } else {
            System.out.print("\n\t\t\t\t ## NAME ALREADY EXISTS ## ");
        }
    }

    /**
     * METHOD TO EDIT A PERSON'S DETAILS(EXCEPT NAME)
     */
    public void editPersonDetails() {
        UserInputAndValidator userInputAndValidator = new UserInputAndValidator();
        System.out.print("\n\t\t\t\tEnter the FULL NAME of person to edit --> ");
        String name = scanner.nextLine();
        personList.forEach(person -> {
            if ((person.getFirstName() + " " + person.getLastName()).equalsIgnoreCase(name)) {
                System.out.print("\n\t\t\t\tEnter the corresponding number to make the choice:" +
                        "\n\t\t\t\t1 --> PHONE NUMBER" +
                        "\n\t\t\t\t2 --> HOUSE NUMBER & STREET ADDRESS" +
                        "\n\t\t\t\t3 --> CITY" +
                        "\n\t\t\t\t4 --> STATE" +
                        "\n\t\t\t\t5 --> ZIP" +
                        "\n\t\t\t\tYOUR CHOICE --> ");
                int editChoice = Integer.parseInt(scanner.nextLine());
                switch (editChoice) {
                    case 1:
                        person.setPhoneNumber(userInputAndValidator.getInputForPhoneNumber());
                        break;
                    case 2:
                        person.setStreetAddress(userInputAndValidator.getInputForHouseNumberAndStreetAddress());
                        break;
                    case 3:
                        person.setCity(userInputAndValidator.getInputForCity());
                        break;
                    case 4:
                        person.setState(userInputAndValidator.getInputForState());
                        break;
                    case 5:
                        person.setZip(userInputAndValidator.getInputForZIP());
                        break;
                    default:
                        System.out.print("\n\t\t\t\t## INVALID INPUT ##");
                }
            }
        });
    }

    public void deletePerson() {
        System.out.print("\n\t\t\t\tEnter the FULL NAME of Person to remove from AddressBook --> ");
        String name = scanner.nextLine();
        boolean deletionDone = false;
        for (Person person : personList) {
            if ((person.getFirstName() + " " + person.getLastName()).equalsIgnoreCase(name)) {
                personList.remove(person);
                deletionDone = true;
                System.out.println("\n\t\t\t\t## DELETION SUCCESSFUL ##");
            }
        }
        if (!deletionDone)
            System.out.print("\n\t\t\t\t## NO SUCH PERSON IN LIST ##");
    }

    @Override
    public boolean equals(Object searchName) {
        return personList.stream().anyMatch(currentPerson -> (currentPerson.getFirstName() + " "
                + currentPerson.getLastName()).equalsIgnoreCase((String) searchName));
    }

    public void sortTheData(SortTechnique sortTechnique) {
        personList.sort(sortTechnique.getComparator());
    }

    public void displayAddressBook() {
        personList.forEach(System.out::println);
    }

    public void viewByCityAndState() {
        System.out.print("\n\t\t\t\tEnter CITY --> ");
        String city = scanner.nextLine();
        System.out.print("\n\t\t\t\tEnter STATE --> ");
        String state = scanner.nextLine();
        AtomicBoolean combinationPresent = new AtomicBoolean(false);
        personList.forEach(person -> {
            if (person.getState().equalsIgnoreCase(state) && person.getCity().equalsIgnoreCase(city))
                System.out.println(person);
            combinationPresent.set(true);
        });
        if (!combinationPresent.get())
            System.out.print("\n\t\t\t\tSuch Combination of CITY AND STATE not present in data");
    }

    public void searchInCityOrState() {
        AtomicBoolean entryFound = new AtomicBoolean(false);
        System.out.print("\n\t\t\t\tEnter the corresponding number to make the choice:" +
                "\n\t\t\t\t1 --> Search in a CITY" +
                "\n\t\t\t\t2 --> Search in a STATE");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                System.out.print("\n\t\t\t\tEnter the name of CITY -->");
                String city = scanner.nextLine();
                System.out.print("\n\t\t\t\tEnter the FULL NAME of Person to be searched -->");
                String name = scanner.nextLine();
                personList.forEach(person -> {
                    if (person.getFirstName().concat(" " + person.getLastName()).equalsIgnoreCase(name)
                            && person.getCity().equalsIgnoreCase(city)) {
                        System.out.print("\n\n\t\t\t\t" + person);
                        entryFound.set(true);
                    }
                });
                break;
            case 2:
                System.out.print("\n\t\t\t\tEnter the name of STATE -->");
                String state = scanner.nextLine();
                System.out.print("\n\t\t\t\tEnter the FULL NAME of Person to be searched -->");
                name = scanner.nextLine();
                personList.forEach(person -> {
                    if (person.getFirstName().concat(" " + person.getLastName()).equalsIgnoreCase(name)
                            && person.getState().equalsIgnoreCase(state)) {
                        System.out.print("\n\n\t\t\t\t" + person);
                        entryFound.set(true);
                    }
                });
                break;
            default:
                System.out.print("\n\t\t\t\t ## INVALID INPUT ##");
        }
        if (!entryFound.get()) {
            System.out.print("\n\t\t\t\tNo Such Combination of Entries Exist");
        }
    }

    public void readFromJson() {
        if(((Math.floor(Math.random()*1000)) % 2) == 0)
            personList = new JSONUsingJavaFileHandlers().readFromFile();
        else
            personList = new JSONUsingGson().readFromFile();
    }

    public void readFromCSV() {
        personList = new CSVUsingOpenCSV().readFromFile();
    }

    public void writeInJSON() {
        if(((Math.floor(Math.random()*1000)) % 2) == 0)
            new JSONUsingJavaFileHandlers().writeToFile(personList);
        else
            new JSONUsingGson().writeToFile(personList);
    }

    public void writeInCSV() {
        new CSVUsingOpenCSV().writeToFile(personList);
    }
}