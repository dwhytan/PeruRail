package screenplay.questions;

import net.serenitybdd.screenplay.Question;
import screenplay.user_interfaces.BelmondBookingPage;
import screenplay.user_interfaces.BookingHomePage;
import screenplay.user_interfaces.MachuPicchuBookingPage;

public class Travel {
    public static Question<Boolean> isReturnVisible() {
        return actor ->  BookingHomePage.ARRIVALDATE_TXT.resolveFor(actor).isCurrentlyVisible();
    }
    public static Question<Boolean> isMachuPicchuVisible() {
        return actor ->  BelmondBookingPage.PASSENGERBIRTHDATE_TXT2.resolveFor(actor).isCurrentlyVisible();
    }
    public static Question<Boolean> isDestinationVisible() {
        return actor ->  MachuPicchuBookingPage.DESTINATION_BUTTON.resolveFor(actor).isCurrentlyVisible();
    }
    public static Question<Boolean> isTicketVisible() {
        return actor ->  BookingHomePage.TICKETS_TXT.resolveFor(actor).isCurrentlyVisible();
    }
}
