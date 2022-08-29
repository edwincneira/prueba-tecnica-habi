package com.demoqa.interactions;

import com.demoqa.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;

import static com.demoqa.user_interfaces.DatePage.*;
import static com.demoqa.utils.VariablesGlobals.month;
import static com.demoqa.utils.VariablesGlobals.year;
import static com.demoqa.utils.VariablesGlobals.numberDay;
import static com.demoqa.utils.VariablesGlobals.numberWeek;

import static com.demoqa.utils.DayOfMonth.getDayItem;
import static com.demoqa.utils.DayOfMonth.calculateWeekAndDay;

public class SelectDate implements Interaction {

    private String xpath_month = "//select[@class='react-datepicker__month-select']//child::option[%s]";
    private String xpath_year = "//select[@class='react-datepicker__year-select']//child::option[@value='%s']";
    private String xpath_day = "//div[@class='react-datepicker__month']//child::div[%s]//child::div[%s]";

    @Override
    public <T extends Actor> void performAs(T actor) {
        calculateWeekAndDay(getDayItem());
        Target targetMonth = getTargetByItem(xpath_month, String.valueOf(month));
        Target targetYear = getTargetByItem(xpath_year, String.valueOf(year));
        Target targetDay = getTargetByTwoItem(xpath_day, String.valueOf(numberWeek), String.valueOf(numberDay));

        actor.attemptsTo(
                Scroll.to(INPUT_TXT_SELECT_DATE),
                Click.on(INPUT_TXT_SELECT_DATE),
                Click.on(BTN_MONTH_SELECT_DATE),
                Wait.aSeconds(1),
                Scroll.to(targetMonth),
                Click.on(targetMonth),
                Click.on(BTN_YEAR_SELECT_DATE),
                Scroll.to(targetYear),
                Click.on(targetYear),
                Wait.aSeconds(1),
                Click.on(BTN_YEAR_SELECT_DATE),
                Check.whether(targetDay.resolveFor(actor).isVisible()).andIfSo(
                        Click.on(targetDay)
                ).otherwise(
                        Wait.aSeconds(1),
                        Click.on(targetDay)
                ),
                Wait.aSeconds(2)
        );
    }

    public static SelectDate in() { return Tasks.instrumented(SelectDate.class);}

}
