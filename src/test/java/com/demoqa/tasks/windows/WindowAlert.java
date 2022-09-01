package com.demoqa.tasks.windows;

import com.demoqa.questions.IsVisible;
import com.demoqa.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;
import static com.demoqa.user_interfaces.WindowsPage.BTN_ALERT;

public class WindowAlert implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_ALERT),
                Wait.aSeconds(3),
                Switch.toAlert().andAccept(),
                Ensure.that(IsVisible.of(BTN_ALERT)).isTrue()
        );

    }

    public static WindowAlert event(){
        return Tasks.instrumented(WindowAlert.class);
    }
}
