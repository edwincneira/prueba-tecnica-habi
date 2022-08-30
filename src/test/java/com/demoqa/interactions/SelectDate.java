package com.demoqa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

import static com.demoqa.user_interfaces.DatePage.*;
import static com.demoqa.utils.VariablesGlobals.month;
import static com.demoqa.utils.VariablesGlobals.year;
import static com.demoqa.utils.VariablesGlobals.numberDay;
import static com.demoqa.utils.VariablesGlobals.numberWeek;

import static com.demoqa.utils.DayOfMonth.getDayItem;
import static com.demoqa.utils.DayOfMonth.calculateWeekAndDay;

public class SelectDate implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        calculateWeekAndDay(getDayItem());

        Target targetMonth = getTargetByItem(xpathMonthSelectDate, String.valueOf(month));
        Target targetYear = getTargetByItem(xpathYearSelectDate, String.valueOf(year));
        Target targetDay = getTargetByTwoItem(xpathDaySelectDate, String.valueOf(numberWeek), String.valueOf(numberDay));

        actor.attemptsTo(
                Scroll.to(INPUT_TXT_SELECT_DATE),
                Click.on(INPUT_TXT_SELECT_DATE),
                Click.on(BTN_MONTH_SELECT_DATE),
                Scroll.to(targetMonth),
                Click.on(targetMonth),
                Click.on(BTN_YEAR_SELECT_DATE),
                Scroll.to(targetYear),
                Click.on(targetYear),
                Click.on(BTN_YEAR_SELECT_DATE),
                Click.on(targetDay)
        );
    }

    public static SelectDate in() { return Tasks.instrumented(SelectDate.class);}

}
