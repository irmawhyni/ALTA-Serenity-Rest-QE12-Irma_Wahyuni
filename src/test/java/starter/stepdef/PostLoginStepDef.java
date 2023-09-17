package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PostLoginReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class PostLoginStepDef {

    @Steps
    PostLoginReqresAPI postLoginReqresAPI;
    @Given("Post login user with valid json")
    public void postLoginUserWithValidJson() {
        File json = new File(Constants.REQ_BODY + "/LoginSuccessful.json");
        postLoginReqresAPI.postLoginSuccessful(json);
    }

    @When("Send post user login")
    public void sendPostUserLogin() {
        SerenityRest.when().post(PostLoginReqresAPI.POST_LOGIN_SUCCESSFUL);
    }

    @And("Response body should contain token {string}")
    public void responseBodyShouldContainToken(String token) {
        SerenityRest.then()
                .body(ReqresResponses.TOKEN, equalTo(token));
    }

    @And("Validate post login user json schema")
    public void validatePostLoginUserJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/PostLoginSuccessful.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 2
    @Given("Post login user with valid json invalid password")
    public void postLoginUserWithValidJsonInvalidPassword() {
        File json = new File(Constants.REQ_BODY + "/LoginInvalidPassword.json");
        postLoginReqresAPI.postLoginSuccessful(json);
    }
    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    //Scenario 3
    @Given("Post login with valid json invalid username and password")
    public void postLoginWithValidJsonInvalidUsernameAndPassword() {
        File json = new File(Constants.REQ_BODY + "/LoginInvalidUsernameAndPassword.json");
        postLoginReqresAPI.postLoginSuccessful(json);
    }

    //Scenario 4
    @Given("Post login unsuccessful user with valid json")
    public void postLoginUnsuccessfulUserWithValidJson() {
        File json = new File(Constants.REQ_BODY + "/LoginUnsuccessful.json");
        postLoginReqresAPI.postLoginUnsuccessful(json);
    }

    @When("Send post user login unsuccessful")
    public void sendPostUserLoginUnsuccessful() {
        SerenityRest.when().post(PostLoginReqresAPI.POST_LOGIN_UNSUCCESSFUL);
    }

    @And("Response body should contain error {string}")
    public void responseBodyShouldContainError(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR, equalTo(error));
    }

    @And("Validate post login unsuccessful json schema")
    public void validatePostLoginUnsuccessfulJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA + "/PostUnsuccessful.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
