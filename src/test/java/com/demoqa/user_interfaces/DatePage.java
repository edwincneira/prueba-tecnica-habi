package com.demoqa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatePage {

    public static final Target INPUT_TXT_SELECT_DATE =  Target.the("page widget identifier").located(By.id("datePickerMonthYearInput"));

    public static final Target BTN_MONTH_SELECT_DATE =  Target.the("btn deploy month identifier").located(By.xpath("//select[@class='react-datepicker__month-select']"));
    public static final Target BTN_YEAR_SELECT_DATE =  Target.the("btn deploy year identifier").located(By.xpath("//select[@class='react-datepicker__year-select']"));

    public static final Target INPUT_TXT_DATE_DATE_AND_TIME =  Target.the("page widget identifier").located(By.id("dateAndTimePickerInput"));

    public static final Target BTN_MONTH_DATE_AND_TIME = Target.the("btn deploy year identifier").located(By.xpath("//span[@class='react-datepicker__month-read-view--down-arrow']"));

    public static final Target BTN_FIRST_HOUR = Target.the("btn deploy year identifier").located(By.xpath("//ul[@class='react-datepicker__time-list']//child::li[1]"));


    public static Target getTargetByItem(String xpath, String value) {
        return Target.the("page element identifier").located(By.xpath(String.format(xpath, value)));
    }

    public static Target getTargetByTwoItem(String xpath, String value1, String value2) {
        return Target.the("page element identifier").located(By.xpath(String.format(xpath, value1, value2)));
    }
}
