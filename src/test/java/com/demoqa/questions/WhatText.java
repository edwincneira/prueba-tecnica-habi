package com.demoqa.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;
import java.util.stream.Collectors;

public class WhatText implements Question<String> {

    private Target target;

    public WhatText(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        return target.resolveAllFor(actor).stream()
                .map(element -> element.getAttribute("textContent"))
                .collect(Collectors.toList()).get(0);
    }

    public static WhatText of(Target target) {
        return new WhatText(target);
    }


}
