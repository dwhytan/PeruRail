package screenplay.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class BelmondBookingPage {
    public static Target CABINS_SELECT = Target.the("Suite de Cabinas - Select")
            .locatedBy("//select[@name='selectRooms[suite]']");
    public static Target CABINSCONTINUE_BUTTON = Target.the("Suite de Cabinas - Select")
            .locatedBy("//input[@id='continuar_bae']");
    public static Target PASSENGERNAME_TXT = Target.the("Nombre - Textfield")
            .locatedBy("//input[@id='txt_nombre[suite][cab1][1]' or @id='formPasajero1-nomPasajero']");
    public static Target PASSENGERLASTNAME_TXT = Target.the("Apellido - Textfield")
            .locatedBy("//input[@id='txt_apellido[suite][cab1][1]' or @id='formPasajero1-apePasajero']");
    public static Target PASSENGERBIRTHDATE_TXT = Target.the("Fecha de Nacimiento - Textfield")
            .locatedBy("//input[@id='txt_fecha_nacimiento[suite][cab1][1]']");
    public static Target PASSENGERBIRTHDATE_TXT2 = Target.the("Fecha de Nacimiento - Textfield")
            .locatedBy("//input[@id='formPasajero1-fecNacimiento']");
    public static Target PASSENGERNATIONALITY_SELECT = Target.the("Nacionalidad - Select")
            .locatedBy("//select[@id='sel_nacion[suite][cab1][1]' or @id='formPasajero1-idPais']");
    public static Target PASSENGERDOCUMENT_SELECT = Target.the("Documento de Identidad - Select")
            .locatedBy("//select[@id='sel_tpdoc[suite][cab1][1]' or @id='formPasajero1-idDocumentoIdentidad']");
    public static Target PASSENGERDOCUMENT_TXT = Target.the("Documento de Identidad - Textfield")
            .locatedBy("//input[@id='txt_nroid[suite][cab1][1]' or @id='formPasajero1-numDocumentoIdentidad']");
    public static Target PASSENGERSEX_SELECT = Target.the("Sexo - Select")
            .locatedBy("//select[@id='sel_sexo[suite][cab1][1]' or @id='formPasajero1-idSexo']");
    public static Target PASSENGERPHONE_TXT = Target.the("Phone - Textfield")
            .locatedBy("//input[@id='txt_telefono[suite][cab1][1]' or @id='formPasajero1-numTelefono']");
    public static Target PASSENGEREMAIL_TXT = Target.the("Email - Textfield")
            .locatedBy("//input[@id='txt_mail[suite][cab1][1]' or @id='formPasajero1-desEmail']");
    public static Target PASSENGERCONFIRMEMAIL_TXT = Target.the("Email confirmación - Textfield")
            .locatedBy("//input[@id='txt_mail_conf[suite][cab1][1]' or @id='formPasajero1-desEmailConfirmacion']");
    public static Target PASSENGERFORMCONTINUE_BUTTON = Target.the("Continuar - Botón")
            .locatedBy("//*[@id='btnContinuarPas' or @id='enviarPago']");
    public static Target PURCHASESUMMARY_BUTTON = Target.the("Resumen de Compras - Botón")
            .locatedBy("//*[text()[contains(.,'purchase summary') or contains(.,'Purchase Summary')]]");
    public static Target PURCHASESUMMARY_DIV = Target.the("Resumen de Compras - Div")
            .locatedBy("//a[@click='1']");
}
