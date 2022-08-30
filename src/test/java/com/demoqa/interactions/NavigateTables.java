package com.demoqa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.demoqa.user_interfaces.HomePage.ITEM_WEB_TABLES_OF_LIST_ELEMENT;

public class NavigateTables implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                NavigateHome.nav(1),
                Scroll.to(ITEM_WEB_TABLES_OF_LIST_ELEMENT),
                Click.on(ITEM_WEB_TABLES_OF_LIST_ELEMENT)
        );
    }

    public static NavigateTables nav() { return Tasks.instrumented(NavigateTables.class);}
}
