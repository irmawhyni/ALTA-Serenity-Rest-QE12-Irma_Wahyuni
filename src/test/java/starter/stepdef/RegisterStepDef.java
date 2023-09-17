package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.Register;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterStepDef {

    @Steps
    Register register;

    //Scenario 1
    @Given("Register user with valid json")
    public void registerUserWithValidJson() {
        File json = new File(Constants.REQ_BODY+"/RegisterSuccessful.json");
        register.postRegisterSuccessful(json);
    }
    @When("Send post user register success")
    public void sendPostUserRegisterSuccess() {
        SerenityRest.when().post(Register.POST_REGISTER_SUCCESSFUL);
    }

    @And("Response body should contain id {int} and token {string}")
    public void responseBodyShouldContainIdAndToken(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponses.ID,equalTo(id))
                .body(ReqresResponses.TOKEN,equalTo(token));
    }
    @And("Validate post register success json")
    public void validatePostRegisterSuccessJson() {
        File json = new File((Constants.JSON_SCHEMA+"/PostRegisterSuccessful.json"));
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 2
    @Given("post register unsuccessful with valid json")
    public void postRegisterUnsuccessfulWithValidJson() {
        File json = new File(Constants.REQ_BODY + "/RegisterUnsuccessful.json");
        register.postRegisterUnsuccessful(json);
    }

    @When("Send post user register unsuccessful")
    public void sendPostUserRegisterUnsuccessful() {
        SerenityRest.when().post(Register.POST_REGISTER_UNSUCCESSFUL);
    }

    @And("Validate post register unsuccessful json")
    public void validatePostRegisterUnsuccessfulJson() {
        File json = new File(Constants.JSON_SCHEMA+"/PostUnsuccessful.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
