package com.demoqa.tasks.windows;

import com.demoqa.questions.IsVisible;
import com.demoqa.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.demoqa.user_interfaces.WindowsPage.BTN_APPEAR_ALERT_FIVE_SECOND;

public class WindowWaitFive implements Task {

    private static int wait;

    public WindowWaitFive(int wait) {
        this.wait = wait;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_APPEAR_ALERT_FIVE_SECOND),
                Wait.aSeconds(wait),
                Switch.toAlert().andAccept(),
                Ensure.that(IsVisible.of(BTN_APPEAR_ALERT_FIVE_SECOND)).isTrue()
        );

    }

    public static WindowWaitFive event(int wait){
        return Tasks.instrumented(WindowWaitFive.class, wait);
    }
}
