package com.demoqa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target ITEM_WEB_TABLES_OF_LIST_ELEMENT =  Target.the("item web tables identifier").located(By.xpath("//li[@class='btn btn-light ' and @id='item-3']"));
    public static final Target ITEM_DATE_PICKER_OF_LIST_ELEMENT =  Target.the("item date picker identifier").located(By.xpath("//div[@class='accordion']//child::div[4]//li[@class='btn btn-light ' and @id='item-2']"));
    public static final Target BTN_ADD_REGISTER =  Target.the("btn add register identifier").located(By.id("addNewRecordButton"));

    public static Target getPageHomeByItem(String item) {
//        return Target.the(String.format("page element item %s identifier", item)).located(By.xpath(String.format("//div[@class='category-cards']//child::div[%s]", item)));
        return Target.the(String.format("page element item %s identifier", item)).located(By.xpath(String.format("//div[@class='category-cards']//child::div[@class='card mt-4 top-card'][%s]", item)));
    }

}
