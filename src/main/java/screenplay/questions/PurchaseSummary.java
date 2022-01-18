package screenplay.questions;

import net.serenitybdd.screenplay.Question;
import screenplay.user_interfaces.BelmondBookingPage;

public class PurchaseSummary {
    public static Question<Boolean> isSummaryVisible() {
        return actor ->  BelmondBookingPage.PURCHASESUMMARY_DIV.resolveFor(actor).isCurrentlyVisible();
    }
}
