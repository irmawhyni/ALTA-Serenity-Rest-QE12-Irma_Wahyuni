package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GetSingleResourceReqresAPI;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class GetSingleResourceStepDef {

    @Steps
    GetSingleResourceReqresAPI getSingleResourceReqresAPI;

    //Scenario 1
    @Given("Get single resource with id {int}")
    public void getSingleResourceWithId(int id) {
        getSingleResourceReqresAPI.getSingleResource(id);
    }

    @When("Send get single resource request")
    public void sendGetSingleResourceRequest() {
        SerenityRest.when().get(GetSingleResourceReqresAPI.GET_SINGLE_RESOURCE);
    }
    @And("Validate get single resource json schema")
    public void validateGetSingleResourceJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/GetSingleResource.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 2
    @Given("Get single resource with invalid id {int}")
    public void getSingleResourceWithInvalidId(int id) {
        getSingleResourceReqresAPI.getSingleResource(id);
    }

    //Scenario 3
    @Given("Get single resource not found with id {int}")
    public void getSingleResourceNotFoundWithId(int id) {
        getSingleResourceReqresAPI.getSingleResourceNotFound(id);
    }

    @When("Send get single resource not found request")
    public void sendGetSingleResourceNotFoundRequest() {
        SerenityRest.when().get(GetSingleResourceReqresAPI.GET_SINGLE_RESOURCE);
    }
}