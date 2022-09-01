#language:es

Característica: Validar las 4 ventanas alert de la seccion Alerts, Frame & Windows -> Alerts

  Escenario: Validar las 4 ventanas
    Dado El usuario navega en la aplicacion web
    Entonces El decide ingresar a la seccion Alerts
    Y El decide probar la ventana Click Button to see alert y oprimir Aceptar
    Y El decide probar la ventana On button click, alert will appear after 5 seconds y espera 6 segundos y oprime el boton aceptar
    Y El decide probar la ventana On button click, confirm box will appear y oprimir el boton aceptar
    Y El decide probar la ventana On button click, confirm box will appear y oprimir el boton cancelar
    Y El decide probar la ventana On button click, prompt box will appear y escribir el mensaje Hola Mundo Feliz y oprime el boton aceptar
    Y El decide probar la ventana On button click, prompt box will appear y escribir el mensaje Hola Mundo Feliz y oprime el boton cancelar