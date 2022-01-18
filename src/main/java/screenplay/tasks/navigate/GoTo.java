package screenplay.tasks.navigate;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class GoTo {
    public static Performable theHomePage() {
        return Task.where("{0} entra a la página principal",
                Open.browserOn().thePageNamed("home")
        );
    }
}
