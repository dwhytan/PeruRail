package screenplay.tasks.choose;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.conditions.Check;
import org.hamcrest.Matchers;
import screenplay.questions.Travel;
import screenplay.user_interfaces.BelmondBookingPage;
import screenplay.user_interfaces.BookingHomePage;
import screenplay.user_interfaces.MachuPicchuBookingPage;

public class Choose {
    public static Performable roundtripTravel() {
        return Task.where("{0} escoge viaje de Ida y Vuelta",
                Click.on(BookingHomePage.ROUNDTRIP_RADIO)
        );
    }

    public static Performable oneWayTravel() {
        return Task.where("{0} escoge viaje de Solo Ida",
                Click.on(BookingHomePage.ONEWAY_RADIO)
        );
    }

    public static Performable destination(String destination) {
        return Task.where("{0} escoge su Destino",
                SelectFromOptions.byVisibleText(destination).from(BookingHomePage.DESTINATION_SELECT)
        );
    }

    public static Performable route(String route) {
        return Task.where("{0} escoge su Ruta",
                SelectFromOptions.byVisibleText(route).from(BookingHomePage.ROUTE_SELECT)
        );
    }

    public static Performable train(String train) {
        return Task.where("{0} escoge su Tren",
                SelectFromOptions.byVisibleText(train).from(BookingHomePage.TRAIN_SELECT)
        );
    }

    public static Performable cabin() {
        return Task.where("{0} escoge su Cabina",
                SelectFromOptions.byIndex(1).from(BelmondBookingPage.CABINS_SELECT),
                Click.on(BelmondBookingPage.CABINSCONTINUE_BUTTON)
        );
    }

    public static Performable trip() {
        return Task.where("{0} escoge su Itinerario de Viaje",
                Click.on(MachuPicchuBookingPage.ORIGIN_BUTTON),
                Check.whether(Travel.isDestinationVisible(), Matchers.is(true)).andIfSo(Click.on(MachuPicchuBookingPage.DESTINATION_BUTTON)),
                Click.on(MachuPicchuBookingPage.CONTINUETRIP_BUTTON)
        );
    }
}
