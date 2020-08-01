package com.bridgelabz.singleaddressbook.utility;

import com.bridgelabz.singleaddressbook.model.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONUsingGson {

    public void writeToFile(List<Person> addressBookList) {
        try (Writer writer = new FileWriter("F:\\Fellowship\\src\\main\\resources\\AddressBook.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(addressBookList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Person> readFromFile() {
        List<Person> addressBook = null;
        try {
            Person[] personDetails = new Gson().fromJson
                    (new FileReader("F:\\Fellowship\\src\\main\\resources\\AddressBook.json"), Person[].class);
            addressBook = new ArrayList<>(Arrays.asList(personDetails));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return addressBook;
    }
}
