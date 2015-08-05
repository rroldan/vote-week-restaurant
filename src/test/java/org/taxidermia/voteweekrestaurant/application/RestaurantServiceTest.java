package org.taxidermia.voteweekrestaurant.application;


import org.junit.Test;
import org.taxidermia.voteweekrestaurant.model.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RestaurantServiceTest {



    @Test
    public void addRestaurantToListOkTest(){

        DomainRegistry domainRegistry = new DomainRegistry();

        RestaurantRepository restaurantRepository = domainRegistry.restaurantRepository();
        RestaurantService restaurantService = new RestaurantService(restaurantRepository);

        long restaurantId = restaurantRepository.nextIdentity();
        Restaurant restaurantFixture =  RestaurantTest.getRestauranFixture(restaurantId, "name", "http://localhost" ,"091");

        restaurantService.addRestaurantToList(restaurantFixture);
        Restaurant restaurant = restaurantRepository.restaurantOfId(restaurantId);

        assertEquals(restaurantId, restaurant.getId());

    }

    @Test
    public void testListRestaurantsOk(){

        DomainRegistry domainRegistry = new DomainRegistry();

        RestaurantRepository restaurantRepository = domainRegistry.restaurantRepository();
        RestaurantService restaurantService = new RestaurantService(restaurantRepository);


        long restaurantId = restaurantRepository.nextIdentity();
        Restaurant restaurantFixture =  RestaurantTest.getRestauranFixture(restaurantId, "name", "http://localhost", "091");

        restaurantService.addRestaurantToList(restaurantFixture);

        List<Restaurant> restaurantList = restaurantService.restaurantList();
        Restaurant restaurant = restaurantList.iterator().next();

        assertEquals(restaurantId, restaurant.getId());


    }

    @Test
    public void testGetRestaurantOk(){
        DomainRegistry domainRegistry = new DomainRegistry();

        RestaurantRepository restaurantRepository = domainRegistry.restaurantRepository();
        RestaurantService restaurantService = new RestaurantService(restaurantRepository);

        long restaurantId = restaurantRepository.nextIdentity();
        Restaurant restaurantFixture =  RestaurantTest.getRestauranFixture(restaurantId, "name", "http://localhost", "091");

        restaurantService.addRestaurantToList(restaurantFixture);
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
        assertEquals(restaurantId, restaurant.getId());

    }

    @Test
    public void testGetRestaurantNull(){
        DomainRegistry  domainRegistry = new DomainRegistry();

        RestaurantRepository restaurantRepository = domainRegistry.restaurantRepository();
        RestaurantService restaurantService = new RestaurantService(restaurantRepository);

        long restaurantId = restaurantRepository.nextIdentity();
        Restaurant restaurantFixture =  RestaurantTest.getRestauranFixture(restaurantId, "name", "http://localhost", "091");

        restaurantService.addRestaurantToList(restaurantFixture);
        Restaurant restaurant = restaurantService.getRestaurant(0l);
        assertNull(restaurant);

    }







}
