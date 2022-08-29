package com.demoqa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterPage {
    public static final Target INPUT_FIRST_NAME =  Target.the("input page first name identifier").located(By.xpath("//input[@placeholder='First Name']"));
    public static final Target INPUT_LAST_NAME =  Target.the("input page last name identifier").located(By.xpath("//input[@placeholder='Last Name']"));
    public static final Target INPUT_EMAIL_NAME =  Target.the("input page email identifier").located(By.xpath("//input[@placeholder='name@example.com']"));
    public static final Target INPUT_AGE =  Target.the("input page age identifier").located(By.xpath("//input[@placeholder='Age']"));
    public static final Target INPUT_SALARY =  Target.the("input page salary identifier").located(By.xpath("//input[@placeholder='Salary']"));
    public static final Target INPUT_DEPARTMENT_NAME =  Target.the("input page department identifier").located(By.xpath("//input[@placeholder='Department']"));
    public static final Target BTN_SUBMIT =  Target.the("btn submit identifier").located(By.id("submit"));

    public static Target getBasketForDeleteUser(String toDelete) {
        return Target.the(String.format("page element row %s item for delete identifier", toDelete)).located(By.xpath(String.format("//div[@class='rt-tbody']//child::div[%s]//div//child::*[1]//span[contains(@id, 'delete')]", toDelete)));
    }
}
