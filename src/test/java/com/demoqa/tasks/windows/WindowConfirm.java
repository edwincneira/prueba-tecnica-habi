package com.demoqa.tasks.windows;

import com.demoqa.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import com.demoqa.interactions.NavigateAlerts;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;

import static com.demoqa.user_interfaces.WindowsPage.BTN_CONFIRM;

public class WindowConfirm implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(BTN_CONFIRM),
                Click.on(BTN_CONFIRM),
                Switch.toAlert().andAccept()
        );

    }

    public static WindowConfirm event(){
        return Tasks.instrumented(WindowConfirm.class);
    }
}
