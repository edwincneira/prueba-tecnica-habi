package com.demoqa.stepdefinitions;

import com.demoqa.tasks.DateSelect;
import com.demoqa.tasks.DateTime;
import io.cucumber.java.es.Entonces;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.demoqa.utils.ClearDate;

public class DateStepDefinitions {

    @Entonces("^El decide ingresar la fecha (.*) en la seccion select date$")
    public void navigateToSelectDateAndInDate(String date) {
        new ClearDate(date).setDate();
        theActorInTheSpotlight().attemptsTo(DateSelect.searchDateSelect(date));
    }

    @Entonces("^El decide ingresar la fecha (.*) en la seccion date and time$")
    public void navigateToDateAndTimeAndInDate(String date) {
        new ClearDate(date).setDate();
        theActorInTheSpotlight().attemptsTo(DateTime.searchDateAndTime(date));
    }


}
