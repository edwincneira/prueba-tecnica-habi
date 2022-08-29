package com.demoqa.interactions;

import com.demoqa.utils.Wait;
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

    private String xpath_month = "//div[@class='react-datepicker__month-dropdown']//child::div[%s]";
    private String xpath_day = "//div[@class='react-datepicker__month']//child::div[%s]//child::div[%s]";

    @Override
    public <T extends Actor> void performAs(T actor) {
        calculateWeekAndDay(getDayItem());
        Target targetDays = getTargetByTwoItem(xpath_day, String.valueOf(numberWeek), String.valueOf(numberDay + 1));
        Target targetMonths = getTargetByItem(xpath_month, String.valueOf(month));
        actor.attemptsTo(
            Scroll.to(INPUT_TXT_DATE_DATE_AND_TIME),
            Click.on(INPUT_TXT_DATE_DATE_AND_TIME),
            Click.on(BTN_MONTH_DATE_AND_TIME),
                Wait.aSeconds(1),
                Scroll.to(targetMonths),
                Click.on(targetMonths),
                Wait.aSeconds(1),
                Click.on(targetDays),
                Click.on(BTN_FIRST_HOUR),
                Wait.aSeconds(2)
        );
    }

    public static DateAndTime in() { return Tasks.instrumented(DateAndTime.class);}

}
