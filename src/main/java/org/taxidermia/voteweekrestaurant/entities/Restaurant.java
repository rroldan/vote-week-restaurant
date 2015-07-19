package org.taxidermia.voteweekrestaurant.entities;

/**
 * Entidad Restaurante
 */
public class Restaurant {

    /**
     * Nombre
     */
    private final String name;

    public Restaurant (final String newName){
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Restaurant: Name: " + this.name;
    }

    /**
     *  Clase Builder
    */
    public static class Builder
    {
        private String nestedName;

        public Builder(final String newName){
            this.nestedName = newName;
        }


        public Builder name(final String newName){
            this.nestedName = newName;
            return this;
        }

        public Restaurant build() {
            return new Restaurant(nestedName);
        }
    }
    
}
