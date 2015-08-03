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

    /**
     * URL Restaurante
     */
    private final String url;

    /**
     * Telefono
     */
    private final String phone;

    public Restaurant (final long newId,final String newName, String newUrl, String newPhone){
        this.assertArgumentRange(newId,1,Long.MAX_VALUE,"id out of range");
        this.assertArgumentNotEmpty(newName,"name is not null or empty");
        this.id = newId;
        this.name = newName;
        this.url = newUrl;
        this.phone = newPhone;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl(){
        return this.url;
    }

    public String getPhone(){
        return this.phone;
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
        return "Restaurant[id=" + getId() + ", " + "name=" + getName() + ", "+ "url=" + getUrl() +", " + "phone=" + getPhone() + "]";
    }

    /**
     *  Clase Builder
    */
    public static class Builder
    {
        private long nestedId;
        private String nestedName;
        private String nestedUrl;
        private String nestedPhone;


        public Builder id(final long newId){
            this.nestedId = newId;
            return this;
        }

        public Builder name(final String newName){
            this.nestedName = newName;
            return this;
        }

        public Builder url(final String newUrl){
            this.nestedUrl = newUrl;
            return this;
        }

        public Builder phone(final String newPhone){
            this.nestedPhone = newPhone;
            return this;
        }


        public Restaurant build() {
            return new Restaurant(nestedId,nestedName,nestedUrl,nestedPhone);
        }
    }
    
}
