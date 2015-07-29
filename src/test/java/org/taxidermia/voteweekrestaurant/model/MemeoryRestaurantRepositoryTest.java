package org.taxidermia.voteweekrestaurant.model;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class MemeoryRestaurantRepositoryTest {


    @Test
    public void testRestaurantRepositorySaveAndFindOneCorrect(){
        DomainRegistry domainRegistry = new DomainRegistry();
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
        DomainRegistry domainRegistry = new DomainRegistry();
        long id=0;
        RestaurantRepository restaurantRepository = domainRegistry.restaurantRepository();
        long idNextIdentity = restaurantRepository.nextIdentity();
        assertNotEquals(id, restaurantRepository.nextIdentity());
        assertNotEquals(idNextIdentity, restaurantRepository.nextIdentity());
    }

    @Test
    public void testRestaurantRepositoryRemove(){
        DomainRegistry domainRegistry = new DomainRegistry();
        RestaurantRepository restaurantRepository = domainRegistry.restaurantRepository();
        Restaurant restaurantFixture = RestaurantTest.getRestauranFixture(restaurantRepository.nextIdentity(), "name");

        restaurantRepository.save(restaurantFixture);
        restaurantRepository.remove(restaurantFixture);
        Restaurant restaurant = restaurantRepository.restaurantOfId(restaurantFixture.getId());
        assertNull(restaurant);
    }

    @Test
    public  void testRestaurantRepositoryAllRestaurant(){
        DomainRegistry domainRegistry = new DomainRegistry();
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

    @Test
    public void testRestaurantRepositoryRemoveAll(){
        DomainRegistry domainRegistry = new DomainRegistry();

        RestaurantRepository restaurantRepository = domainRegistry.restaurantRepository();

        Restaurant restaurantFixture = RestaurantTest.getRestauranFixture(restaurantRepository.nextIdentity(), "name");
        restaurantRepository.save(restaurantFixture);

        Restaurant restaurantFixture2 = RestaurantTest.getRestauranFixture(restaurantRepository.nextIdentity(), "name");
        restaurantRepository.save(restaurantFixture2);

        Collection<Restaurant> restaurantList = restaurantRepository.allRestaurant();
        assertEquals(2, restaurantList.size());

        restaurantRepository.removeAll();

        Collection<Restaurant> restaurantListRemove = restaurantRepository.allRestaurant();
        assertEquals(0, restaurantListRemove.size());

    }








}
