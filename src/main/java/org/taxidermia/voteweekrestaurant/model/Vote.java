package org.taxidermia.voteweekrestaurant.model;

/**
 * Voto de una persona a un restaurante
 */
public class Vote extends Entity {

    private final long id;
    private final Person person;
    private final Restaurant restaurant;

    public Vote(final long newId, final Person newPerson, final Restaurant newRestaurant){
        this.assertArgumentRange(newId,1,Long.MAX_VALUE,"id out of range");
        this.assertArgumentNotNull(newPerson,"person is not null");
        this.assertArgumentNotNull(newRestaurant,"restaurant is not null");
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
    public boolean equals(Object anObject) {
        boolean equalObjects = false;
        if (anObject != null && this.getClass() == anObject.getClass()) {
            if (anObject.hashCode() == this.hashCode()) {
                equalObjects = true;
            }
        }
        return equalObjects;
    }

    @Override
    public int hashCode() {
        int hashCodeValue =
                + (1456 * 4)
                        + String.valueOf(getId()).hashCode();

        return hashCodeValue;
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
