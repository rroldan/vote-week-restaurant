package org.taxidermia.voteweekrestaurant.model;

/**
 * Voto de una persona a un restaurante
 */
public class Vote {

    private final String id;
    private final Person person;
    private final Restaurant restaurant;

    public Vote(final String newId, final Person newPerson, final Restaurant newRestaurant){
        this.id = newId;
        this.person = newPerson;
        this.restaurant = newRestaurant;
    }

    public String getId(){
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
        return "Vote[" + "id=" + this.id + ", "
                        + this.person.toString() + ", "
                        + this.restaurant.toString() + "]";
    }

    /**
     *  Clase Builder
     */
    public static class Builder
    {
        private String nestedId;
        private Person nestedPerson;
        private Restaurant nestedRestaurant;


    public Builder id(final String newId){
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
