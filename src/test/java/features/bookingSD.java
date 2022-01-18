package features;

import io.cucumber.java.es.*;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebElement;
import screenplay.questions.PurchaseSummary;
import screenplay.questions.Travel;
import screenplay.tasks.choose.Choose;
import screenplay.tasks.fill.Form;
import screenplay.tasks.interact.Select;
import screenplay.tasks.navigate.GoTo;
import screenplay.tasks.set.Set;

public class bookingSD {
    @Dado("que {actor} ingresa a la web de Peru Rail para reservar su viaje en tren")
    public void actor_goes_to_homepage(Actor actor) {
        actor.wasAbleTo(GoTo.theHomePage());
    }

    @Cuando("{actor} selecciona el tipo de viaje: {string}")
    public void actor_chooses_type_of_travel(Actor actor, String tipo) {
        switch (tipo) {
            case "Ida y Vuelta" -> actor.attemptsTo(Choose.roundtripTravel());
            case "Solo Ida" -> actor.attemptsTo(Choose.oneWayTravel());
        }
    }

    @Y("después {actor} selecciona el destino: {string}")
    public void actor_chooses_destination(Actor actor, String destino) {
        actor.attemptsTo(Choose.destination(destino));
    }

    @E("indicará la ruta de viaje: {string}")
    public void actor_chooses_route(String ruta) {
        OnStage.theActorInTheSpotlight().attemptsTo(Choose.route(ruta));
    }

    @Y("luego {actor} escogera el tren de preferencia: {string}")
    public void actor_chooses_train(Actor actor, String tren) {
        actor.attemptsTo(Choose.train(tren));
    }

    @Pero("deberá de indicar la fecha de salida: {string}")
    public void actor_sets_departure_date(String fecha) {
        BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).evaluateJavascript("arguments[0].removeAttribute('readonly','readonly')", BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).find(By.id("salida")));
        BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).evaluateJavascript("arguments[0].removeAttribute('readonly','readonly')", BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).find(By.id("regreso")));
        BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).evaluateJavascript("arguments[0].removeAttribute('readonly','readonly')", BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).find(By.id("countParentsChildren")));
        OnStage.theActorInTheSpotlight().attemptsTo(Set.departureDate(fecha));
    }

    @Entonces("luego enviará la consulta")
    public void actor_looks_for_tickets() {
        OnStage.theActorInTheSpotlight().attemptsTo(Select.findTrainTickets());
    }

    @Y("posteriormente {actor} escogerá su Cabina")
    public void actor_chooses_cabin(Actor actor) {
        actor.attemptsTo(Choose.cabin());
    }

    @E("ingresará sus datos personales")
    public void actor_fills_form() {
        WebElement elementName = BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).find(By.xpath("//input[@id='txt_fecha_nacimiento[suite][cab1][1]' or @id='formPasajero1-fecNacimiento']"));
        BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).evaluateJavascript("arguments[0].removeAttribute('readonly','readonly')", elementName);
        OnStage.theActorInTheSpotlight().attemptsTo(Form.ofPassenger());
    }

    @Y("{actor} seleccionará su tramo de preferencia")
    public void actor_chooses_trip(Actor actor) {
        actor.attemptsTo(Choose.trip());
    }

    @Entonces("{actor} deberá de visualizar su resumen de compra")
    public void actor_should_see_his_purchase_summary(Actor actor) {
        actor.should(GivenWhenThen.seeThat(PurchaseSummary.isSummaryVisible(), Matchers.is(true)));
        BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).waitFor(5).seconds();
    }
}
