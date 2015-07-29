package org.taxidermia.voteweekrestaurant.model;

import java.util.Collection;

/**
 * Interfaz Reposiorio Personas
 */
public interface PersonRepository {

    public long nextIdentity();
    public Collection<Person> allPerson();
    public Person personOfId(long id);
    public void remove(Person person);
    public void removeAll();
    public void save(Person person);

}
