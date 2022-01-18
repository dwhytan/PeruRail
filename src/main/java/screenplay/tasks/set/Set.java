package screenplay.tasks.set;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import org.hamcrest.Matchers;
import org.openqa.selenium.support.FindBy;
import screenplay.questions.PurchaseSummary;
import screenplay.questions.Travel;
import screenplay.user_interfaces.BookingHomePage;

public class Set {
    public static Performable departureDate(String date) {
        return Task.where("{0} indica su fecha de embarque",
                Clear.field(BookingHomePage.DEPARTUREDATE_TXT),
                SendKeys.of(date).into(BookingHomePage.DEPARTUREDATE_TXT),
                Click.on(BookingHomePage.DEPARTUREDATE_BTN),
                Check.whether(Travel.isReturnVisible(), Matchers.is(true)).andIfSo(
                        Clear.field(BookingHomePage.ARRIVALDATE_TXT),
                        SendKeys.of(date).into(BookingHomePage.ARRIVALDATE_TXT)),
                Check.whether(Travel.isTicketVisible(), Matchers.is(true)).andIfSo(
                        Click.on(BookingHomePage.TICKETS_TXT),
                        Click.on(BookingHomePage.TICKETSMINUX_TXT))
        );
    }

    public static Performable tickets() {
        return Task.where("{0} indica la cantidad de tickets",
                Click.on(BookingHomePage.TICKETS_TXT),
                Click.on(BookingHomePage.TICKETSMINUX_TXT)
        );
    }
}
