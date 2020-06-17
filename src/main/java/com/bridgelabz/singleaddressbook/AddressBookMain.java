package com.bridgelabz.singleaddressbook;

import java.util.Scanner;

public class AddressBookMain {
    private Person person;
    private Scanner takeInput=new Scanner(System.in);

    //MAIN METHOD

    public static void main (String args[]){
        System.out.print("\n\n\t\t\t\t*****WELECOME TO ADDRESSBOOK PROGRAM*****\n\n");
        AddressBookMain obj=new AddressBookMain();
        obj.addPerson();
        System.out.print("\n\t\t\t\tEnter : " +
                        "\n\t\t\t\t1 --> Edit Details of a Person\n"+
                        "\t\t\t\tYOUR CHOICE --> ");;
        switch (Integer.parseInt(obj.takeInput.nextLine())){
            case 1:
                obj.editPersonDetails();
                System.out.print("\n"+obj.person+"\n\n");
            break;
            default:
                System.out.print("\n\t\t\t\t## INVALID INPUT ##");

        }
    }

    //METHOD TO ADD A PERSON IN THE ADDRESSBOOK

    public void addPerson(){
        System.out.print("\n\t\t\t\tEnter FIRST NAME --> ");
        String firstName=takeInput.nextLine();
        System.out.print("\n\t\t\t\tEnter LAST NAME --> ");
        String lastName=takeInput.nextLine();
        System.out.print("\n\t\t\t\tEnter PHONE NUMBER --> ");
        long phoneNumber=Long.parseLong(takeInput.nextLine());
        System.out.print("\n\t\t\t\tEnter HOUSE NUMBER AND STREET ADDRESS  --> ");
        String streetAddress=takeInput.nextLine();
        System.out.print("\n\t\t\t\tEnter CITY  --> ");
        String city=takeInput.nextLine();
        System.out.print("\n\t\t\t\tEnter STATE  --> ");
        String state=takeInput.nextLine();
        System.out.print("\n\t\t\t\tEnter ZIP CODE  --> ");
        int zip=Integer.parseInt(takeInput.nextLine());
        person= new Person(firstName,lastName,phoneNumber,streetAddress,city,state,zip);

    }

    //METHOD TO EDIT A PERSON'S DETAILS(EXCEPT NAME)

    public void editPersonDetails()
    {
        System.out.print("\n\t\t\t\tEnter the FULL NAME of person to edit --> ");
        String name=takeInput.nextLine();
        if((person.getFirstName()+" "+person.getLastname()).equalsIgnoreCase(name))
        {
            System.out.print("\n\t\t\t\tEnter following inputs to edit respective intended field:\n" +
                            "\t\t\t\t1 --> PHONE NUMBER\n" +
                            "\t\t\t\t2 --> HOUSE NUMBER & STREET ADDRESS\n" +
                            "\t\t\t\t3 --> CITY\n" +
                            "\t\t\t\t4 --> STATE\n" +
                            "\t\t\t\t5 --> ZIP\n"+
                            "\t\t\t\tYOUR CHOICE --> ");
            int editChoice=Integer.parseInt(takeInput.nextLine());
            switch (editChoice){
                case 1:
                    System.out.print("\n\t\t\t\tEnter NEW PHONE NUMBER --> ");
                    person.setPhoneNumber(Long.parseLong(takeInput.nextLine()));
                break;
                case 2:
                    System.out.print("\n\t\t\t\tEnter NEW HOUSE NUMBER AND STREET ADDRESS --> ");
                    person.setStreetAddress(takeInput.nextLine());
                break;
                case 3:
                    System.out.print("\n\t\t\t\tEnter NEW CITY --> ");
                    person.setCity(takeInput.nextLine());
                break;
                case 4:
                    System.out.print("\n\t\t\t\tEnter NEW STATE --> ");
                    person.setState(takeInput.nextLine());
                break;
                case 5:
                    System.out.println("\n\t\t\t\tEnter NEW ZIP --> ");
                    person.setZip(Integer.parseInt(takeInput.nextLine()));
                break;
                default:
                    System.out.print("\n\t\t\t\t## INVALID INPUT ##");
            }

        }
    }
}
