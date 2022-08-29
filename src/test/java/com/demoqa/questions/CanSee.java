package com.demoqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class CanSee implements Question<Boolean> {

    private Target element;

    public CanSee(Target element) {
        this.element = element;
    }

    @Override
    public Boolean answeredBy(Actor actor){
        return element.resolveFor(actor).isVisible();
    }

    public static CanSee is(Target target) {
        return new CanSee(target);
    }

}