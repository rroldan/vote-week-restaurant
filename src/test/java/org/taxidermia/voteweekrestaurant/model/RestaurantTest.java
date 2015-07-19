package org.taxidermia.voteweekrestaurant.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RestaurantTest {

    @Test
    public void testNewRestaurantSetName() {
        String name = "name";
        Restaurant restaurant = new Restaurant.Builder().name(name).build();
        assertEquals(name,restaurant.getName());

    }


    @Test
    public void testNewRestaurantToString() {
        String restaurantToString = "Restaurant: Name: name";
        String name = "name";
        Restaurant restaurant = new Restaurant.Builder().name(name).build();
        assertEquals(restaurantToString, restaurant.toString());

    }
}
