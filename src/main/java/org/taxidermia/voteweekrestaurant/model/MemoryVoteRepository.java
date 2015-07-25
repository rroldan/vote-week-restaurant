package org.taxidermia.voteweekrestaurant.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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


    public Collection<Vote> allVotesOfRestaurant(Restaurant Restaurant) {
        return null;
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


    public void removeAll(Collection<Vote> voteCollection) {
        for (Vote vote : voteCollection) {
            this.remove(vote);
        }

    }


    public void save(Vote vote) {
        this.store.put(vote.getId(), vote);
    }


}
