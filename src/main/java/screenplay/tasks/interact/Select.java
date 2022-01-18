package screenplay.tasks.interact;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import screenplay.user_interfaces.BookingHomePage;

public class Select {
    public static Performable findTrainTickets() {
        return Task.where("{0} realiza la consulta de tickets",
                Click.on(BookingHomePage.FINDTICKETS_BUTTON)
        );
    }
}
