package com.bridgelabz.singleaddressbook;

import java.util.Scanner;

public class AddressBookMain {
    Person person;
    Scanner takeInput=new Scanner(System.in);

    //MAIN METHOD

    public static void main (String args[]){
        System.out.print("\n\n\t\t\t\t*****WELECOME TO ADDRESSBOOK PROGRAM*****\n\n");
        AddressBookMain obj=new AddressBookMain();
        obj.addPerson();
    }

    //METHOD TO ADD A PERSON IN THE ADDRESSBOOK

    public void addPerson(){
        System.out.print("\n\t\t\t\tEnter FIRST NAME --> ");
        String firstName=takeInput.nextLine();
        System.out.print("\n\t\t\t\tEnter LAST NAME -->");
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
}
