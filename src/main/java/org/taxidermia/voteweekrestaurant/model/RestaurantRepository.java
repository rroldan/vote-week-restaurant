package org.taxidermia.voteweekrestaurant.model;

import java.util.Collection;

/**
 * Interfaz Repositorio de Restaurantes
 */
public interface RestaurantRepository {

    public long nextIdentity();
    public Collection<Restaurant> allRestaurant();
    public Restaurant restaurantOfId(long id);
    public void remove(Restaurant restaurant);
    public void removeAll();
    public void save(Restaurant restaurant);
}
