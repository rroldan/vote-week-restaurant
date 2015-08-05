package org.taxidermia.voteweekrestaurant.application;

import org.apache.log4j.Logger;
import org.taxidermia.voteweekrestaurant.model.Person;
import org.taxidermia.voteweekrestaurant.model.Restaurant;
import org.taxidermia.voteweekrestaurant.model.Vote;
import org.taxidermia.voteweekrestaurant.model.VoteRepository;

import java.util.ArrayList;
import java.util.List;


/**
 * implementeacion la logica de Voto
 */
public class VoteService {
    static Logger logger = Logger.getLogger(VoteService.class);

    private VoteRepository voteRepository;

    public VoteService(VoteRepository newVoteRepository){
        this.voteRepository = newVoteRepository;
    }


    /**
     * Metodo que guarda el voto de una persona a un restaurante
     * @param vote Voto realizado
     */
    public void vote(Vote vote){
        logger.debug("vote()" + vote.toString());
        voteRepository.save(vote);

    }

    /**
     * Método que obtiene los votos realizados a un restaurante
     *
     */
    public List<Vote> votes(Restaurant restaurant){
        logger.debug("votes()" + restaurant.toString());
        return (List<Vote>) voteRepository.allVotesOfRestaurant(restaurant);

    }

    public List<Vote> voteList(){
        List<Vote> voteList = new ArrayList();
        for (Vote vote : this.voteRepository.allVotes()){
            voteList.add(vote);
        }

        logger.debug("votes() " + voteList);
        return voteList;

    }



}
