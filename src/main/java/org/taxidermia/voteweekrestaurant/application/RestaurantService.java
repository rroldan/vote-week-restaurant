package org.taxidermia.voteweekrestaurant.application;

import org.apache.log4j.Logger;
import org.taxidermia.voteweekrestaurant.model.Person;
import org.taxidermia.voteweekrestaurant.model.PersonRepository;
import org.taxidermia.voteweekrestaurant.model.Restaurant;
import org.taxidermia.voteweekrestaurant.model.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

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

    public List<Restaurant> restaurantList(){
        List<Restaurant> restaurantList = new ArrayList();
        for (Restaurant restaurant : this.restaurantRepository.allRestaurant()){
            restaurantList.add(restaurant);
        }

        logger.debug("persons() " + restaurantList);
        return restaurantList;

    }

    public Restaurant getRestaurant(Long restaurantId){
        logger.debug("getRestaurnt() " + "id=" + restaurantId);
        Restaurant restauarnt = this.restaurantRepository.restaurantOfId(restaurantId);
        logger.debug("return getRestaurant() " + restauarnt);
        return restauarnt;

    }


}
