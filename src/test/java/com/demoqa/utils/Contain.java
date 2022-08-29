package com.demoqa.utils;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.steps.StepEventBus;

public class Contain {

    public static String getElementText(Target target, Actor actor) {

        WebElementFacade element_html = target.resolveFor(actor);
        String valueText = element_html.getTextValue();
        if (valueText.isEmpty()) {
            StepEventBus.getEventBus().clearStepFailures();
            return BrowseTheWeb.as(actor).evaluateJavascript("return arguments[0].innerText;", element_html).toString().trim();
        }
        return valueText;
    }

}
