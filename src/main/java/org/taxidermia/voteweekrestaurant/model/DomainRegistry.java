package org.taxidermia.voteweekrestaurant.model;

/**
 * Registra las entidades de Dominio
 */
public class DomainRegistry {

    VoteRepository voteRepository;
    PersonRepository personRepository;



    public DomainRegistry() {

        this.personRepository = new MemoryPersonRepository();
        this.voteRepository = new MemoryVoteRepository();

    }

    public VoteRepository voteRepository() {
        return this.voteRepository;
    }


    public PersonRepository personRepository() {
        return this.personRepository();
    }

}
