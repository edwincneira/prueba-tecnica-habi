package com.demoqa.interactions;

import com.demoqa.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.demoqa.user_interfaces.WindowsPage.ITEM_ALERTS_OF_LIST_ELEMENT;

public class NavigateAlerts implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                NavigateHome.nav(3),
                Scroll.to(ITEM_ALERTS_OF_LIST_ELEMENT),
                Click.on(ITEM_ALERTS_OF_LIST_ELEMENT),
                Wait.aSeconds(1)
        );
    }

    public static NavigateAlerts nav() { return Tasks.instrumented(NavigateAlerts.class);}
}
