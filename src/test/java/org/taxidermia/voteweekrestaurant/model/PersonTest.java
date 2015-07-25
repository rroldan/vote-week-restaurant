package org.taxidermia.voteweekrestaurant.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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


    public static Person getPersonFixture(long id, String nickName){
        Person person = new Person.Builder().id(id).nickName(nickName).build();
        return person;
    }

}
