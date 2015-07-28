package org.taxidermia.voteweekrestaurant.model;


import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testNewPersonBuild() {
    long id = 1l;
    String nickname = "nickName";
    Person person = new Person.Builder().id(id).nickName(nickname).build();

        assertEquals(id, person.getId());
        assertEquals(nickname, person.getNickName());


    }


    @Test
    public void testNewPersonToString() {
        String personToString = "Person[id=1, nickName=nickName]";
        long id = 1;
        String nickName = "nickName";
        Person person = new Person.Builder().id(id).nickName(nickName).build();
        assertEquals(personToString, person.toString());

    }

    @Test
    public void testPersonHash() {
        long id = 1;
        String nickName = "nickName";
        Person person = getPersonFixture(1,"nickName");
        Person person2 = getPersonFixture(1, "nickName");
        assertEquals(person.hashCode(), person2.hashCode());

    }

    @Test
    public void testPersonEquals() {
        long id = 1;
        String nickName = "nickName";
        Person person = getPersonFixture(1, "nickName");
        Person person2 = getPersonFixture(1,"nickName");
        assertTrue(person.equals(person2));

    }



    public static Person getPersonFixture(long id, String nickName){
        Person person = new Person.Builder().id(id).nickName(nickName).build();
        return person;
    }

}
