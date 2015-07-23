package org.taxidermia.voteweekrestaurant.application;


import org.junit.Test;
import org.taxidermia.voteweekrestaurant.model.*;

import static org.junit.Assert.assertEquals;

public class VoteServiceTest {

    VoteRepository voteRepository = initVoteRepository();
    VoteService voteService = new  VoteService(voteRepository);

    @Test
    public void voteOkTest(){

        long voteId = voteRepository.nextIdentity();
        Vote voteFixture =  getVoteFixture(voteId);

        voteService.vote(voteFixture);
        Vote vote = voteRepository.voteOfId(voteId);

        assertEquals(voteId, vote.getId());

    }



    private Vote getVoteFixture(long voteId){
            Person person = new Person.Builder().nickName("nickname").build();
            Restaurant restaurant = new Restaurant.Builder().name("name").build();
            Vote   vote = new Vote.Builder().id(voteId).person(person).restaurant(restaurant).build();
            return vote;
        }

        private VoteRepository initVoteRepository(){
            VoteRepository voteRepository = new MemoryVoteRepository();
            return voteRepository;
        }





}
