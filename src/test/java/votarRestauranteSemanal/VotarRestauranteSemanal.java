package votarRestauranteSemanal;

import org.taxidermia.voteweekrestaurant.application.PersonService;
import org.taxidermia.voteweekrestaurant.application.RestaurantService;
import org.taxidermia.voteweekrestaurant.application.VoteService;
import org.taxidermia.voteweekrestaurant.model.DomainRegistry;
import org.taxidermia.voteweekrestaurant.model.Person;
import org.taxidermia.voteweekrestaurant.model.Restaurant;
import org.taxidermia.voteweekrestaurant.model.Vote;

public class VotarRestauranteSemanal {

    DomainRegistry domainRegitry = new DomainRegistry();

    PersonService personService = new PersonService(domainRegitry.personRepository());
    RestaurantService restaurantService = new RestaurantService(domainRegitry.restaurantRepository());
    VoteService voteService = new VoteService(domainRegitry.voteRepository());

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

    }




}
