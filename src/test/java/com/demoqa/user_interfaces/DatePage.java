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

    public static String xpathMonthSelectDate = "//select[@class='react-datepicker__month-select']//child::option[%s]";
    public static String xpathYearSelectDate = "//select[@class='react-datepicker__year-select']//child::option[@value='%s']";
    public static String xpathDaySelectDate = "//div[@class='react-datepicker__month']//child::div[%s]//child::div[%s]";
    public static String xpathMonthDateTime = "//div[@class='react-datepicker__month-dropdown']//child::div[%s]";
    public static String xpathDayDateTime = "//div[@class='react-datepicker__month']//child::div[%s]//child::div[%s]";

    public static Target getTargetByItem(String xpath, String value) {
        return Target.the("page element identifier").located(By.xpath(String.format(xpath, value)));
    }

    public static Target getTargetByTwoItem(String xpath, String value1, String value2) {
        return Target.the("page element identifier").located(By.xpath(String.format(xpath, value1, value2)));
    }

    //QUESTIONS
    public static final Target LABEL_DATE_INPUT = Target.the("label date input identifier").located(By.id("datePickerMonthYearInput"));
    public static String LABEL_DATE_SELECT_TEXT = "//input[@value='%s' and @id='datePickerMonthYearInput']";
    public static String LABEL_DATE_AND_TIME_TEXT = "//input[contains(@value, '%s') and @id='dateAndTimePickerInput']";
}
