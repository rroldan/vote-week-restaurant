package org.taxidermia.voteweekrestaurant.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Implementacion Repositorio Restaurantes
 */
public class MemoryRestaurantRepository implements RestaurantRepository {

    private Map<Long,Restaurant> store;

    public MemoryRestaurantRepository() {

        this.store = new HashMap<Long,Restaurant>();
    }


    public long nextIdentity() {
        UUID uid = UUID.randomUUID();
        return  Math.abs(uid.getLeastSignificantBits());
    }


    public Collection<Restaurant> allRestaurant() {
        return this.store.values();
    }


    public Restaurant restaurantOfId(long id) {
        Restaurant restaurant = this.store.get(id);
        return restaurant;
    }

    public void remove(Restaurant restaurant) {

        this.store.remove(restaurant.getId());
    }


    public void removeAll() {
        store.clear();

    }

    public void save(Restaurant restaurant) {
        this.store.put(restaurant.getId(), restaurant);
    }

}
