package com.demoqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class IsElement implements Question<Boolean> {

    private Target target;

    public IsElement(Target target) {
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(target).isVisible();
    }

    public static IsElement on(Target target) {
        return new IsElement(target);
    }
}
