package com.demoqa.utils;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class PromptAction {

    public static void writeAndDo(String message, boolean cancelOrAccept) {
        WebDriver driver = Serenity.getDriver();
        Alert promptAlert  = driver.switchTo().alert();
        promptAlert.sendKeys(message);
        if(cancelOrAccept) promptAlert.dismiss();
        else promptAlert.accept();
    }

}
