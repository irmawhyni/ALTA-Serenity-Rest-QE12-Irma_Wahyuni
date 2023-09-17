package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.DelayedResponse;
import starter.utils.Constants;

import java.io.File;

public class DelayedResponseStepDef {
    @Steps
    DelayedResponse delayedResponse;
    @Given("Get delayed response with parameter {int}")
    public void getDelayedResponseWithParameter(int id) throws InterruptedException {
        delayedResponse.setGetDelayedResponse(id);
    }

    @When("Send get delayed response request")
    public void sendGetDelayedResponseRequest() {
        SerenityRest.when().get(DelayedResponse.GET_DELAYED_RESPONSE);
    }

    @And("Validate get delayed response json schema")
    public void validateGetDelayedResponseJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/GetDelayedResponse.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
