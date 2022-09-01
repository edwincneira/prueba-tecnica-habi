package com.demoqa.tasks;

import com.demoqa.interactions.NavigateWebTables;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;

import static com.demoqa.user_interfaces.HomePage.BTN_ADD_REGISTER;
import static com.demoqa.user_interfaces.RegisterPage.*;

import com.demoqa.questions.WhatText;
import org.openqa.selenium.By;

public class DeleteUser implements Task {

    private String name;
    private String lastName;
    private String email;
    private int age;
    private int salary;
    private String department;
    private boolean isPerson = false;
    private String _list;
    private static int list = 1;
    private static Target targetEmail;
    private static Target targetBasket;

    public DeleteUser(String name, String lastName, String email, int age, int salary, String department) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                NavigateWebTables.nav()
        );
        //Search and Delete
        while (!isPerson) {
            targetEmail = Target.the("btn list ").located(By.xpath(String.format(LABEL_LIST, String.valueOf(list))));
            String _email = WhatText.of(targetEmail).answeredBy(actor);
            if(_email.equals(email)){
                _list = String.valueOf(list);
                isPerson = true;
                targetBasket = getBasketForDeleteUser(_list);
                actor.attemptsTo(
                        Scroll.to(BTN_ADD_REGISTER),
                        Scroll.to(targetBasket),
                        Click.on(targetBasket)
                );
                list=1;
                break;
            }
            list++;
            if(list>10) {
                Serenity.recordReportData().withTitle("Usuario no eliminado").andContents("EL usuario no existe en la pagina demoqa.com ");
                break;
            };
        }
        //Confirm Delete
        if(isPerson) {
            String _email = WhatText.of(getEmailUser(_list)).answeredBy(actor);
            actor.attemptsTo(
                    Ensure.that(_email).doesNotContain(email)
            );
        }
    }

    public static DeleteUser deleteUser(String name, String lastName, String email, int age, int salary, String department){
        return Tasks.instrumented(DeleteUser.class, name, lastName, email, age, salary, department);
    }

}
