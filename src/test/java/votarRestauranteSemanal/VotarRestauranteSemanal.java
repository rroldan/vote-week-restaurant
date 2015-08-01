package votarRestauranteSemanal;

import org.taxidermia.voteweekrestaurant.application.PersonService;
import org.taxidermia.voteweekrestaurant.application.RestaurantService;
import org.taxidermia.voteweekrestaurant.application.VoteService;
import org.taxidermia.voteweekrestaurant.model.DomainRegistry;
import org.taxidermia.voteweekrestaurant.model.Person;
import org.taxidermia.voteweekrestaurant.model.Restaurant;
import org.taxidermia.voteweekrestaurant.model.Vote;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class VotarRestauranteSemanal {

    DomainRegistry domainRegitry;

    PersonService personService;
    RestaurantService restaurantService;
    VoteService voteService;

    Person person;
    Restaurant restaurant;
    Vote vote;

    public void addPerson(String nickname){
        person = new Person.Builder().id(domainRegitry.personRepository().nextIdentity()).nickName(nickname).build();
        personService.addPersonToList(person);
    }

    public void addRestaurant(String name){
        restaurant = new Restaurant.Builder().id(domainRegitry.restaurantRepository().nextIdentity()).name(name).build();
        restaurantService.addRestaurantToList(restaurant);
    }


    public void vote(){
        vote = new Vote.Builder().id(domainRegitry.voteRepository().nextIdentity()).person(this.person).restaurant(this.restaurant).build();
        voteService.vote(vote);


    }


    public void verifyVote(){
        List<Vote> votes = voteService.votes(restaurant);
        Restaurant restaurantVote;
        Vote vote = votes.iterator().next();
        restaurantVote = vote.getRestaurant();
        assertEquals(restaurant.getId(), restaurantVote.getId());

    }

    public void init(){
         domainRegitry = new DomainRegistry();

         personService = new PersonService(domainRegitry.personRepository());
        restaurantService = new RestaurantService(domainRegitry.restaurantRepository());
       voteService = new VoteService(domainRegitry.voteRepository());
    }




}
