package org.taxidermia.voteweekrestaurant.application;

import org.apache.log4j.Logger;
import org.taxidermia.voteweekrestaurant.model.Vote;
import org.taxidermia.voteweekrestaurant.model.VoteRepository;


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
        logger.info("vote()" + vote.toString() );
        voteRepository.save(vote);

    }





}
