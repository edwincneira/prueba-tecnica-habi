package com.demoqa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class WindowsPage {
    public static final Target ITEM_ALERTS_OF_LIST_ELEMENT =  Target.the("input page alerts identifier").located(By.xpath("//div[@class='element-list collapse show']//child::ul//child::li[@id='item-1']"));
    public static final Target BTN_ALERT =  Target.the("btn alert identifier").located(By.id("alertButton"));
    public static final Target BTN_APPEAR_ALERT_FIVE_SECOND =  Target.the("btn alert appear five second identifier").located(By.id("timerAlertButton"));
    public static final Target BTN_CONFIRM =  Target.the("btn confirm identifier").located(By.id("confirmButton"));
    public static final Target BTN_PROMPT =  Target.the("btn prompt identifier").located(By.id("promtButton"));

    //QUESTIONS
    public static final Target LABEL_MESSAGE_PROMPT =  Target.the("btn prompt identifier").located(By.id("promptResult"));
    public static final Target LABEL_MESSAGE_CONFIRM =  Target.the("btn prompt identifier").located(By.id("confirmResult"));


}
