package com.demoqa.tasks.windows;

import com.demoqa.questions.SeeText;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.demoqa.user_interfaces.WindowsPage.BTN_CONFIRM;
import static com.demoqa.user_interfaces.WindowsPage.LABEL_MESSAGE_CONFIRM;


public class WindowConfirm implements Task {

    private static boolean acceptCancel;

    public WindowConfirm(boolean acceptCancel) {
        this.acceptCancel = acceptCancel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(BTN_CONFIRM),
                Click.on(BTN_CONFIRM),
                Check.whether(acceptCancel).andIfSo(
                        Switch.toAlert().andAccept(),
                        Ensure.that(SeeText.of(LABEL_MESSAGE_CONFIRM)).contains("Ok")
                ).otherwise(
                        Switch.toAlert().andDismiss(),
                        Ensure.that(SeeText.of(LABEL_MESSAGE_CONFIRM)).contains("Cancel")
                )
        );

    }

    public static WindowConfirm event(boolean acceptCancel){
        return Tasks.instrumented(WindowConfirm.class, acceptCancel);
    }
}
