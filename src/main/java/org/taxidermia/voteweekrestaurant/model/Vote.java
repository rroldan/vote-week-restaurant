package org.taxidermia.voteweekrestaurant.model;

/**
 * Voto de una persona a un restaurante
 */
public class Vote {

    private final Person person;
    private final Restaurant restaurant;

    public Vote(final Person newPerson, final Restaurant newRestaurant){
        this.person = newPerson;
        this.restaurant = newRestaurant;
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
        return "Voto: " + this.person.toString() + " , "
                        + this.restaurant.toString();
    }

    /**
     *  Clase Builder
     */
    public static class Builder
    {
        private Person nestedPerson;
        private Restaurant nestedRestaurant;



    public Builder person(final Person newPerson){
        this.nestedPerson = newPerson;
        return this;
    }

    public Builder restaurant(final Restaurant newRestaurant){
        this.nestedRestaurant = newRestaurant;
        return this;
    }

    public Vote build() {
        return new Vote(nestedPerson,nestedRestaurant);
    }

    }



}
