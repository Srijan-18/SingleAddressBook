package com.bridgelabz.singleaddressbook.service;

import com.bridgelabz.singleaddressbook.model.Person;

import java.util.*;
import java.util.regex.Pattern;

public class AddressBook {
    private List<Person> addressBook = new ArrayList<Person>();
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, Person> cityAndPerson = new HashMap<String, Person>();
    private HashMap<String, Person> stateAndPerson = new HashMap<String, Person>();
    private final String NAME_PATTERN="^[A-Z]{1}[a-z]{2,}$";
    private final String PHONE_NUMBER_PATTERN="^[1-9][0-9]{9}$";
    private final String ZIP_PATTERN="^[1-9][0-9]{5}$";
    private final String ADDRESS_PATTERN="^([a-zA-Z0-9]+[/,-]){30}$";
    private final String STATE_NAME_PATTERN="^[A-Z]{1}[A-za-z ]{2,}$";
    /**
     * METHOD TO RETURN ADDRESSBOOK
     * @return addressBook
     */
    public List<Person> getAddressBook() {
        return addressBook;
    }

    /**
     * METHOD TO MATCH PATTERN AND RETURN RESULT
     * @param testInput
     * @param validator
     * @return
     */
    public boolean patternCheck(String testInput,String validator){
        Pattern pattern=Pattern.compile(validator);
        if(pattern.matcher(testInput).matches())
            return true;
        else
            System.out.print("\n\t\t\t\t ## INVALID INPUT ##\n");
            return false;
    }

    /**
     * METHOD TO DISPLAY MENU OF OPERATIONS
     *
     * @return
     */
    public boolean addressbookMenu() {
        System.out.print("\n\t\t\t\tEnter the corresponding number to make the choice: " +
                "\n\t\t\t\t1 --> Add Details of a new Person" +
                "\n\t\t\t\t2 --> Edit Details of an existing Person" +
                "\n\t\t\t\t3 --> Delete an existing Person from AddressBook" +
                "\n\t\t\t\t4 --> Sort AddressBook" +
                "\n\t\t\t\t5 --> Display AddressBook" +
                "\n\t\t\t\t6 --> Search for a person" +
                "\n\t\t\t\tYOUR CHOICE --> ");
        switch (Integer.parseInt(scanner.nextLine())) {
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
                System.out.print("\n\t\t\t\tEnter the corresponding Number to make the choice: " +
                        "\n\t\t\t\t1 --> Sort by NAME" +
                        "\n\t\t\t\t2 --> Sort by CITY" +
                        "\n\t\t\t\t3 --> Sort by STATE" +
                        "\n\t\t\t\t4 --> Sort by ZIP");
                switch (Integer.parseInt(scanner.nextLine())) {
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
            case 5:
                System.out.print("\n\t\t\t\tEnter the corresponding Number to make the choice: " +
                        "\n\t\t\t\t1 --> Display complete list " +
                        "\n\t\t\t\t2 --> Display only of paticular CITY and STATE" +
                        "\n\t\t\t\tYOUR CHOICE --> ");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        displayAddressBook();
                        break;
                    case 2:
                        viewByCityAndState();
                        break;
                    default:
                        System.out.print("\n\t\t\t\t ## INVALID INPUT ##");
                }
                break;
            case 6:
                searchInCityorState();
                break;
            default:
                System.out.print("\n\t\t\t\t## INVALID INPUT ##");

        }
        System.out.print("\n\n\t\t\t\tEnter the corresponding number to make the choice:" +
                "\n\t\t\t\t1 --> Display AddressBook and go to AddressBook Menu" +
                "\n\t\t\t\t2 --> Go To AddressBook Menu" +
                "\n\t\t\t\tAny Other Number to exit " +
                "\n\t\t\t\tYOUR CHOICE :");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                displayAddressBook();
            case 2:
                return true;
            default:
                return false;
        }
    }

    /**
     * METHOD TO ADD A PERSON IN THE ADDRESS BOOK
     */
    public void addPerson() {
        System.out.print("\n\t\t\t\tEnter Details of new Individual :");
        System.out.print("\n\t\t\t\tEnter FIRST NAME --> ");
        String firstName = scanner.nextLine();
        if(!patternCheck(firstName,NAME_PATTERN))
            addPerson();
        System.out.print("\n\t\t\t\tEnter LAST NAME --> ");
        String lastName = scanner.nextLine();
        if(!patternCheck(lastName,NAME_PATTERN))
            addPerson();
        if (!equals(firstName + " " + lastName)) {
            System.out.print("\n\t\t\t\tEnter PHONE NUMBER --> ");
            String phoneNumber = scanner.nextLine();
            if(!patternCheck(phoneNumber,PHONE_NUMBER_PATTERN))
                addPerson();
            System.out.print("\n\t\t\t\tEnter HOUSE NUMBER AND STREET ADDRESS  --> ");
            String streetAddress = scanner.nextLine();
            if(!patternCheck(streetAddress,ADDRESS_PATTERN))
                addPerson();
            System.out.print("\n\t\t\t\tEnter CITY  --> ");
            String city = scanner.nextLine();
            if(!patternCheck(city,NAME_PATTERN))
                addPerson();
            System.out.print("\n\t\t\t\tEnter STATE  --> ");
            String state = scanner.nextLine();
            if(!patternCheck(state,STATE_NAME_PATTERN))
                addPerson();
            System.out.print("\n\t\t\t\tEnter ZIP CODE  --> ");
            int zip = Integer.parseInt(scanner.nextLine());
            if(!patternCheck(String.valueOf(zip),ZIP_PATTERN))
                addPerson();
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
        System.out.print("\n\t\t\t\tEnter the FULL NAME of person to edit --> ");
        String name = scanner.nextLine();
        for (int index = 0; index < addressBook.size(); index++) {
            if ((addressBook.get(index).getFirstName() + " " + addressBook.get(index).getLastName()).equalsIgnoreCase(name)) {
                System.out.print("\n\t\t\t\tEnter the corresponding number to make the choice:" +
                        "\n\t\t\t\t1 --> PHONE NUMBER" +
                        "\n\t\t\t\t2 --> HOUSE NUMBER & STREET ADDRESS" +
                        "\n\t\t\t\t3 --> CITY" +
                        "\n\t\t\t\t4 --> STATE" +
                        "\n\t\t\t\t5 --> ZIP" +
                        "\n\t\t\t\tYOUR CHOICE --> ");
                int editChoice = Integer.parseInt(scanner.nextLine());
                String updatedValue="";
                switch (editChoice) {
                    case 1:
                        System.out.print("\n\t\t\t\tEnter NEW PHONE NUMBER --> ");
                        updatedValue= scanner.nextLine();
                        if(patternCheck(updatedValue,PHONE_NUMBER_PATTERN))
                        addressBook.get(index).setPhoneNumber(updatedValue);
                        break;
                    case 2:
                        System.out.print("\n\t\t\t\tEnter NEW HOUSE NUMBER AND STREET ADDRESS --> ");
                        updatedValue= scanner.nextLine();
                        if(patternCheck(updatedValue,ADDRESS_PATTERN))
                        addressBook.get(index).setStreetAddress(updatedValue);
                        break;
                    case 3:
                        System.out.print("\n\t\t\t\tEnter NEW CITY --> ");
                        updatedValue= scanner.nextLine();
                        if(patternCheck(updatedValue,NAME_PATTERN))
                        addressBook.get(index).setCity(scanner.nextLine());
                        break;
                    case 4:
                        System.out.print("\n\t\t\t\tEnter NEW STATE --> ");

                        addressBook.get(index).setState(scanner.nextLine());
                        break;
                    case 5:
                        System.out.println("\n\t\t\t\tEnter NEW ZIP --> ");
                        addressBook.get(index).setZip(Integer.parseInt(scanner.nextLine()));
                        break;
                    default:
                        System.out.print("\n\t\t\t\t## INVALID INPUT ##");
                }
            }
        }
    }

    /**
     *  METHOD TO DELETE A PERSON
     */
    public void deletePerson() {
        System.out.print("\n\t\t\t\tEnter the FULL NAME of Person to remove from AddressBook --> ");
        String name = scanner.nextLine();
        boolean deletionDone = false;
        for (int index = 0; index < addressBook.size(); index++) {
            if ((addressBook.get(index).getFirstName() + " "
                    + addressBook.get(index).getLastName()).equalsIgnoreCase(name)) {
                addressBook.remove(index);
                deletionDone = true;
                break;
            }
        }
        if (deletionDone == false)
            System.out.print("\n\t\t\t\t## NO SUCH PERSON IN LIST ##");
    }

    /**
     * METHOD TO CHECK IF NAME ALREADY PRESENT IN ADDRESS BOOK (OVERRIDING THE EXISTING equals() METHOD OF OBJECT CLASS)
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        return addressBook.stream().anyMatch(currentPerson -> (currentPerson.getFirstName() + " "
                + currentPerson.getLastName()).equalsIgnoreCase((String) o));
    }

    /**
     * METHOD TO SORT THE ADDRESS BOOK BY NAME
     */
    public void sortByName() {
        addressBook.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName));
    }

    /**
     * METHOD TO SORT THE ADDRESS BOOK BY CITY
     */
    public void sortByCity() {
        addressBook.sort(Comparator.comparing(Person::getCity));
    }

    /**
     * METHOD TO SORT THE ADDRESS BOOK BY STATE
     */
    public void sortByState() {
        addressBook.sort(Comparator.comparing(Person::getState));
    }

    /**
     * METHOD TO SORT ADDRESS BOOK BY ZIP
     */
    public void sortByZip() {
        addressBook.sort(Comparator.comparing(Person::getZip));
    }

    /**
     * METHOD TO DISPLAY THE ADDRESS BOOK
     */
    public void displayAddressBook() {
        addressBook.forEach(entry -> System.out.println(entry));
    }

    /**
     * METHOD TO LIST CONTACTS OF A PARTICULAR CITY AND OF A STATE
     */
    public void viewByCityAndState() {
        for (Person person : addressBook) {
            cityAndPerson.put(person.getCity(), person);
            stateAndPerson.put(person.getState(), person);
        }
        System.out.print("\n\t\t\t\tEnter CITY --> ");
        String city = scanner.nextLine();
        System.out.print("\n\t\t\t\tEnter STATE --> ");
        String state = scanner.nextLine();
        boolean combinationPresent = false;
        for (Map.Entry<String, Person> stateentry : stateAndPerson.entrySet()) {
            if (state.equalsIgnoreCase(stateentry.getKey())) {
                for (Map.Entry<String, Person> cityentry : cityAndPerson.entrySet()) {
                    if (city.equalsIgnoreCase(cityentry.getKey())) {
                        System.out.print(cityentry.getValue());
                        combinationPresent = true;
                    }
                }

            }
        }
        if (!combinationPresent) {
            System.out.print("\n\t\t\t\tSuch Combination of CITY AND STATE not present in data");
        }
    }

    /**
     * METHOD TO SEARCH FOR A PERSON IN A CITY OR STATE
     */
    public void searchInCityorState() {
        for (Person person : addressBook) {
            cityAndPerson.put(person.getCity(), person);
            stateAndPerson.put(person.getState(), person);
        }
        boolean entryFound = false;
        System.out.print("\n\t\t\t\tEnter the corresponding number to make the choice:" +
                "\n\t\t\t\t1 --> Search in a CITY" +
                "\n\t\t\t\t2 --> Search in a STATE");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                System.out.print("\n\t\t\t\tEnter the name of CITY -->");
                String city = scanner.nextLine();
                System.out.print("\n\t\t\t\tEnter the FULL NAME of Person to be searched -->");
                String name = scanner.nextLine();
                for (Map.Entry<String, Person> cityentry : cityAndPerson.entrySet()) {
                    if (city.equalsIgnoreCase(cityentry.getKey())) {
                        if ((cityentry.getValue().getFirstName() + " " + cityentry.getValue().getLastName()).equalsIgnoreCase(name)) {
                            System.out.print("\n\n" + cityentry.getValue());
                            entryFound = true;
                        }
                    }
                }
                break;
            case 2:
                System.out.print("\n\t\t\t\tEnter the name of STATE -->");
                String state = scanner.nextLine();
                System.out.print("\n\t\t\t\tEnter the FULL NAME of Person to be searched -->");
                name = scanner.nextLine();
                for (Map.Entry<String, Person> stateentry : stateAndPerson.entrySet()) {
                    if (state.equalsIgnoreCase(stateentry.getKey())) {
                        if ((stateentry.getValue().getFirstName() + " " + stateentry.getValue().getLastName()).equalsIgnoreCase(name)) {
                            System.out.print("\n\n" + stateentry.getValue());
                            entryFound = true;
                        }
                    }
                }
                break;
            default:
                System.out.print("\n\t\t\t\t ## INVALID INPUT ##");
        }
        if (!entryFound) {
            System.out.print("\n\t\t\t\tNo Such Combination of Entries Exist");
        }
    }
}
