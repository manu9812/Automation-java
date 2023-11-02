Feature:creacion de customer
  Yo cliente de la web demoGuro99
  Quiero crear un customer
  Para agregar una tarifa al customer

  @test
  Scenario: 1. Revisar Telecom Project
    Given Que la pagina demo Guru esta diponible
    When Doy click en Telecom Project
    And Doy click en agregar customer
    And Ingreso los datos para agregar el customer
    And capturo el Id del customer
    And Agrego plan tarifario al customer
    And valido el nombre del cliente
    And Valido el estado del cliente
    And Selecciono La tarifa
    Then regreso a la pagina principal