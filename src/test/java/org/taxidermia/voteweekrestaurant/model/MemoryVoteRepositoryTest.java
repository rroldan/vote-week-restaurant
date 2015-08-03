package org.taxidermia.voteweekrestaurant.model;


import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class MemoryVoteRepositoryTest {
    DomainRegistry domainRegitry;
    Person person;
    Restaurant restaurant;


    @Test
   public void testVoteRepositorySaveAndFindOneCorrect(){
        domainRegitry = new DomainRegistry();
        person = PersonTest.getPersonFixture(domainRegitry.personRepository().nextIdentity(), "nickname");
        restaurant = RestaurantTest.getRestauranFixture(1l, "name", "http://localhost" ,"091");

       VoteRepository voteRepository = domainRegitry.voteRepository() ;
       Vote voteFixture = getVoteFixture(voteRepository.nextIdentity(), person, restaurant);
       voteRepository.save(voteFixture);
       Vote vote = voteRepository.voteOfId(voteFixture.getId());

       assertNotNull(vote);
       assertEquals(voteFixture.getId(), vote.getId());
       assertEquals(voteFixture.getPerson().getNickName(), vote.getPerson().getNickName());
       assertEquals(voteFixture.getRestaurant().getName(), voteFixture.getRestaurant().getName());

   }

    @Test(expected=java.lang.IllegalStateException.class)
    public void testVoteRepositoryEqualPerson(){
        domainRegitry = new DomainRegistry();
        person = PersonTest.getPersonFixture(domainRegitry.personRepository().nextIdentity(), "nickname");
        restaurant = RestaurantTest.getRestauranFixture(1l, "name","http://localhost" ,"091");

        VoteRepository voteRepository = domainRegitry.voteRepository() ;
        Vote voteFixture = getVoteFixture(voteRepository.nextIdentity(), person, restaurant);
        voteRepository.save(voteFixture);

        Vote voteFixtureEqual = getVoteFixture(voteRepository.nextIdentity(), person, restaurant);
        voteRepository.save(voteFixtureEqual);


    }


    @Test
   public void testVoteRepositoryNextIdentity() {
        domainRegitry = new DomainRegistry();

        long id=0;
        VoteRepository voteRepository = domainRegitry.voteRepository() ;
       long idNextIdentity = voteRepository.nextIdentity();
       assertNotEquals(id, voteRepository.nextIdentity());
       assertNotEquals(idNextIdentity, voteRepository.nextIdentity());
   }

    @Test
    public void testVoteRepositoryRemove(){
        domainRegitry = new DomainRegistry();
        person = PersonTest.getPersonFixture(domainRegitry.personRepository().nextIdentity(), "nickname");
        restaurant = RestaurantTest.getRestauranFixture(1l, "name", "http://localhost" ,"091");

        VoteRepository voteRepository = domainRegitry.voteRepository() ;
        Vote voteFixture = getVoteFixture(voteRepository.nextIdentity(), person, restaurant);

        voteRepository.save(voteFixture);
        voteRepository.remove(voteFixture);
        Vote vote = voteRepository.voteOfId(voteFixture.getId());
        assertNull(vote);
    }

    @Test
    public void testRepositoryAllVotesOfRestaurant(){
        domainRegitry = new DomainRegistry();
        person = PersonTest.getPersonFixture(domainRegitry.personRepository().nextIdentity(), "nickname");
        restaurant = RestaurantTest.getRestauranFixture(1l, "name","http://localhost" ,"091" );
        VoteRepository voteRepository = domainRegitry.voteRepository();
        Vote voteFixture = getVoteFixture(voteRepository.nextIdentity(), person, restaurant);
        voteRepository.save(voteFixture);
        Collection<Vote> voteCollection = voteRepository.allVotesOfRestaurant(restaurant);
        Vote vote = voteCollection.iterator().next();
        assertEquals(voteFixture.getId(), vote.getId());


    }

    @Test
    public void testVoteRepositoryAllVotes() {
        domainRegitry = new DomainRegistry();
        person = PersonTest.getPersonFixture(domainRegitry.personRepository().nextIdentity(), "nickname");
        restaurant = RestaurantTest.getRestauranFixture(1l, "name", "http://localhost" ,"091");
        VoteRepository voteRepository = domainRegitry.voteRepository();
        Vote voteFixture = getVoteFixture(voteRepository.nextIdentity(), person, restaurant);
        voteRepository.save(voteFixture);
        Collection<Vote> voteCollection = voteRepository.allVotes();
        Vote vote = voteCollection.iterator().next();
        assertEquals(voteFixture.getId(), vote.getId());

    }

    @Test
    public void testPersonRepositoryRemoveAll(){
        domainRegitry = new DomainRegistry();
        person = PersonTest.getPersonFixture(domainRegitry.personRepository().nextIdentity(), "nickname");
        Person person2 = PersonTest.getPersonFixture(domainRegitry.personRepository().nextIdentity(), "nickname");
        restaurant = RestaurantTest.getRestauranFixture(1l, "name", "http://localhost" ,"091");

        VoteRepository voteRepository = domainRegitry.voteRepository();

        Vote voteFixture = getVoteFixture(voteRepository.nextIdentity(), person, restaurant);
        voteRepository.save(voteFixture);

        Vote voteFixture2 = getVoteFixture(voteRepository.nextIdentity(), person2, restaurant);
        voteRepository.save(voteFixture2);


        voteRepository.removeAll();

        Collection<Vote> voteListRemove = voteRepository.allVotes();
        assertEquals(0, voteListRemove.size());

    }




    public static Vote getVoteFixture(long id, Person person, Restaurant restaurant){

        Vote   vote = new Vote.Builder().id(id).person(person).restaurant(restaurant).build();
        return vote;
    }


}
