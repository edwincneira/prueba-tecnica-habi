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

    public NavigateHome(int item) {
        this.item = item;
    }

    @Override
    public <T extends Actor> void performAs(T actor)  {
        Target section = getPageHomeByItem(String.valueOf(item));
        actor.attemptsTo(
                Scroll.to(section),
                Click.on(section)
        );
    }

    public static NavigateHome nav(int item) { return Tasks.instrumented(NavigateHome.class, item);}
}
