package com.demoqa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.demoqa.user_interfaces.HomePage.PAGE_ELEMENTS;
import static com.demoqa.user_interfaces.HomePage.ITEM_WEB_TABLES_OF_LIST_ELEMENT;
import static com.demoqa.user_interfaces.HomePage.BTN_ADD_REGISTER;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateTables implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(PAGE_ELEMENTS),
                Click.on(PAGE_ELEMENTS),
//                Wait.aSeconds(1),
                Check.whether(ITEM_WEB_TABLES_OF_LIST_ELEMENT.resolveFor(actor).isVisible()).andIfSo(
                        Click.on(ITEM_WEB_TABLES_OF_LIST_ELEMENT)
                ).otherwise(
                        Click.on(ITEM_WEB_TABLES_OF_LIST_ELEMENT)
                ),
                WaitUntil.the(BTN_ADD_REGISTER, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static NavigateTables nav() { return Tasks.instrumented(NavigateTables.class);}
}
