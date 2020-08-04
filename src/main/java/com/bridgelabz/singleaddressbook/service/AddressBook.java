package com.bridgelabz.singleaddressbook.service;

import com.bridgelabz.singleaddressbook.enums.SortTechnique;
import com.bridgelabz.singleaddressbook.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class AddressBook {
    private List<Person> addressBook = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * METHOD TO RETURN ADDRESS BOOK
     *
     * @return addressBook
     */
    public List<Person> getAddressBook() {
        return addressBook;
    }

    /**
     * METHOD TO ADD A PERSON IN THE ADDRESS BOOK
     */
    public void addPerson() {
        UserInputAndValidator userInputAndValidator = new UserInputAndValidator();
        System.out.print("\n\t\t\t\tEnter Details of new Individual :");
        String firstName = userInputAndValidator.getInputForFirstName();
        String lastName = userInputAndValidator.inputForLastName();
        if (!equals(firstName + " " + lastName)) {
            String phoneNumber = userInputAndValidator.getInputForPhoneNumber();
            String streetAddress = userInputAndValidator.getInputForHouseNumberAndStreetAddress();
            String city = userInputAndValidator.getInputForCity();
            String state = userInputAndValidator.getInputForState();
            int zip = userInputAndValidator.getInputForZIP();
            Person currentPerson = new Person(firstName, lastName, phoneNumber, streetAddress, city, state, zip);
            addressBook.add(currentPerson);

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
        addressBook.forEach(person -> {
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

    /**
     * METHOD TO DELETE A PERSON
     * @param nameToDelete
     */
    public void deletePerson(String nameToDelete) {
        boolean deletionDone = false;
        for (int i = 0, addressBookSize = addressBook.size(); i < addressBookSize; i++) {
            Person person = addressBook.get(i);
            if ((person.getFirstName() + " " + person.getLastName()).equalsIgnoreCase(nameToDelete)) {
                addressBook.remove(person);
                deletionDone = true;
                System.out.println("\n\t\t\t\t## DELETION SUCCESSFUL ##");
            }
        }
        if (!deletionDone)
            System.out.print("\n\t\t\t\t## NO SUCH PERSON IN LIST ##");
    }

    /**
     * METHOD TO CHECK IF NAME ALREADY PRESENT IN ADDRESS BOOK (OVERRIDING THE EXISTING equals() METHOD OF OBJECT CLASS)
     *
     * @param searchName
     * @return
     */
    @Override
    public boolean equals(Object searchName) {
        return addressBook.stream().anyMatch(currentPerson -> (currentPerson.getFirstName() + " "
                + currentPerson.getLastName()).equalsIgnoreCase((String) searchName));
    }

    /**
     * METHOD TO SORT THE DATA ACCORDING TO COMPARATOR IN ARGUMENTS
     * @param sortTechnique
     */
    public void sortTheData(SortTechnique sortTechnique) {
        addressBook.sort(sortTechnique.getComparator());
    }

    /**
     * METHOD TO DISPLAY THE ADDRESS BOOK
     */
    public void displayAddressBook() {
        addressBook.forEach(System.out::println);
    }

    /**
     * METHOD TO LIST CONTACTS OF A PARTICULAR CITY AND OF A STATE
     * @param state
     * @param city
     */
    public void viewByCityAndState(String state, String city) {
        AtomicBoolean combinationPresent = new AtomicBoolean(false);
        addressBook.forEach(person -> {
            if (person.getState().equalsIgnoreCase(state) && person.getCity().equalsIgnoreCase(city))
                System.out.println(person);
            combinationPresent.set(true);
        });
        if (!combinationPresent.get())
            System.out.print("\n\t\t\t\tSuch Combination of CITY AND STATE not present in data");
    }

    /**
     * METHOD TO SEARCH FOR A PERSON IN A CITY OR STATE
     */
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
                addressBook.forEach(person -> {
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
                addressBook.forEach(person -> {
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
        addressBook = new JSONUsingJavaFileHandlers().readFromFile();
    }

    public void readFromCSV() {
        addressBook = new CSVUsingOpenCSV().readFromFile();
    }

    public void writeInJSON() {
        new JSONUsingJavaFileHandlers().writeToFile(addressBook);
    }

    public void writeInCSV() {
        new CSVUsingOpenCSV().writeToFile(addressBook);
    }
}