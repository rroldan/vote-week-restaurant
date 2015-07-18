@VotarRestauranteSemanal
Feature: Votar a un Restaurante

  Scenario: un usuario vota un restaurante

    Given Yo soy un usuario que puede votar
    And   Un restaurante con el contador de votos a 0
    When  Yo voto a un restaurante
    Then  El restaurante al que he votado incrementa en uno su contador de votos


  Scenario: No es posible que un usuario vote dos veces a un mismo restaurante

    Given Yo soy un usuario que puede votar
    And   Yo ya he votado a un restaurante contador de votos a 1
    When  Yo voto una segunda vez al mismo restaurante
    Then  El restaurante no incrementa el contador de votos