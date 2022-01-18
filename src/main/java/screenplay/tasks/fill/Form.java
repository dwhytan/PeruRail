package screenplay.tasks.fill;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.hamcrest.Matchers;
import screenplay.questions.PurchaseSummary;
import screenplay.questions.Travel;
import screenplay.user_interfaces.BelmondBookingPage;
import screenplay.user_interfaces.BookingHomePage;

public class Form {
    private static final EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    private static final String NAME = EnvironmentSpecificConfiguration.from(variables).getProperty("belmond.name");
    private static final String LASTNAME = EnvironmentSpecificConfiguration.from(variables).getProperty("belmond.lastname");
    private static final String BIRTHDATE = EnvironmentSpecificConfiguration.from(variables).getProperty("belmond.birthdate");
    private static final String BIRTHDATE2 = EnvironmentSpecificConfiguration.from(variables).getProperty("belmond.birthdate2");
    private static final String PHONE = EnvironmentSpecificConfiguration.from(variables).getProperty("belmond.phone");
    private static final String EMAIL = EnvironmentSpecificConfiguration.from(variables).getProperty("belmond.email");

    public static Performable ofPassenger() {
        return Task.where("{0} completa sus datos personales",
                Enter.theValue(NAME).into(BelmondBookingPage.PASSENGERNAME_TXT),
                Enter.theValue(LASTNAME).into(BelmondBookingPage.PASSENGERLASTNAME_TXT),
                Enter.theValue(LASTNAME).into(BelmondBookingPage.PASSENGERLASTNAME_TXT),
                Check.whether(Travel.isMachuPicchuVisible(), Matchers.is(true)).andIfSo(
                        Clear.field(BelmondBookingPage.PASSENGERBIRTHDATE_TXT2),
                        SendKeys.of(BIRTHDATE2).into(BelmondBookingPage.PASSENGERBIRTHDATE_TXT2)
                ).otherwise(
                        Clear.field(BelmondBookingPage.PASSENGERBIRTHDATE_TXT),
                        SendKeys.of(BIRTHDATE).into(BelmondBookingPage.PASSENGERBIRTHDATE_TXT)),
                SelectFromOptions.byValue("PER").from(BelmondBookingPage.PASSENGERNATIONALITY_SELECT),
                SelectFromOptions.byValue("DNI").from(BelmondBookingPage.PASSENGERDOCUMENT_SELECT),
                Enter.theValue(String.valueOf((int) (Math.random() * 99999999))).into(BelmondBookingPage.PASSENGERDOCUMENT_TXT),
                SelectFromOptions.byValue("M").from(BelmondBookingPage.PASSENGERSEX_SELECT),
                Enter.theValue(PHONE).into(BelmondBookingPage.PASSENGERPHONE_TXT),
                Enter.theValue(EMAIL).into(BelmondBookingPage.PASSENGEREMAIL_TXT),
                Enter.theValue(EMAIL).into(BelmondBookingPage.PASSENGERCONFIRMEMAIL_TXT),
                Click.on(BelmondBookingPage.PASSENGERFORMCONTINUE_BUTTON),
                Check.whether(PurchaseSummary.isSummaryVisible(), Matchers.is(true)).otherwise(Click.on(BelmondBookingPage.PURCHASESUMMARY_BUTTON))
        );
    }
}
