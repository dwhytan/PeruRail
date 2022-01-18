package utils;

import com.google.common.base.Splitter;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

public class ScreenplayActors {

    @Before
    public void setTheStage(Scenario scenario) {
        OnStage.setTheStage(new OnlineCast());
    }

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @ParameterType(".*")
    public List<String> items(String listOfItems) {
        return Splitter.on(", ").trimResults().omitEmptyStrings().splitToList(listOfItems);
    }

    @ParameterType(".*")
    public List<String> items1(String listOfItems) {
        return Splitter.on(", ").trimResults().omitEmptyStrings().splitToList(listOfItems);
    }

}
