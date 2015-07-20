package org.taxidermia.voteweekrestaurant.model;

import java.util.Collection;

/**
 * Interfaz Repositorio de Votos
 */
public interface VoteRepository {
    public String nextIdentity();
    public Collection<Vote> allVotesOfRestaurant(Restaurant Restaurant);
    public Vote voteOfPerson(Person person);
    public Vote voteOfId(String id);
    public void remove(Vote vote);
    public void removeAll(Collection<Vote> voteCollection);
    public void save(Vote vote);
    public void saveAll(Collection<Vote> voteCollection);
}
