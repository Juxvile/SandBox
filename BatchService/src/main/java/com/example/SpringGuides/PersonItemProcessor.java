package com.example.SpringGuides;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(Person person) throws Exception {
        Person transformedPerson = new Person();
        transformedPerson.setLastName(person.getLastName().toUpperCase());
        transformedPerson.setFirstName(person.getFirstName().toUpperCase());

        log.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }
}
