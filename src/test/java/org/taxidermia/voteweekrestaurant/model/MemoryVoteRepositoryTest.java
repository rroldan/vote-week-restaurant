package org.taxidermia.voteweekrestaurant.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MemoryVoteRepositoryTest {

   @Test
   public void testVoteRepositorySaveAndFindOneCorrect(){
       Vote voteFixture = getVoteFixture();
       VoteRepository voteRepository = initVoteRepository();
       voteRepository.save(getVoteFixture());
       Vote vote = voteRepository.voteOfId(voteFixture.getId());

       assertNotNull(vote);
       assertEquals(voteFixture.getId(), vote.getId());
       assertEquals(voteFixture.getPerson().getNickName(), vote.getPerson().getNickName());
       assertEquals(voteFixture.getRestaurant().getName(), voteFixture.getRestaurant().getName());

   }


    private Vote getVoteFixture(){
        Person person = new Person.Builder().nickName("nickname").build();
        Restaurant restaurant = new Restaurant.Builder().name("name").build();
        Vote   vote = new Vote.Builder().id(1l).person(person).restaurant(restaurant).build();
        return vote;
    }

    private VoteRepository initVoteRepository(){
        VoteRepository voteRepository = new MemoryVoteRepository();
        return voteRepository;
    }
}
