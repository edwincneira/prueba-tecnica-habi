package com.demoqa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class Write implements Interaction {

    private String message;
    private Target target;

    public Write(Target target, String message) {
        this.target = target;
        this.message = message;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(message)
                        .into(target)
        );
    }

    public static Write some(Target target, String message) { return Tasks.instrumented(Write.class, target, message);}
}
