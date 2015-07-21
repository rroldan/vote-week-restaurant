package org.taxidermia.voteweekrestaurant.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementación Repositorio de Votos
 */
public class MemoryVoteRepository implements VoteRepository {

    private Map<Long,Vote> store;

    public MemoryVoteRepository() {
        this.store = new HashMap<Long,Vote>();
    }

    @Override
    public long nextIdentity() {
        return java.util.UUID.randomUUID().timestamp();
    }

    @Override
    public Collection<Vote> allVotesOfRestaurant(Restaurant Restaurant) {
        return null;
    }

    @Override
    public Vote voteOfPerson(Person person) {
        return null;
    }

    @Override
    public Vote voteOfId(long id) {
        Vote vote = this.store.get(id);
        return vote;
    }

    @Override
    public void remove(Vote vote) {

    }

    @Override
    public void removeAll(Collection<Vote> voteCollection) {

    }

    @Override
    public void save(Vote vote) {
        this.store.put(vote.getId(), vote);
    }

    @Override
    public void saveAll(Collection<Vote> voteCollection) {

    }
}
