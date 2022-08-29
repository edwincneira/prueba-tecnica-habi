package com.demoqa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import com.demoqa.interactions.NavigateDatePicker;
import com.demoqa.interactions.SelectDate;

public class Date implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                NavigateDatePicker.nav(),
                SelectDate.in()
        );

    }

    public static Date searchDateSelect(){
        return Tasks.instrumented(Date.class);
    }

}
