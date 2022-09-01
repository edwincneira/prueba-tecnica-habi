package com.demoqa.stepdefinitions;

import com.demoqa.navigation.NavigateTo;
import com.demoqa.tasks.RegisterUser;
import io.cucumber.java.an.Y;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;

import com.demoqa.tasks.DeleteUser;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class RegisterStepDefinitions {

    @Dado("{actor} navega en la aplicacion web")
    public void navigateAppWeb(Actor theQA) {
        theQA.wasAbleTo(NavigateTo.theDemoQAHomePage());
    }

    @Entonces("^El decide registrarse con su nombre, (.*) apellido, (.*) correo, (.*) edad, (.*) salario, (.*) departamento, (.*)$")
    public void registerUserTable(String name, String lastName, String email, int age, int salary, String department) {
        theActorInTheSpotlight().attemptsTo(RegisterUser.registerUser(name, lastName, email, age, salary, department));
    }

    @Y("^El decide eliminar sus datos que estan con su nombre, (.*) apellido, (.*) correo, (.*) edad, (.*) salario, (.*) departamento, (.*)$")
    public void deleteUserTable(String name, String lastName, String email, int age, int salary, String department) {
        theActorInTheSpotlight().attemptsTo(DeleteUser.deleteUser(name, lastName, email, age, salary, department));
    }

}
