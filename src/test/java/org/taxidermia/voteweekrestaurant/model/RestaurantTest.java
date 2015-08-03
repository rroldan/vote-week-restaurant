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
        String url = "http://localhost";
        String phone = "091";
        Restaurant restaurant = getRestauranFixture(id, name, url, phone);

        assertEquals(id, restaurant.getId());
        assertEquals(name,restaurant.getName());
        assertEquals(url,restaurant.getUrl());
        assertEquals(phone,restaurant.getPhone());

    }


    @Test
    public void testNewRestaurantToString() {
        String restaurantToString = "Restaurant[id=1, name=name, url=http://localhost, phone=091]";
        long id = 1l;
        String name = "name";
        String url = "http://localhost";
        String phone = "091";
        Restaurant restaurant = getRestauranFixture(id, name, url, phone);


        assertEquals(restaurantToString, restaurant.toString());

    }

    @Test(expected=IllegalArgumentException.class)
    public void testPersonNickameNullException() {
        Restaurant restaurant = getRestauranFixture(1, null,"http://localhost" ,"091" );
    }

    @Test(expected=IllegalArgumentException.class)
    public void testPersonIdOutOfRangeException() {
        Restaurant restaurant = getRestauranFixture(0, "nickname","http://localhost" ,"091");
    }


    @Test
    public void testRestaurantHash() {
        long id = 1;
        String name = "name";
        String url = "http://localhost";
        String phone = "091";
        Restaurant restaurant = getRestauranFixture(id,name, url,phone );
        Restaurant restaurant2 = getRestauranFixture(id,name, url,phone );
        assertEquals(restaurant.hashCode(), restaurant2.hashCode());

    }

    @Test
    public void testRestaurantEquals() {
        long id = 1;
        String name = "name";
        String url = "http://localhost";
        String phone = "091";
        Restaurant restaurant = getRestauranFixture(id, name,url,phone);
        Restaurant restaurant2 = getRestauranFixture(id, name,url,phone);
        assertTrue(restaurant.equals(restaurant2));

    }



    public static Restaurant getRestauranFixture(long id, String name, String url, String phone){
        Restaurant restaurant = new Restaurant.Builder().id(id).name(name).url(url).phone(phone).build();
        return restaurant;
    }
}
