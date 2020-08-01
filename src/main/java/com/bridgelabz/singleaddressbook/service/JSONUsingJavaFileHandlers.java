package com.bridgelabz.singleaddressbook.service;

import com.bridgelabz.singleaddressbook.model.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONUsingJavaFileHandlers implements FileReadAndWrite {

    @SuppressWarnings("unchecked")
    @Override
    public void writeToFile(List<Person> personList) {
        JSONArray personJSONArray = new JSONArray();
        personList.forEach(person -> {
            JSONObject personDetails = new JSONObject();
            personDetails.put("First Name", person.getFirstName());
            personDetails.put("Last Name", person.getLastName());
            personDetails.put("Phone Number", person.getPhoneNumber());
            personDetails.put("Address", person.getStreetAddress());
            personDetails.put("City", person.getCity());
            personDetails.put("State", person.getState());
            personDetails.put("Zip", person.getZip());

            JSONObject personDetailsUnifiedJSON = new JSONObject();
            personDetailsUnifiedJSON.put("Details", personDetails);
            personJSONArray.add(personDetailsUnifiedJSON);
        });
        try (FileWriter file = new FileWriter("F:\\Fellowship\\src\\main\\resources\\AddressBook.json")) {
            file.write(personJSONArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Person> readFromFile() {
        JSONParser jsonParser = new JSONParser();
        List<Person> addressBook = new ArrayList<>();
        try (FileReader reader = new FileReader("F:\\Fellowship\\src\\main\\resources\\AddressBook.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray personArray = (JSONArray) obj;
            personArray.forEach(person -> addressBook.add(parseEmployeeObject((JSONObject) person)));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return addressBook;
    }

    private Person parseEmployeeObject(JSONObject person)
    {
        JSONObject personObject = (JSONObject) person.get("Details");
        String firstName = String.valueOf(personObject.get("First Name"));
        String lastName = String.valueOf(personObject.get("Last Name"));
        String phoneNumber = String.valueOf(personObject.get("Phone Number"));
        String streetAddress = String.valueOf(personObject.get("Address"));
        String city = String.valueOf(personObject.get("City"));
        String state = String.valueOf(personObject.get("State"));
        int zip = Integer.parseInt(String.valueOf(personObject.get("Zip")));
        return new Person(firstName, lastName, phoneNumber, streetAddress, city, state, zip);
    }
}