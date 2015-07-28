package org.taxidermia.voteweekrestaurant.model;

/**
 * Entidad Usuario
 */
public class Person {

    /**
     * Identificador
     */
    private final long id;

    /**
     * Apodo o Nombre abreviado
     */
    private final String nickName;

    /**
     * Constructor
     * @param newId Identificador
     * @param newNickName Nombre Abreviado
     */
    public Person(final long newId, final String newNickName){
        this.id = newId;
        this.nickName = newNickName;
    }

    public long getId(){
        return this.id;
    }

    public String getNickName(){
        return this.nickName;
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
                + (2335 * 3)
                        + String.valueOf(getId()).hashCode();

        return hashCodeValue;
    }

    @Override
    public String toString()
    {
        return "Person[id=" + getId() +", " + "nickName=" + getNickName() +"]";
    }

    /**
     * Clase Builder
     */
    public static class Builder
    {
        private long nestedId;
        private String  nestedNickName;


        public Builder id(final long newId){
            this.nestedId = newId;
            return this;
        }

        public Builder nickName(final String newNickName)
        {
            this.nestedNickName = newNickName;
            return this;
        }


        public Person build()
        {
            return new Person(nestedId, nestedNickName);
        }

    }

}