package starter.reqres;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class DeleteUserAPI {
    public static String DELETE_USER = Constants.BASE_URL + "/api/users/{id}";

    @Step("Delete a user")
    public void deleteUser(int id) {
        SerenityRest.given().pathParam(ReqresResponses.ID, id);
    }

    @Step("Delete invalid user")
    public void deleteInvalidUser(String id) {
        SerenityRest.given()
                .pathParam(ReqresResponses.ID, id);
    }

}
