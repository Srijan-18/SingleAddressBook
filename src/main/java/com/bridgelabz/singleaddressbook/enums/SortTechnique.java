package com.bridgelabz.singleaddressbook.enums;

import com.bridgelabz.singleaddressbook.model.Person;

import java.util.Comparator;

public enum SortTechnique {
    SORT_BY_NAME(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName)),
    SORT_BY_CITY(Comparator.comparing(Person::getCity)),
    SORT_BY_STATE(Comparator.comparing(Person::getState)),
    SORT_BY_ZIP(Comparator.comparing(Person::getZip));

    Comparator comparator;

    SortTechnique(Comparator comparator) {
        this.comparator = comparator;
    }

    public Comparator<Person> getComparator() {
        return comparator;
    }
}