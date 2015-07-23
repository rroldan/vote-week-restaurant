package org.taxidermia.voteweekrestaurant.model;

/**
 * Entidad Restaurante
 */
public class Restaurant {
    /**
     * Identificador
     */
    private final long id;

    /**
     * Nombre
     */
    private final String name;

    public Restaurant (final long newId,final String newName){
        this.id = newId;
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

    public long getId() {return this.id; }

    @Override
    public String toString() {
        return "Restaurant[id=" + getId() + ", " + "name=" + getName() + "]";
    }

    /**
     *  Clase Builder
    */
    public static class Builder
    {
        private long nestedId;
        private String nestedName;


        public Builder id(final long newId){
            this.nestedId = newId;
            return this;
        }

        public Builder name(final String newName){
            this.nestedName = newName;
            return this;
        }

        public Restaurant build() {
            return new Restaurant(nestedId,nestedName);
        }
    }
    
}
