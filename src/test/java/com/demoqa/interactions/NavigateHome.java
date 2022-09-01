package com.demoqa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.demoqa.user_interfaces.HomePage.*;
import net.serenitybdd.screenplay.targets.Target;

public class NavigateHome implements Interaction {

    private int item;
    private Target section;

    public NavigateHome(int item) {
        this.item = item;
        this.section = getPageHomeByItem(String.valueOf(item));
    }

    @Override
    public <T extends Actor> void performAs(T actor)  {
        actor.attemptsTo(
                Scroll.to(section),
                Click.on(section)
        );
    }

    public static NavigateHome nav(int item) { return Tasks.instrumented(NavigateHome.class, item);}
}
