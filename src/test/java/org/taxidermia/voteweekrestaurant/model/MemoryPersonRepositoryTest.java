package org.taxidermia.voteweekrestaurant.model;


import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class MemoryPersonRepositoryTest {



    @Test
    public void testPersonRepositorySaveAndFindOneCorrect(){
        PersonRepository personRepository = initPersonRepository();
        Person personFixture = PersonTest.getPersonFixture(personRepository.nextIdentity(), "nickname");

        personRepository.save(personFixture);
        Person person = personRepository.personOfId(personFixture.getId());

        assertNotNull(person);
        assertEquals(personFixture.getId(), person.getId());
        assertEquals(personFixture.getNickName(), person.getNickName());

    }

    @Test
    public void testPersonRepositoryNextIdentity() {
        long id=0;
        PersonRepository personRepository = initPersonRepository();
        long idNextIdentity = personRepository.nextIdentity();
        assertNotEquals(id, personRepository.nextIdentity());
        assertNotEquals(idNextIdentity, personRepository.nextIdentity());
    }

    @Test
    public void testPersonRepositoryRemove(){
        PersonRepository personRepository = initPersonRepository();
        Person personFixture = PersonTest.getPersonFixture(personRepository.nextIdentity(), "nickname");

        personRepository.save(personFixture);
        personRepository.remove(personFixture);
        Person person = personRepository.personOfId(personFixture.getId());
        assertNull(person);
    }

    @Test
    public  void testPersonRepositoryAllPerson(){

        PersonRepository personRepository = initPersonRepository();
        Person personFixture = PersonTest.getPersonFixture(personRepository.nextIdentity(), "nickname");
        personRepository.save(personFixture);
        Collection<Person> personList = personRepository.allPerson();
        assertEquals(1, personList.size());
        Person person = personList.iterator().next();

        assertNotNull(person);
        assertEquals(personFixture.getId(), person.getId());
        assertEquals(personFixture.getNickName(), person.getNickName());

    }

    @Test
    public void testPersonRepositoryRemoveAll(){
        PersonRepository personRepository = initPersonRepository();

        Person personFixture = PersonTest.getPersonFixture(personRepository.nextIdentity(), "nickname");
        personRepository.save(personFixture);

        Person personFixture2 = PersonTest.getPersonFixture(personRepository.nextIdentity(), "nickname");
        personRepository.save(personFixture2);

        Collection<Person> personList = personRepository.allPerson();
        assertEquals(2, personList.size());

        personRepository.removeAll();

        Collection<Person> personListRemove = personRepository.allPerson();
        assertEquals(0, personListRemove.size());

    }




    private PersonRepository initPersonRepository(){
        PersonRepository personRepository = new MemoryPersonRepository();
        return personRepository;
    }

}
