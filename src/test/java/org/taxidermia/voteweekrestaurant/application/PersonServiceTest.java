package org.taxidermia.voteweekrestaurant.application;

import org.junit.Test;
import org.taxidermia.voteweekrestaurant.model.*;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class PersonServiceTest {

    


    @Test
    public void testAddPersonToListOk(){
        PersonRepository personRepository = initPersonRepository();
        PersonService personService = new  PersonService(personRepository);

        long personId = personRepository.nextIdentity();
        Person personFixture =  PersonTest.getPersonFixture(personId, "nickName");

        personService.addPersonToList(personFixture);
        Person person = personRepository.personOfId(personId);

        assertEquals(personId, person.getId());

    }

    @Test
    public void testListPersonsOk(){
        PersonRepository personRepository = initPersonRepository();
        PersonService personService = new  PersonService(personRepository);

        long personId = personRepository.nextIdentity();
        Person personFixture =  PersonTest.getPersonFixture(personId, "nickName");

        personService.addPersonToList(personFixture);

        List<Person> personList = personService.persons();
        Person person = personList.iterator().next();

        assertEquals(personId, person.getId());


    }





    private PersonRepository initPersonRepository(){
        PersonRepository personRepository = new MemoryPersonRepository();
        return personRepository;

}
}