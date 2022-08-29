package com.demoqa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import static com.demoqa.user_interfaces.HomePage.ITEM_DATE_PICKER_OF_LIST_ELEMENT;

public class NavigateDatePicker implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                NavigateHome.nav(4),
                Scroll.to(ITEM_DATE_PICKER_OF_LIST_ELEMENT),
                Click.on(ITEM_DATE_PICKER_OF_LIST_ELEMENT)
        );
    }

    public static NavigateDatePicker nav() { return Tasks.instrumented(NavigateDatePicker.class);}

}
