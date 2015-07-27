package votarRestauranteSemanal;

import org.taxidermia.voteweekrestaurant.application.PersonService;
import org.taxidermia.voteweekrestaurant.application.VoteService;
import org.taxidermia.voteweekrestaurant.model.DomainRegistry;
import org.taxidermia.voteweekrestaurant.model.Person;
import org.taxidermia.voteweekrestaurant.model.Restaurant;

/**
 * Created by richard on 25/7/15.
 */
public class VotarRestauranteSemanal {

    DomainRegistry domainRegitry = new DomainRegistry();

    PersonService personService = new PersonService(domainRegitry.personRepository());


    Person person;
    Restaurant restaurant;

    public void addPerson(String nickname){
        person = new Person.Builder().id(domainRegitry.personRepository().nextIdentity()).nickName(nickname).build();
        personService.addPersonToList(person);
    }

    public void addRestaurant(String name){
        restaurant = new Restaurant.Builder().id(domainRegitry.voteRepository().nextIdentity()).name(name).build();

    }




}
