package com.bridgelabz.singleaddressbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AddressBookMain {
    private ArrayList<Person> addressBook = new ArrayList<Person>();
    private Scanner takeInput=new Scanner(System.in);

    // MAIN METHOD

    public static void main (String args[]) {
        System.out.print("\n\n\t\t\t\t*****WELECOME TO ADDRESSBOOK PROGRAM*****\n\n");
        AddressBookMain obj = new AddressBookMain();
        obj.addPerson();
        boolean choice=true;
        while(choice==true) {
            if (obj.addressBook.size() > 0)
                choice = obj.addressbookMenu();
            else
                obj.addPerson();
        }
    }
    // METHOD TO DISPLAY MENU OF OPERATIONS
    public boolean addressbookMenu(){
        System.out.print("\n\t\t\t\tEnter the corresponding number to make the choice: " +
                        "\n\t\t\t\t1 --> Add Details of a new Person" +
                        "\n\t\t\t\t2 --> Edit Details of an existing Person" +
                        "\n\t\t\t\t3 --> Delete an existing Person from AddressBook" +
                        "\n\t\t\t\t4 --> Sort AddressBook" +
                        "\n\t\t\t\tYOUR CHOICE --> ");;
        switch (Integer.parseInt(takeInput.nextLine())){
            case 1:
                addPerson();
                break;
            case 2:
                editPersonDetails();
                break;
            case 3:
                deletePerson();
                break;
            case 4:
                System.out.print("\n\t\t\t\tEnter the corresponding Number to make the choice: "+
                                "\n\t\t\t\t1 --> Sort by NAME"+
                                "\n\t\t\t\t2 --> Sort by CITY"+
                                "\n\t\t\t\t3 --> Sort by STATE"+
                                "\n\t\t\t\t4 --> Sort by ZIP");
                switch(Integer.parseInt(takeInput.nextLine())){
                    case 1:
                        sortByName();
                        displayAddressBook();
                        break;
                    case 2:
                        sortByCity();
                        displayAddressBook();
                        break;
                    case 3:
                        sortByState();
                        displayAddressBook();
                        break;
                    case 4:
                        sortByZip();
                        displayAddressBook();
                        break;
                    default:
                        System.out.print("\n\t\t\t\t ## INVALID INPUT ##");
                }
                break;
            default:
                System.out.print("\n\t\t\t\t## INVALID INPUT ##");

        }
        System.out.print("\n\n\t\t\t\tEnter the corresponding number to make the choice:" +
                        "\n\t\t\t\t1 --> Display AddressBook and go to AddressBook Menu" +
                        "\n\t\t\t\t2 --> Go To AddressBook Menu" +
                        "\n\t\t\t\tAny Other Number to exit "+
                        "\n\t\t\t\tYOUR CHOICE :");
        switch(Integer.parseInt(takeInput.nextLine())){
            case 1:
                displayAddressBook();
            case 2:
                return true;
            default:
                return false;
        }
    }

    // METHOD TO ADD A PERSON IN THE ADDRESS BOOK

    public void addPerson(){
        System.out.print("\n\t\t\t\tEnter FIRST NAME --> ");
        String firstName=takeInput.nextLine();
        System.out.print("\n\t\t\t\tEnter LAST NAME --> ");
        String lastName=takeInput.nextLine();
        if(!equals(firstName+" "+lastName)) {
            System.out.print("\n\t\t\t\tEnter PHONE NUMBER --> ");
            long phoneNumber = Long.parseLong(takeInput.nextLine());
            System.out.print("\n\t\t\t\tEnter HOUSE NUMBER AND STREET ADDRESS  --> ");
            String streetAddress = takeInput.nextLine();
            System.out.print("\n\t\t\t\tEnter CITY  --> ");
            String city = takeInput.nextLine();
            System.out.print("\n\t\t\t\tEnter STATE  --> ");
            String state = takeInput.nextLine();
            System.out.print("\n\t\t\t\tEnter ZIP CODE  --> ");
            int zip = Integer.parseInt(takeInput.nextLine());
            Person currentPerson = new Person(firstName, lastName, phoneNumber, streetAddress, city, state, zip);
            addressBook.add(currentPerson);
        }
        else{
            System.out.print("\n\t\t\t\t ## NAME ALREADY EXISTS ## ");
        }

    }

    // METHOD TO EDIT A PERSON'S DETAILS(EXCEPT NAME)

    public void editPersonDetails() {
        System.out.print("\n\t\t\t\tEnter the FULL NAME of person to edit --> ");
        String name = takeInput.nextLine();
        for (int index=0 ; index<addressBook.size(); index++) {
            if ((addressBook.get(index).getFirstName() + " " + addressBook.get(index).getLastname()).equalsIgnoreCase(name)) {
                System.out.print("\n\t\t\t\tEnter the corresponding number to make the choice:" +
                        "\n\t\t\t\t1 --> PHONE NUMBER" +
                        "\n\t\t\t\t2 --> HOUSE NUMBER & STREET ADDRESS" +
                        "\n\t\t\t\t3 --> CITY" +
                        "\n\t\t\t\t4 --> STATE" +
                        "\n\t\t\t\t5 --> ZIP" +
                        "\n\t\t\t\tYOUR CHOICE --> ");
                int editChoice = Integer.parseInt(takeInput.nextLine());
                switch (editChoice) {
                    case 1:
                        System.out.print("\n\t\t\t\tEnter NEW PHONE NUMBER --> ");
                        addressBook.get(index).setPhoneNumber(Long.parseLong(takeInput.nextLine()));
                        break;
                    case 2:
                        System.out.print("\n\t\t\t\tEnter NEW HOUSE NUMBER AND STREET ADDRESS --> ");
                        addressBook.get(index).setStreetAddress(takeInput.nextLine());
                        break;
                    case 3:
                        System.out.print("\n\t\t\t\tEnter NEW CITY --> ");
                        addressBook.get(index).setCity(takeInput.nextLine());
                        break;
                    case 4:
                        System.out.print("\n\t\t\t\tEnter NEW STATE --> ");
                        addressBook.get(index).setState(takeInput.nextLine());
                        break;
                    case 5:
                        System.out.println("\n\t\t\t\tEnter NEW ZIP --> ");
                        addressBook.get(index).setZip(Integer.parseInt(takeInput.nextLine()));
                        break;
                    default:
                        System.out.print("\n\t\t\t\t## INVALID INPUT ##");
                }

            }
        }
    }
    // METHOD TO DELETE A PERSON

    public void deletePerson() {
        System.out.print("\n\t\t\t\tEnter the FULL NAME of Person to remove from AddressBook --> ");
        String name = takeInput.nextLine();
        boolean deletionDone = false;
        for (int index = 0; index < addressBook.size(); index++) {
            if ((addressBook.get(index).getFirstName() + " " + addressBook.get(index).getLastname()).equalsIgnoreCase(name)) {
                addressBook.remove(index);
                deletionDone = true;
                break;
            }
        }
        if (deletionDone == false)
            System.out.print("\n\t\t\t\t## NO SUCH PERSON IN LIST ##");
    }
    // METHOD TO CHECK IF NAME ALREADY PRESENT IN ADDRESSBOOK (OVERRIDING THE EXISTING equals() METHOD OF OBJECT CLASS)
    @Override
    public boolean equals(Object o) {

        for (Person currentPerson:addressBook) {
            if ((currentPerson.getFirstName()+" "+currentPerson.getLastname()).equalsIgnoreCase((String) o))
                return true;
        }
        return false;
    }
    // METHOD TO SORT THE ADDRESS BOOK BY NAME
    public void sortByName(){
       addressBook.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastname));
    }
    // METHOD TO SORT THE ADDRESS BOOK BY CITY
    public void sortByCity(){
        addressBook.sort(Comparator.comparing(Person::getCity));
    }
    // METHOD TO SORT THE ADDRESS BOOK BY STATE
    public void sortByState(){
        addressBook.sort(Comparator.comparing(Person::getState));
    }
    // METHOD TO SORT ADDRESS BOOK BY ZIP
    public void sortByZip(){
        addressBook.sort(Comparator.comparing(Person::getZip));
    }
    // METHOD TO DISPLAY THE ADDRESS BOOK
    public void displayAddressBook(){
        for (Person person:addressBook) {
            System.out.print("\n\n"+person);
        }
    }
}