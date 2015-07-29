package org.taxidermia.voteweekrestaurant.application;


import org.junit.Test;
import org.taxidermia.voteweekrestaurant.model.*;

import static org.junit.Assert.assertEquals;

public class VoteServiceTest {
    DomainRegistry domainRegitry = new DomainRegistry();
    VoteRepository voteRepository = domainRegitry.voteRepository();
    VoteService voteService = new  VoteService(voteRepository);

    @Test
    public void testVoteOkTest(){

        long voteId = voteRepository.nextIdentity();
        Vote voteFixture =getVoteFixture(voteId);

        voteService.vote(voteFixture);
        Vote vote = voteRepository.voteOfId(voteId);
        assertEquals(voteId, vote.getId());



    }

    @Test
    public void testVotesRestaurant() {



    }



    private Vote getVoteFixture(long voteId){
            Person person = new Person.Builder().nickName("nickname").build();
            Restaurant restaurant = new Restaurant.Builder().name("name").build();
            Vote   vote = new Vote.Builder().id(voteId).person(person).restaurant(restaurant).build();
            return vote;
        }







}
