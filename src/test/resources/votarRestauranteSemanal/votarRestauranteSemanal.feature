@VotarRestauranteSemanal
Feature: Votar a un Restaurante

  Scenario: un usuario vota un restaurante

    Given Yo soy un usuario que puede votar
    And   Un restaurante con el contador de votos a 0
    When  Yo voto a un restaurante
    Then  El restaurante al que he votado incrementa en uno su contador de votos