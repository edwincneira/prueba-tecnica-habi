package com.demoqa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.targets.Target;

import static com.demoqa.user_interfaces.DatePage.*;
import static com.demoqa.utils.DayOfMonth.calculateWeekAndDay;
import static com.demoqa.utils.DayOfMonth.getDayItem;
import static com.demoqa.utils.VariablesGlobals.*;
import static com.demoqa.utils.VariablesGlobals.numberDay;

public class DateAndTime implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        calculateWeekAndDay(getDayItem());
        Target targetDays = getTargetByTwoItem(xpathDayDateTime, String.valueOf(numberWeek), String.valueOf(numberDay + 1));
        Target targetMonths = getTargetByItem(xpathMonthDateTime, String.valueOf(month));
        actor.attemptsTo(
            Scroll.to(INPUT_TXT_DATE_DATE_AND_TIME),
            Click.on(INPUT_TXT_DATE_DATE_AND_TIME),
            Scroll.to(BTN_MONTH_DATE_AND_TIME),
            Click.on(BTN_MONTH_DATE_AND_TIME),
                Scroll.to(targetMonths),
                Click.on(targetMonths),
                Click.on(targetDays),
                Click.on(BTN_FIRST_HOUR),
                Scroll.to(INPUT_TXT_DATE_DATE_AND_TIME)
        );
    }

    public static DateAndTime in() { return Tasks.instrumented(DateAndTime.class);}

}
