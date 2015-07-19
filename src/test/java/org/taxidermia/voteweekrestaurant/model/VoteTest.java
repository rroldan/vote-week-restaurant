package org.taxidermia.voteweekrestaurant.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VoteTest {

    @Test
    public void testNewVoteSetPersonAndRestaurant() {
        String nickname = "nickName";
        String name = "name";

        Person person = new Person.Builder().nickName(nickname).build();
        Restaurant restaurant = new Restaurant.Builder().name(name).build();
        Vote   vote = new Vote.Builder().person(person).restaurant(restaurant).build();

        assertEquals(nickname, vote.getPerson().getNickName());
        assertEquals(name, vote.getRestaurant().getName());
    }

    @Test
    public void testNewVoteToString() {
        String voteToString = "Voto: Person: NickName: nickName , Restaurant: Name: name";
        String nickname = "nickName";
        String name = "name";

        Person person = new Person.Builder().nickName(nickname).build();
        Restaurant restaurant = new Restaurant.Builder().name(name).build();
        Vote   vote = new Vote.Builder().person(person).restaurant(restaurant).build();

        assertEquals(voteToString, vote.toString());

    }


}
