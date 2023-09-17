package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.DeleteUserAPI;

public class DeleteUserStepdef {
    @Steps
    DeleteUserAPI deleteUserAPI;

    //Scenario
    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalidId(String id) {
        deleteUserAPI.deleteInvalidUser(id);
    }
}
