package com.demoqa.tasks.windows;

import com.demoqa.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;

import static com.demoqa.user_interfaces.WindowsPage.BTN_PROMPT;
import com.demoqa.utils.PromptAction;

public class WindowPrompt implements Task {

    private String message;

    public WindowPrompt(String message) {
        this.message = message;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_PROMPT)
        );
        PromptAction.writeAndDo(message, false);
        actor.attemptsTo(
                Wait.aSeconds(15)
        );

    }

    public static WindowPrompt event(String message){
        return Tasks.instrumented(WindowPrompt.class, message);
    }
}
