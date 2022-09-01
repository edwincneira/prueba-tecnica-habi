package com.demoqa.tasks;

import com.demoqa.interactions.CalendarDays;
import com.demoqa.interactions.NavigateDatePicker;
import com.demoqa.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

import static com.demoqa.user_interfaces.DatePage.*;
import static com.demoqa.user_interfaces.DatePage.xpathMonthDateTime;
import static com.demoqa.utils.VariablesGlobals.*;

public class DateTime implements Task {

    private static String date;
    private static Target selectMonth;

    public DateTime(String date) {
        this.date = date;
        this.selectMonth = getTargetByItem(xpathMonthDateTime, String.valueOf(month));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                NavigateDatePicker.nav(),
                Scroll.to(INPUT_TXT_DATE_DATE_AND_TIME),
                Click.on(INPUT_TXT_DATE_DATE_AND_TIME),
                Scroll.to(BTN_MONTH_DATE_AND_TIME),
                Click.on(BTN_MONTH_DATE_AND_TIME),
                Scroll.to(selectMonth),
                Click.on(selectMonth),
                CalendarDays.selectBy(xpathDayDateTime),
                Click.on(BTN_FIRST_HOUR),
                Scroll.to(INPUT_TXT_DATE_DATE_AND_TIME),
                Wait.aSeconds(5)
        );
    }
    public static DateTime searchDateAndTime(String date){
        return Tasks.instrumented(DateTime.class, date);
    }

}
