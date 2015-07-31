package org.taxidermia.voteweekrestaurant.model;

import java.util.Collection;

/**
 * Interfaz Repositorio de Votos
 */
public interface VoteRepository {
    public long nextIdentity();
    public Collection<Vote> allVotesOfRestaurant(Restaurant Restaurant);
    public Vote voteOfPerson(Person person);
    public Vote voteOfId(long id);
    public void remove(Vote vote);
    public void removeAll();
    public void save(Vote vote);
    public Collection<Vote>  allVotes();

}
