Feature:  Carrito de compras con tarjeta.
  Yo cliente de la web demoGuro99
  Quiero comprar productos por medio de la web con tarjeta de credito
  Para agilizar mi tiempo de compras.


  Scenario: 01 comprar con un solo producto
    Given que la pagina esta disponible
    When doy click en Generate Card Number
    #And capturo datos de tarjeta
    #And registro una compra de  3 productos
   # And ingreso datos de tarjeta
   # And capturo datos de la orden


  Scenario Outline: : 02 comprar con varios producto
    Given que la pagina esta disponible
    When doy click en Generate Card Number
    And capturo datos de tarjeta
    # And registro una compra de 1 productos
    And ingreso datos de tarjeta
    And capturo datos de la orden
    Examples:
      | cant |
      | 1    |
      | 4    |
      | 9    |
      | 10   |
