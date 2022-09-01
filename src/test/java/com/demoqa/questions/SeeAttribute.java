package com.demoqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

public class SeeAttribute implements Question<Boolean> {

    private String attribute;
    private String xpath;


    public SeeAttribute(String xpath, String attribute) {
        this.attribute = attribute;
        this.xpath = xpath;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
//        System.out.println("ATRIBUTO A VER " + attribute);

        return BrowseTheWeb.as(actor).find(By.xpath(String.format(xpath, attribute))).isVisible();
    }

    public static SeeAttribute on(String xpath, String attribute) {
        return new SeeAttribute(xpath, attribute);
    }

}
