package org.taxidermia.voteweekrestaurant.application;

import org.junit.Test;
import org.taxidermia.voteweekrestaurant.model.*;

import static org.junit.Assert.assertEquals;


public class PersonServiceTest {

    PersonRepository personRepository = initPersonRepository();
    PersonService personService = new  PersonService(personRepository);

    @Test
    public void personOkTest(){

        long personId = personRepository.nextIdentity();
        Person personFixture =  PersonTest.getPersonFixture(personId, "nickName");

        personService.addPersonToList(personFixture);
        Person person = personRepository.personOfId(personId);

        assertEquals(personId, person.getId());

    }





    private PersonRepository initPersonRepository(){
        PersonRepository personRepository = new MemoryPersonRepository();
        return personRepository;

}
}