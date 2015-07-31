package org.taxidermia.voteweekrestaurant.model;

import java.util.*;

/**
 * Implementación Repositorio de Votos
 */
public class MemoryVoteRepository implements VoteRepository {

    private Map<Long,Vote> store;

    public MemoryVoteRepository() {
        this.store = new HashMap<Long,Vote>();
    }


    public long nextIdentity() {
        UUID uid = UUID.randomUUID();
        return  Math.abs(uid.getLeastSignificantBits());
    }


    public Collection<Vote> allVotesOfRestaurant(Restaurant restaurant) {
        Collection<Vote> voteCollection = new ArrayList();
        for (Vote vote : store.values()) {
            Restaurant restaurantStore = vote.getRestaurant();
            if (restaurantStore.equals(restaurant)){
                voteCollection.add(vote);
            }
        }

        return voteCollection;
    }


    public Vote voteOfPerson(Person person) {
        return null;
    }


    public Vote voteOfId(long id) {
        Vote vote = this.store.get(id);
        return vote;
    }


    public void remove(Vote vote) {
        this.store.remove(vote.getId());
    }


    public void removeAll() {
        store.clear();
    }


    public void save(Vote vote) {
        this.store.put(vote.getId(), vote);
    }

    public Collection<Vote> allVotes() {
        Collection<Vote> voteCollection = new ArrayList();
        for (Vote vote : store.values()) {
            voteCollection.add(vote);
        }
        return voteCollection;
    }



}
