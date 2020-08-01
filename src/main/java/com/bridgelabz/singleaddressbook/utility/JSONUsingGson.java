package com.bridgelabz.singleaddressbook.service;

import com.bridgelabz.singleaddressbook.model.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class JSONUsingGson implements FileReadAndWrite{
    @Override
    public void writeToFile(List<Person> addressBookList) {
        try (Writer writer = new FileWriter("F:\\Fellowship\\src\\main\\resources\\AddressBook.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(addressBookList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> readFromFile() {
        return null;
    }
}
