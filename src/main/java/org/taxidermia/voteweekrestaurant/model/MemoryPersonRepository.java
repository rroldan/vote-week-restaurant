package org.taxidermia.voteweekrestaurant.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Implementacion Repositorio Personas
 */
public class MemoryPersonRepository implements PersonRepository {

        private Map<Long,Person> store;

        public MemoryPersonRepository() {
            this.store = new HashMap<Long,Person>();
        }


    public long nextIdentity() {
        UUID uid = UUID.randomUUID();
        return  Math.abs(uid.getLeastSignificantBits());
    }


    public Collection<Person> allPerson() {
        return this.store.values();
    }


    public Person personOfId(long id) {
        Person person = this.store.get(id);
        return person;
    }


    public void remove(Person person) {
        this.store.remove(person.getId());
    }


    public void removeAll() {
        store.clear();

    }


    public void save(Person person) {
        this.store.put(person.getId(), person);
    }


}
