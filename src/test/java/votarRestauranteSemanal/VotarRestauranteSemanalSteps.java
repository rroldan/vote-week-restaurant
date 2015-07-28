package votarRestauranteSemanal;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by richard on 18/7/15.
 */
public class VotarRestauranteSemanalSteps {

    VotarRestauranteSemanal votarRestauranteSemanal = new VotarRestauranteSemanal();

    @Given("^Yo soy una persona con nombre \"(.*?)\" que puede votar$")
    public void yo_soy_una_persona_con_nombre_que_puede_votar(String name) throws Throwable {
        votarRestauranteSemanal.addPerson(name);
    }

    @Given("^Hay un restaurante en la lista llamado \"(.*?)\" $")
    public void hay_un_restaurante_en_la_lista(String name) throws Throwable {
        votarRestauranteSemanal.addRestaurant(name);
    }

    @When("^Yo voto al restaurante$")
    public void yo_voto_a_un_restaurante() throws Throwable {
        votarRestauranteSemanal.vote();
    }

    @Then("^El restaurante al que he votado tiene un voto asociado$")
    public void el_restaurante_al_que_he_votado_incrementa_en_uno_su_contador_de_votos() throws Throwable {

    }

    @Given("^Yo soy una persona que puede votar$")
    public void yo_soy_una_persona_que_puede_votar() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^Yo ya he votado a un restaurante con su contador de votos a (\\d+)$")
    public void yo_ya_he_votado_a_un_restaurante_con_su_contador_de_votos_a(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Yo voto una segunda vez al mismo restaurante$")
    public void yo_voto_una_segunda_vez_al_mismo_restaurante() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^El sistema informa que no se puede votar dos veces$")
    public void el_sistema_informa_que_no_se_puede_votar_dos_veces() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
