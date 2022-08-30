package com.demoqa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import com.demoqa.interactions.NavigateDatePicker;
import com.demoqa.interactions.SelectDate;
import net.serenitybdd.screenplay.ensure.Ensure;
import static com.demoqa.user_interfaces.DatePage.LABEL_DATE_SELECT_TEXT;

import com.demoqa.questions.SeeAttribute;

public class Date implements Task {

    private static String date;

    public Date(String date) {
        this.date = date;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                NavigateDatePicker.nav(),
                SelectDate.in(),
                Ensure.that(SeeAttribute.on(LABEL_DATE_SELECT_TEXT, date)).isTrue()
        );

    }

    public static Date searchDateSelect(String date){
        return Tasks.instrumented(Date.class, date);
    }

}
