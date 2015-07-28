package org.taxidermia.voteweekrestaurant.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RestaurantTest {

    @Test
    public void testNewRestaurantBuild() {
        long id = 1l;
        String name = "name";
        Restaurant restaurant = new Restaurant.Builder().id(id).name(name).build();

        assertEquals(id, restaurant.getId());
        assertEquals(name,restaurant.getName());

    }


    @Test
    public void testNewRestaurantToString() {
        String restaurantToString = "Restaurant[id=1, name=name]";
        long id = 1l;
        String name = "name";
        Restaurant restaurant = new Restaurant.Builder().id(id).name(name).build();

        assertEquals(restaurantToString, restaurant.toString());

    }

    @Test
    public void testRestaurantHash() {
        long id = 1;
        String name = "name";
        Restaurant restaurant = getRestauranFixture(id,name);
        Restaurant restaurant2 = getRestauranFixture(id,name);
        assertEquals(restaurant.hashCode(), restaurant2.hashCode());

    }

    @Test
    public void testRestaurantEquals() {
        long id = 1;
        String name = "name";
        Restaurant restaurant = getRestauranFixture(id, name);
        Restaurant restaurant2 = getRestauranFixture(id, name);
        assertTrue(restaurant.equals(restaurant2));

    }



    public static Restaurant getRestauranFixture(long id, String name){
        Restaurant restaurant = new Restaurant.Builder().id(id).name(name).build();
        return restaurant;
    }
}
