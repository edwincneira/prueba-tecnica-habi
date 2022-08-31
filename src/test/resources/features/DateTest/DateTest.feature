#language:es

Característica: Validar la adicion de cualquier fecha dentro de la seccion Select Date y Date and Time

  Esquema del escenario: Validar la seleccion de la fecha desde el año 1900 - 2100 en la pestaña Widgets -> Date Picker -> Select Date
    Dado El usuario navega en la aplicacion web
    Entonces El decide ingresar la fecha <date> en la seccion select date

    Ejemplos:
      | date        |
      | 01/25/1900  |
      | 02/09/1999  |
      | 03/01/2022  |
      | 04/25/2023  |
      | 05/31/2100  |
      | 06/20/1920  |
      | 07/01/2008  |
      | 08/15/2003  |
      | 09/25/2099  |
      | 10/13/2000  |
      | 11/30/2030  |
      | 12/25/2100  |

  Esquema del escenario: Validar la seleccion de la fecha desde el año 1900 - 2100 en la pestaña Widgets -> Date Picker -> Date And Time
    Dado El usuario navega en la aplicacion web
    Entonces El decide ingresar la fecha <date> en la seccion date and time

    Ejemplos:
      | date              |
      | 02/25/1999 04:00  |
      | 02/09/1999 04:00  |
      | 03/01/2022 08:15  |