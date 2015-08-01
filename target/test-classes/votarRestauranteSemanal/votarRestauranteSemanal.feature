@VotarRestauranteSemanal
Feature: Un grupo de personas quiere ir a comer una vez a la semana a un restaurante
  que se debe de elegir de una lista de restaurantes.
  Se precisa un sistema de votación para que una persona vote a un restaurante y una vez finalizada la votación
  se sepa el restaurante más votado

  Scenario: Una persona vota un restaurante de una lista de Restaurantes

    Given Yo soy una persona con nombre "Pepe" que puede votar
    And   Hay un restaurante en la lista llamado "La Casona"
    When  Yo voto al restaurante
    Then  El restaurante al que he votado tiene un voto asociado


  Scenario: No es posible que un usuario vote dos veces a un mismo restaurante

    Given Yo soy una persona con nombre "Pepe" que puede votar
    And   Hay un restaurante en la lista llamado "La Casona"
    And   Yo voto al restaurante
    When  Yo voto una segunda vez al mismo restaurante
    Then  El sistema informa que no se puede votar dos veces
