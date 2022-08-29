package com.demoqa.stepdefinitions;

import com.demoqa.interactions.NavigateAlerts;
import com.demoqa.tasks.windows.WindowConfirm;
import com.demoqa.tasks.windows.WindowPrompt;
import com.demoqa.tasks.windows.WindowWaitFive;
import com.demoqa.tasks.windows.WindowsAlert;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class WindowsStepDefinitions {

    @Entonces("^El decide ingresar a la seccion Alerts$")
    public void navigateToSectionAlerts() {
        theActorInTheSpotlight().attemptsTo(NavigateAlerts.nav());
    }

    @Y("^El decide probar la ventana Click Buton to see alert$")
    public void navigateToSectionClickButtonToSeeAlerts() {
        theActorInTheSpotlight().attemptsTo(WindowsAlert.event());
    }
    @Y("^El decide probar la ventana On button click, alert will appear after 5 seconds$")
    public void navigateToSectionClickAlertAppearAfterFiveSecond() {
        theActorInTheSpotlight().attemptsTo(WindowWaitFive.event());
    }
    @Y("^El decide probar la ventana On button click, confirm box will appear$")
    public void navigateToSectionOnButtonConfirmBoxAppear() {
        theActorInTheSpotlight().attemptsTo(WindowConfirm.event());
    }

    @Y("^El decide probar la ventana On button click, prompt box will appear y escribir el mensaje (.*)$")
    public void navigateToSectionOnButtonPromptBoxAppear(String message) {
        theActorInTheSpotlight().attemptsTo(WindowPrompt.event(message));
    }

}
