package com.demoqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class SeeText implements Question<String> {
    private Target target;

    public SeeText(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(target).answeredBy(actor).toString();
    }

    public static SeeText of(Target target) {
        return new SeeText(target);
    }
}
