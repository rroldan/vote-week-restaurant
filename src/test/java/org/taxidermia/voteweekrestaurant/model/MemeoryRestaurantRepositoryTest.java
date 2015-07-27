package org.taxidermia.voteweekrestaurant.model;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class MemeoryRestaurantRepositoryTest {

    DomainRegistry domainRegistry = new DomainRegistry();

    @Test
    public void testRestaurantRepositorySaveAndFindOneCorrect(){
        RestaurantRepository restaurantRepository = domainRegistry.restaurantRepository();
        Restaurant restauranFixture = RestaurantTest.getRestauranFixture(restaurantRepository.nextIdentity(), "name");

        restaurantRepository.save(restauranFixture);
        Restaurant restaurant = restaurantRepository.restaurantOfId(restauranFixture.getId());

        assertNotNull(restauranFixture);
        assertEquals(restauranFixture.getId(), restauranFixture.getId());
        assertEquals(restauranFixture.getName(), restauranFixture.getName());

    }

    @Test
    public void testRestaurantRepositoryNextIdentity() {
        long id=0;
        RestaurantRepository restaurantRepository = domainRegistry.restaurantRepository();
        long idNextIdentity = restaurantRepository.nextIdentity();
        assertNotEquals(id, restaurantRepository.nextIdentity());
        assertNotEquals(idNextIdentity, restaurantRepository.nextIdentity());
    }

    @Test
    public void testRestaurantRepositoryRemove(){
        RestaurantRepository restaurantRepository = domainRegistry.restaurantRepository();
        Restaurant restaurantFixture = RestaurantTest.getRestauranFixture(restaurantRepository.nextIdentity(), "name");

        restaurantRepository.save(restaurantFixture);
        restaurantRepository.remove(restaurantFixture);
        Restaurant restaurant = restaurantRepository.restaurantOfId(restaurantFixture.getId());
        assertNull(restaurant);
    }

    @Test
    public  void testRestaurantRepositoryAllRestaurant(){

        RestaurantRepository restaurantRepository = domainRegistry.restaurantRepository();
        Restaurant restaurantFixture = RestaurantTest.getRestauranFixture(restaurantRepository.nextIdentity(), "name");
        restaurantRepository.save(restaurantFixture);
        Collection<Restaurant> restaurantList = restaurantRepository.allRestaurant();
        assertEquals(1, restaurantList.size());
        Restaurant restaurant = restaurantList.iterator().next();

        assertNotNull(restaurant);
        assertEquals(restaurantFixture.getId(), restaurant.getId());
        assertEquals(restaurantFixture.getName(), restaurant.getName());

    }






}
