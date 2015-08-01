package org.taxidermia.voteweekrestaurant.application;

import org.apache.log4j.Logger;
import org.taxidermia.voteweekrestaurant.model.Person;
import org.taxidermia.voteweekrestaurant.model.PersonRepository;
import org.taxidermia.voteweekrestaurant.model.Restaurant;
import org.taxidermia.voteweekrestaurant.model.RestaurantRepository;

/**
 * implementacion Servicio Restaurantes
 */
public class RestaurantService {

    static Logger logger = Logger.getLogger(RestaurantService.class);

    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository newRestaurantRepository){
        this.restaurantRepository = newRestaurantRepository;
    }

    public void addRestaurantToList(Restaurant restaurant){
        logger.debug("addRestaurantToList()" + restaurant.toString());
        this.restaurantRepository.save(restaurant);
    }

}
