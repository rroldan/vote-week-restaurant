package org.taxidermia.voteweekrestaurant.model;

/**
 * Voto de una persona a un restaurante
 */
public class Vote {

    private final long id;
    private final Person person;
    private final Restaurant restaurant;

    public Vote(final long newId, final Person newPerson, final Restaurant newRestaurant){
        this.id = newId;
        this.person = newPerson;
        this.restaurant = newRestaurant;
    }

    public long getId(){
        return this.id;
    }

    public Person getPerson(){
        return this.person;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    @Override
    public String toString()
    {
        return "Vote[" + "id=" + getId() + ", "
                        + this.person.toString() + ", "
                        + this.restaurant.toString() + "]";
    }

    /**
     *  Clase Builder
     */
    public static class Builder
    {
        private long nestedId;
        private Person nestedPerson;
        private Restaurant nestedRestaurant;


    public Builder id(final long newId){
        this.nestedId = newId;
        return this;
    }

    public Builder person(final Person newPerson){
        this.nestedPerson = newPerson;
        return this;
    }

    public Builder restaurant(final Restaurant newRestaurant){
        this.nestedRestaurant = newRestaurant;
        return this;
    }

    public Vote build() {
        return new Vote(nestedId,nestedPerson,nestedRestaurant);
    }

    }



}
