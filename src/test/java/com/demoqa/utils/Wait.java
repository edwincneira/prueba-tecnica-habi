package com.demoqa.utils;

import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Wait implements Interaction {

    private int var;

    protected Wait(int var) {
        this.var = var;
    }

    public static Wait aSeconds(int var){
        return instrumented(Wait.class, var*1000);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        new InternalSystemClock().pauseFor(var);
    }
}
