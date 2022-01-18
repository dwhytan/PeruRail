package screenplay.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class MachuPicchuBookingPage {
    public static Target ORIGIN_BUTTON = Target.the("Ida - Botón")
            .locatedBy("//div[@indtramo = 'IDA' and @tienebimodal = '1'][1]");
    public static Target DESTINATION_BUTTON = Target.the("Regreso - Botón")
            .locatedBy("//div[@indtramo = 'RET' and @tienebimodal = '1'][1]");
    public static Target CONTINUETRIP_BUTTON = Target.the("Continuar - Botón")
            .locatedBy("//input[@onClick = 'enviarForm()']");
}
