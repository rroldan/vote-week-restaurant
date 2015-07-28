package org.taxidermia.voteweekrestaurant.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VoteTest {

    @Test
    public void testNewVoteSetPersonAndRestaurant() {

        long id = 1l;
        String nickname = "nickName";
        String name = "name";

        Person person = new Person.Builder().id(id).nickName(nickname).build();
        Restaurant restaurant = new Restaurant.Builder().id(id).name(name).build();
        Vote   vote = new Vote.Builder().id(id).person(person).restaurant(restaurant).build();

        assertEquals(id, vote.getId());

        assertEquals(id,vote.getPerson().getId());
        assertEquals(nickname, vote.getPerson().getNickName());

        assertEquals(id,vote.getPerson().getId());
        assertEquals(nickname, vote.getPerson().getNickName());

        assertEquals(name, vote.getRestaurant().getName());
    }

    @Test
    public void testNewVoteToString() {
        String voteToString = "Vote[id=1, Person[id=1, nickName=nickName], Restaurant[id=1, name=name]]";
        long id = 1;
        String nickname = "nickName";
        String name = "name";

        Person person = new Person.Builder().id(id).nickName(nickname).build();
        Restaurant restaurant = new Restaurant.Builder().id(id).name(name).build();
        Vote   vote = new Vote.Builder().id(id).person(person).restaurant(restaurant).build();

        assertEquals(voteToString, vote.toString());

    }

    @Test
    public void testVotetHash() {


        Vote vote = getVoteFixture(1l, PersonTest.getPersonFixture(1, "nickName"), RestaurantTest.getRestauranFixture(1,"name"));
        Vote vote2 = getVoteFixture(1l, PersonTest.getPersonFixture(1, "nickName"), RestaurantTest.getRestauranFixture(1, "name"));
        assertEquals(vote.hashCode(), vote2.hashCode());

    }

    @Test
    public void testRestaurantEquals() {
        Vote vote = getVoteFixture(1l, PersonTest.getPersonFixture(1, "nickName"), RestaurantTest.getRestauranFixture(1, "name"));
        Vote vote2 = getVoteFixture(1l, PersonTest.getPersonFixture(1, "nickName"), RestaurantTest.getRestauranFixture(1, "name"));
        assertTrue(vote.equals(vote2));

    }

    public static Vote getVoteFixture(long id, Person person, Restaurant restaurant){
        Vote   vote = new Vote.Builder().id(id).person(person).restaurant(restaurant).build();
        return vote;
    }



}
