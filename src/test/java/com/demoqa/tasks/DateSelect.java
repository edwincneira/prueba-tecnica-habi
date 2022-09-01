package com.demoqa.tasks;

import com.demoqa.questions.SeeAttribute;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import com.demoqa.interactions.NavigateDatePicker;
import com.demoqa.interactions.CalendarDays;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import static com.demoqa.user_interfaces.DatePage.LABEL_DATE_SELECT_TEXT;
import static com.demoqa.user_interfaces.DatePage.*;
import static com.demoqa.utils.VariablesGlobals.*;

import net.serenitybdd.screenplay.targets.Target;

public class DateSelect implements Task {

    private static String date;
    private static Target selectMonth;
    private static Target selectYear;

    public DateSelect(String date) {
        this.date = date;
        this.selectMonth = getTargetByItem(xpathMonthSelectDate, String.valueOf(month));
        this.selectYear = getTargetByItem(xpathYearSelectDate, String.valueOf(year));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                NavigateDatePicker.nav(),
                Scroll.to(INPUT_TXT_SELECT_DATE),
                Click.on(INPUT_TXT_SELECT_DATE),
                Scroll.to(BTN_MONTH_SELECT_DATE),
                Click.on(BTN_MONTH_SELECT_DATE),
                Scroll.to(selectMonth),
                Click.on(selectMonth),
                Click.on(BTN_YEAR_SELECT_DATE),
                Scroll.to(selectYear),
                Click.on(selectYear),
                Click.on(BTN_YEAR_SELECT_DATE),
                CalendarDays.selectBy(xpathDaySelectDate),
                Ensure.that(SeeAttribute.on(LABEL_DATE_SELECT_TEXT, date)).isTrue()
        );
    }

    public static DateSelect searchDateSelect(String date){
        return Tasks.instrumented(DateSelect.class, date);
    }
}
