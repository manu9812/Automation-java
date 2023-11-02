Feature: Lista de usuarios 

Scenario: Listar los usuarios
    Given url 'https://jsonplaceholder.typicode.com'
    And path 'users'
    When method  get
    Then status 200
    
