package com.demoqa.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import static net.thucydides.core.matchers.BeanMatcherAsserts.matches;

public class IsVisible {

    public static Question<Boolean> of(Target target) {
        return Question.about("visibility of " + target.getName()).answeredBy(actor -> matches(target.resolveAllFor(actor)));
    }

}
