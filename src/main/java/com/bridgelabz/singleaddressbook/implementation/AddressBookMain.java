package com.bridgelabz.singleaddressbook.implementation;

import com.bridgelabz.singleaddressbook.service.AddressBook;

public class AddressBookMain {
    public static void main(String args[]) {
        System.out.print("\n\n\t\t\t\t*****WELCOME TO ADDRESSBOOK PROGRAM*****\n\n");
        AddressBook obj = new AddressBook();
        obj.addPerson();
        boolean choice = true;
        while (choice == true) {
            if (obj.getAddressBook().size() > 0)
                choice = obj.addressbookMenu();
            else
                obj.addPerson();
        }
    }
}
