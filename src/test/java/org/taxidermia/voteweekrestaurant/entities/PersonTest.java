package org.taxidermia.voteweekrestaurant.entities;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PersonTest {

    @Test
    public void testNewPersonSetNickName() {
    String nickname = "nickName";
    Person person = new Person.Builder(nickname).build();
    assertEquals(nickname,person.getNickName());

}


    @Test
    public void testNewPersonToString() {
        String personToString = "Person: NickName: nickName";
        String nickname = "nickName";
        Person person = new Person.Builder(nickname).build();
        assertEquals(personToString, person.toString());

    }

}
