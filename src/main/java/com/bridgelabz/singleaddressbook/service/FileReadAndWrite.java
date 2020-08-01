package com.bridgelabz.singleaddressbook.service;

import com.bridgelabz.singleaddressbook.model.Person;

import java.util.List;

public interface FileReadAndWrite {
    void writeToFile(List<Person> addressBookList);
    List<Person> readFromFile();
}
