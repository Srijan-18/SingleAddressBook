package com.bridgelabz.singleaddressbook.utility;

import com.bridgelabz.singleaddressbook.model.Person;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class CSVUsingOpenCSV  {

    public void writeToFile(List<Person> addressBookList) {
        try (Writer writer = Files.newBufferedWriter
                (Paths.get("F:\\Fellowship\\src\\main\\resources\\AddressBook.csv"))) {
            StatefulBeanToCsv<Person> beanToCsv = new StatefulBeanToCsvBuilder<Person>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            beanToCsv.write(addressBookList);
        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }

    public List<Person> readFromFile() {
        try (
                Reader reader = Files.newBufferedReader
                        (Paths.get("F:\\Fellowship\\src\\main\\resources\\AddressBook.csv"));
                CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build()
        ) {
            LinkedList<Person> addressBook = new LinkedList<>();
            String[] nextPerson ;
            while ((nextPerson = csvReader.readNext()) != null) {
                addressBook.add(new Person(nextPerson[1],
                        nextPerson[2],
                        nextPerson[3],
                        nextPerson[5],
                        nextPerson[0],
                        nextPerson[4],
                        Integer.parseInt(nextPerson[6])));
            }
            return addressBook;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
