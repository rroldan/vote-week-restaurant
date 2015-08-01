package org.taxidermia.voteweekrestaurant.model;

/**
 * Entidad Restaurante
 */
public class Restaurant extends Entity {
    /**
     * Identificador
     */
    private final long id;

    /**
     * Nombre
     */
    private final String name;

    public Restaurant (final long newId,final String newName){
        this.assertArgumentRange(newId,1,Long.MAX_VALUE,"id out of range");
        this.assertArgumentNotEmpty(newName,"name is not null or empty");
        this.id = newId;
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

    public long getId() {return this.id; }

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
                + (2945 * 2)
                        + String.valueOf(getId()).hashCode();

        return hashCodeValue;
    }

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
