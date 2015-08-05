package org.taxidermia.voteweekrestaurant.application;


import org.junit.Test;
import org.taxidermia.voteweekrestaurant.model.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class VoteServiceTest {


    @Test
    public void testVoteOkTest(){
        DomainRegistry domainRegitry = new DomainRegistry();
        VoteRepository voteRepository = domainRegitry.voteRepository();
        VoteService voteService = new  VoteService(voteRepository);

        long voteId = voteRepository.nextIdentity();
        Vote voteFixture =getVoteFixture(voteId);

        voteService.vote(voteFixture);
        Vote vote = voteRepository.voteOfId(voteId);
        assertEquals(voteId, vote.getId());



    }

    @Test(expected=java.lang.IllegalStateException.class)
    public void testVoteEqualPersonExceptionTest(){
        DomainRegistry domainRegitry = new DomainRegistry();
        VoteRepository voteRepository = domainRegitry.voteRepository();
        VoteService voteService = new  VoteService(voteRepository);


        long voteId = voteRepository.nextIdentity();
        Vote voteFixture =getVoteFixture(voteId);
        Vote voteFixture2 = getVoteFixture(voteRepository.nextIdentity());

        voteService.vote(voteFixture);
        voteService.vote(voteFixture2);


    }

    @Test
    public void testListVotesOk(){

        DomainRegistry domainRegitry = new DomainRegistry();
        VoteRepository voteRepository = domainRegitry.voteRepository();
        VoteService voteService = new  VoteService(voteRepository);


        long voteId = voteRepository.nextIdentity();
        Vote voteFixture =  getVoteFixture(voteId);

        voteService.vote(voteFixture);

        List<Vote> voteList = voteService.voteList();
        Vote vote = voteList.iterator().next();

        assertEquals(voteId, vote.getId());


    }






    private Vote getVoteFixture(long voteId){
            Person person = new Person.Builder().id(1l).nickName("nickname").build();
            Restaurant restaurant = new Restaurant.Builder().id(1l).name("name").build();
            Vote   vote = new Vote.Builder().id(voteId).person(person).restaurant(restaurant).build();
            return vote;
        }







}
