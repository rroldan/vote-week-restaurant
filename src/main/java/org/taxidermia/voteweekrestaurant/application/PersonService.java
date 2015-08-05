package org.taxidermia.voteweekrestaurant.application;

import org.apache.log4j.Logger;
import org.taxidermia.voteweekrestaurant.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion logica personas
 */
public class PersonService {
    static Logger logger = Logger.getLogger(PersonService.class);

    private PersonRepository personRepository;

    public PersonService(PersonRepository newPersonRepository){
        this.personRepository = newPersonRepository;
    }


    public void addPersonToList(Person person){
        logger.debug("addPersonToList()" + person.toString());
        this.personRepository.save(person);

    }

    public List<Person> personList(){
        List<Person> personList = new ArrayList();
        for (Person person : this.personRepository.allPerson()){
            personList.add(person);
        }

        logger.debug("persons() " + personList);
        return personList;

    }

    public Person getPerson(Long personId){
        logger.debug("getPerson() " + "id=" + personId);
        Person person = this.personRepository.personOfId(personId);
        logger.debug("return getPerson() " + person);
        return person;

    }



}
