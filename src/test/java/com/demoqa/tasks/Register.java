package com.demoqa.tasks;

import com.demoqa.interactions.NavigateTables;
import com.demoqa.interactions.Write;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;

import org.openqa.selenium.Keys;

import static com.demoqa.user_interfaces.RegisterPage.*;
import static com.demoqa.user_interfaces.HomePage.BTN_ADD_REGISTER;

public class Register implements Task {

    private String name;
    private String lastName;
    private String email;
    private int age;
    private int salary;
    private String department;

    public Register(String name, String lastName, String email, int age, int salary, String department) {
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
                NavigateTables.nav(),
                Click.on(BTN_ADD_REGISTER),
                Write.some(INPUT_FIRST_NAME, name),
                Write.some(INPUT_LAST_NAME, lastName),
                Write.some(INPUT_EMAIL_NAME, email),
                Write.some(INPUT_AGE, String.valueOf(age)),
                Write.some(INPUT_SALARY, String.valueOf(salary)),
                Enter.theValue(department).into(INPUT_DEPARTMENT_NAME).thenHit(Keys.ENTER)
        );
    }

    public static Register registerUser(String name, String lastName, String email, int age, int salary, String department){
        return Tasks.instrumented(Register.class, name, lastName, email, age, salary, department);
    }


}