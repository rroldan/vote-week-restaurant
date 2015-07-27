package org.taxidermia.voteweekrestaurant.application;


import org.junit.Test;
import org.taxidermia.voteweekrestaurant.model.*;

import static org.junit.Assert.assertEquals;

public class RestaurantServiceTest {

    DomainRegistry domainRegistry = new DomainRegistry();

    RestaurantRepository restaurantRepository = domainRegistry.restaurantRepository();
    RestaurantService restaurantService = new RestaurantService(restaurantRepository);

    @Test
    public void addRestaurantToListOkTest(){

        long restaurantId = restaurantRepository.nextIdentity();
        Restaurant restaurantFixture =  RestaurantTest.getRestauranFixture(restaurantId, "name");

        restaurantService.addRestaurantToList(restaurantFixture);
        Restaurant restaurant = restaurantRepository.restaurantOfId(restaurantId);

        assertEquals(restaurantId, restaurant.getId());

    }



}
