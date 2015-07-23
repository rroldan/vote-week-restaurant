package org.taxidermia.voteweekrestaurant.application;

import org.taxidermia.voteweekrestaurant.model.Vote;
import org.taxidermia.voteweekrestaurant.model.VoteRepository;

/**
 * implementeacion la logica de Voto
 */
public class VoteService {

    private VoteRepository voteRepository;

    public VoteService(VoteRepository newVoteRepository){
        this.voteRepository = newVoteRepository;

    }


    /**
     * Metodo que guarda el voto de una persona a un restaurante
     * @param vote Voto realizado
     */
    public void vote(Vote vote){
        voteRepository.save(vote);

    }





}
