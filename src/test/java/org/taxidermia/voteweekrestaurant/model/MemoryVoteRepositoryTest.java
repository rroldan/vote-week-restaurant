package org.taxidermia.voteweekrestaurant.model;


import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
   public void testVoteRepositoryNextIdentity() {
       long id=0;
       VoteRepository voteRepository = initVoteRepository();
       long idNextIdentity = voteRepository.nextIdentity();
       assertNotEquals(id,voteRepository.nextIdentity());
       assertNotEquals(idNextIdentity,voteRepository.nextIdentity());
   }

    @Test
    public void testVoteRepositoryRemove(){
        Vote voteFixture = getVoteFixture();
        VoteRepository voteRepository = initVoteRepository();
        voteRepository.save(voteFixture);
        voteRepository.remove(voteFixture);
        Vote vote = voteRepository.voteOfId(voteFixture.getId());
        assertNull(vote);
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
