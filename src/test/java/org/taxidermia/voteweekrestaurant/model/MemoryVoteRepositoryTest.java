package org.taxidermia.voteweekrestaurant.model;


import org.junit.Test;

import static org.junit.Assert.*;

public class MemoryVoteRepositoryTest {
    Person person = PersonTest.getPersonFixture(1l, "nickname");
    Restaurant restaurant = RestaurantTest.getRestauranFixture(1l, "name");


   @Test
   public void testVoteRepositorySaveAndFindOneCorrect(){
       VoteRepository voteRepository = initVoteRepository();
       Vote voteFixture = getVoteFixture(voteRepository.nextIdentity(), person, restaurant);
       voteRepository.save(voteFixture);
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
        VoteRepository voteRepository = initVoteRepository();
        Vote voteFixture = getVoteFixture(voteRepository.nextIdentity(), person, restaurant);

        voteRepository.save(voteFixture);
        voteRepository.remove(voteFixture);
        Vote vote = voteRepository.voteOfId(voteFixture.getId());
        assertNull(vote);
    }


    public static Vote getVoteFixture(long id, Person person, Restaurant restaurant){

        Vote   vote = new Vote.Builder().id(id).person(person).restaurant(restaurant).build();
        return vote;
    }

    private VoteRepository initVoteRepository(){
        VoteRepository voteRepository = new MemoryVoteRepository();
        return voteRepository;
    }
}
