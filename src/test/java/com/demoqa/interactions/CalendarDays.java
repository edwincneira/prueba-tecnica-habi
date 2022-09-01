package com.demoqa.interactions;

import com.demoqa.questions.WhatText;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import static com.demoqa.utils.VariablesGlobals.*;

public class CalendarDays implements Interaction {

    private String xpath;
    private static Target day_target = Target.the("temporal").located(By.xpath(""));
    private static String list;
    private static boolean isDate = false;
    private static boolean exception = false; // No elegir los primeros dias mapeados, que pueden ser desde el 26 al 31 en la semana 1

    public CalendarDays(String xpath) {
        this.xpath = xpath;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for(int _week=1; _week<7; _week++){
            for (int _day=1; _day<8; _day++){
                day_target = Target.the("btn day " + day).located(By.xpath(String.format(xpath, _week, _day)));
                list = WhatText.of(day_target).answeredBy(actor);
                isDate = (list.equals(String.valueOf(day))) ? true:false;
                exception = (Integer.parseInt(list) >= 26 && _week == 1 ) ? true : false;
                if(isDate && !exception) {
                    break;
                }
            }
            if (isDate) break;
        }
        actor.attemptsTo(
                Click.on(day_target)
        );

    }

    public static CalendarDays selectBy(String xpath) { return Tasks.instrumented(CalendarDays.class, xpath);}
}
