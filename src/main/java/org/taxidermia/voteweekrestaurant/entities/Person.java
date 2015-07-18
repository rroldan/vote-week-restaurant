package org.taxidermia.voteweekrestaurant.entities;

/**
 * Entidad Usuario
 */
public class Person {
    /**
     *  Nombre Corto
     */
    private final String nickName;

    /**
     * Constructor
     * @param newNickName Nombre corto
     */
    public Person(
            final String newNickName){
        this.nickName = newNickName;
    }

    public String getNickName(){
        return this.nickName;
    }


    /**
     * Clase Builder
     */
    public static class Builder
    {
        private String  nestedNickName;

        public Builder(
                final String newNickName)
        {
            this.nestedNickName = newNickName;

        }

        public Builder nickName(final String newNickName)
        {
            this.nestedNickName = newNickName;
            return this;
        }


        public Person build()
        {
            return new Person(nestedNickName);
        }

    }

}