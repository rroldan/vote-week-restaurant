package org.taxidermia.voteweekrestaurant.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PersonTest {

    @Test
    public void testNewPersonSetNickName() {
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
        String nickname = "nickName";
        Person person = new Person.Builder().id(id).nickName(nickname).build();
        assertEquals(personToString, person.toString());

    }

}
