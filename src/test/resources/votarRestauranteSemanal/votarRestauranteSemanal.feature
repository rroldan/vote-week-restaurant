@VotarRestauranteSemanal
Feature: Un grupo de personas quiere ir a comer una vez a la semana a un restaurante
  que se debe de elegir de una lista de restaurantes.
  Se precisa un sistema de votación para que una persona vote a un restaurante y una vez finalizada la votación
  se sepa el restaurante más votado

  Scenario: Una persona vota un restaurante de una lista de Restaurantes

    Given Yo soy una persona con nombre "Pepe" que puede votar
    And   Hay un restaurante en la lista llamado "El Rincon" con el contador de votos a 0
    When  Yo voto a un restaurante
    Then  El restaurante al que he votado incrementa en uno su contador de votos


  Scenario: No es posible que un usuario vote dos veces a un mismo restaurante

    Given Yo soy una persona que puede votar
    And   Yo ya he votado a un restaurante con su contador de votos a 1
    When  Yo voto una segunda vez al mismo restaurante
    Then  El sistema informa que no se puede votar dos veces
