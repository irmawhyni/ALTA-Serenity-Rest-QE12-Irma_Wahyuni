package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PatchUpdateStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Scenario 1
    @Given("Patch update user with valid json {string} and user id {int}")
    public void patchUpdateUserWithValidJsonWithIdId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        reqresAPI.patchUpdate(id,json);
    }

    @When("Send patch update user request")
    public void sendPatchUpdateUserRequest() {
        SerenityRest.when().patch(ReqresAPI.PATCH_UPDATE);
    }
    @And("Response body patch name was {string} and job was {string}")
    public void responseBodyPatchNameWasAndJobWas(String name, String job) {
        SerenityRest.and().body(ReqresResponses.NAME,equalTo(name));
        SerenityRest.and().body(ReqresResponses.JOB,equalTo(job));
    }

    @And("Validate patch update user json schema {string}")
    public void validatePatchUpdateUserJsonSchema(String jsonFile) {
        File json = new File((Constants.JSON_SCHEMA + jsonFile));
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 2
    @Given("Patch update user with empty name and job with id {int}")
    public void patchUpdateUserWithEmptyNameAndJobWithId(int id) {
        File json = new File(Constants.REQ_BODY + "/UpdateUser.json");
        reqresAPI.patchUpdate(id, json);
    }
}
