# language: es
  @REGRESION
Característica: Booking de viajes Peru Rail
  Para reservar un viaje en tren
  Como usuario anónimo
  Debería de poder comprarla online y visualizar la confirmación

  Antecedentes: El usuario no necesita registrarse en el sistema
    Dado que Davis ingresa a la web de Peru Rail para reservar su viaje en tren

  @BELMOND
  Esquema del escenario: Reserva de servicio de tren BELMOND ANDEAN EXPLORER
    Cuando Davis selecciona el tipo de viaje: "<TIPO DE VIAJE>"
    Y después él selecciona el destino: "<DESTINO>"
    E indicará la ruta de viaje: "<RUTA>"
    Y luego él escogera el tren de preferencia: "<TREN>"
    Pero deberá de indicar la fecha de salida: "<FECHA>"
    * luego enviará la consulta
    Y posteriormente Davis escogerá su Cabina
    E ingresará sus datos personales
    Entonces Davis deberá de visualizar su resumen de compra
    Ejemplos:
      | TIPO DE VIAJE | DESTINO | RUTA                    | TREN                             | FECHA     |
      | Solo Ida      | Cusco   | Puno > Cusco            | Andean Explorer, A Belmond Train | 30-6-2022 |
      | Solo Ida      | Cusco   | Arequipa > Puno > Cusco | Andean Explorer, A Belmond Train | 30-6-2022 |

  @EXPEDITION
  Esquema del escenario: Reserva de servicio de tren EXPEDITION
    Cuando Davis selecciona el tipo de viaje: "<TIPO DE VIAJE>"
    Y después él selecciona el destino: "<DESTINO>"
    E indicará la ruta de viaje: "<RUTA>"
    Pero deberá de indicar la fecha de salida: "<FECHA>"
    * luego enviará la consulta
    Y él seleccionará su tramo de preferencia
    E ingresará sus datos personales
    Entonces Davis deberá de visualizar su resumen de compra
    Ejemplos:
      | TIPO DE VIAJE | DESTINO      | RUTA                 | FECHA     |
      | Ida y Vuelta  | Machu Picchu | Cusco > Machu Picchu | 30-5-2022 |
      | Solo Ida      | Machu Picchu | Cusco > Machu Picchu | 30-5-2022 |
