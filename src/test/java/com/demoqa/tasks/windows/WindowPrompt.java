package com.demoqa.tasks.windows;

import com.demoqa.questions.WhatText;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;

import static com.demoqa.user_interfaces.WindowsPage.BTN_PROMPT;
import static com.demoqa.user_interfaces.WindowsPage.LABEL_MESSAGE_PROMPT;

import com.demoqa.utils.PromptAction;
import com.demoqa.questions.IsVisible;
import net.serenitybdd.screenplay.ensure.Ensure;

public class WindowPrompt implements Task {

    private String message;
    private static boolean acceptCancel;

    public WindowPrompt(String message, boolean acceptCancel) {
        this.message = message;
        this.acceptCancel = acceptCancel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_PROMPT)
        );
        PromptAction.writeAndDo(message, acceptCancel);
        if(acceptCancel) {
            String messageLabel = WhatText.of(LABEL_MESSAGE_PROMPT).answeredBy(actor);
            actor.attemptsTo(
                    Ensure.that(messageLabel).contains(message)
            );
        } else {
            actor.attemptsTo(
                    Ensure.that(IsVisible.of(LABEL_MESSAGE_PROMPT)).isFalse()
            );
        }
    }

    public static WindowPrompt event(String message, boolean acceptCancel){
        return Tasks.instrumented(WindowPrompt.class, message, acceptCancel);
    }
}
