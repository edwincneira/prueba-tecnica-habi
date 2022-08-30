package com.demoqa.stepdefinitions;

import com.demoqa.interactions.NavigateAlerts;
import com.demoqa.tasks.windows.WindowConfirm;
import com.demoqa.tasks.windows.WindowPrompt;
import com.demoqa.tasks.windows.WindowWaitFive;
import com.demoqa.tasks.windows.WindowAlert;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import static com.demoqa.utils.Util.whatDoAcceptOrCancel;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class WindowsStepDefinitions {

    @Entonces("^El decide ingresar a la seccion Alerts$")
    public void navigateToSectionAlerts() {
        theActorInTheSpotlight().attemptsTo(NavigateAlerts.nav());
    }

    @Y("^El decide probar la ventana Click Button to see alert y oprimir Aceptar$")
    public void navigateToSectionClickButtonToSeeAlerts() {
        theActorInTheSpotlight().attemptsTo(WindowAlert.event());
    }
    @Y("^El decide probar la ventana On button click, alert will appear after 5 seconds y espera (.*) segundos y oprime el boton aceptar$")
    public void navigateToSectionClickAlertAppearAfterFiveSecond(int wait) {
        theActorInTheSpotlight().attemptsTo(WindowWaitFive.event(wait));
    }
    @Y("^El decide probar la ventana On button click, confirm box will appear y oprimir el boton (.*)$")
    public void navigateToSectionOnButtonConfirmBoxAppear(String action) {
        theActorInTheSpotlight().attemptsTo(WindowConfirm.event(whatDoAcceptOrCancel(action)));
    }

    @Y("^El decide probar la ventana On button click, prompt box will appear y escribir el mensaje (.*) y oprime el boton (.*)$")
    public void navigateToSectionOnButtonPromptBoxAppear(String message, String action) {
        theActorInTheSpotlight().attemptsTo(WindowPrompt.event(message, whatDoAcceptOrCancel(action)));
    }

}
