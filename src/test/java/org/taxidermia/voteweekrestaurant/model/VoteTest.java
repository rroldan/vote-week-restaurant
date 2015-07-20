package org.taxidermia.voteweekrestaurant.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VoteTest {

    @Test
    public void testNewVoteSetPersonAndRestaurant() {

        String id = "1";
        String nickname = "nickName";
        String name = "name";

        Person person = new Person.Builder().nickName(nickname).build();
        Restaurant restaurant = new Restaurant.Builder().name(name).build();
        Vote   vote = new Vote.Builder().id(id).person(person).restaurant(restaurant).build();

        assertEquals(id, vote.getId());
        assertEquals(nickname, vote.getPerson().getNickName());
        assertEquals(name, vote.getRestaurant().getName());
    }

    @Test
    public void testNewVoteToString() {
        String voteToString = "Vote[id=1, Person[nickName=nickName], Restaurant[name=name]]";
        String id = "1";
        String nickname = "nickName";
        String name = "name";

        Person person = new Person.Builder().nickName(nickname).build();
        Restaurant restaurant = new Restaurant.Builder().name(name).build();
        Vote   vote = new Vote.Builder().id(id).person(person).restaurant(restaurant).build();

        assertEquals(voteToString, vote.toString());

    }


}
