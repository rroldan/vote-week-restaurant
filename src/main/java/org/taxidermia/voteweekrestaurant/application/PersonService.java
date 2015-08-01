package org.taxidermia.voteweekrestaurant.application;

import org.apache.log4j.Logger;
import org.taxidermia.voteweekrestaurant.model.Person;
import org.taxidermia.voteweekrestaurant.model.PersonRepository;
import org.taxidermia.voteweekrestaurant.model.VoteRepository;

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
        logger.debug("addPersonToList()" + person.toString() );
        this.personRepository.save(person);

    }


}
