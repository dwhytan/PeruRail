package screenplay.user_interfaces;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

public class BookingHomePage {
    public static Target ROUNDTRIP_RADIO = Target.the("Ida y Vuelta - Botón")
            .locatedBy("//label[@for='roundtrip']");
    public static Target ONEWAY_RADIO = Target.the("Solo Ida - Botón")
            .locatedBy("//label[@for='oneway']");
    public static Target DESTINATION_SELECT = Target.the("Destino - DropMenu")
            .locatedBy("//select[@id='destinoSelect']");
    public static Target ROUTE_SELECT = Target.the("Ruta - DropMenu")
            .locatedBy("//select[@id='rutaSelect']");
    public static Target TRAIN_SELECT = Target.the("Tren - DropMenu")
            .locatedBy("//select[@id='cbTrenSelect']");
    public static Target FINDTICKETS_BUTTON = Target.the("Encontrar Tickets - Botón")
            .locatedBy("//button[@id='btn_search']");
    public static Target DEPARTUREDATE_TXT = Target.the("Fecha de Salida - Date")
            .locatedBy("//input[@id='salida']");
    public static Target DEPARTUREDATE_BTN = Target.the("Fecha de Salida - Botón")
            .locatedBy("//td[@data-handler='selectDay']");
    public static Target ARRIVALDATE_TXT = Target.the("Fecha de Retorno - Date")
            .locatedBy("//input[@id='regreso']");
    public static Target TICKETS_TXT = Target.the("Tickets - Botón")
            .locatedBy("//input[@id='countParentsChildren']");
    public static Target TICKETSMINUX_TXT = Target.the("Tickets Menos 1 - Botón")
            .locatedBy("//*[@id='adultsDism']");
}
