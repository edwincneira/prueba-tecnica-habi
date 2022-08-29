package com.demoqa.tasks.windows;

import com.demoqa.interactions.NavigateAlerts;
import com.demoqa.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Switch;
import org.openqa.selenium.Keys;

import static com.demoqa.user_interfaces.WindowsPage.BTN_APPEAR_ALERT_FIVE_SECOND;

public class WindowWaitFive implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_APPEAR_ALERT_FIVE_SECOND),
                Wait.aSeconds(7),
                Switch.toAlert().andAccept()
        );

    }

    public static WindowWaitFive event(){
        return Tasks.instrumented(WindowWaitFive.class);
    }
}
