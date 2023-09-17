package starter.reqres;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class GetSingleResourceReqresAPI {
    public static String GET_SINGLE_RESOURCE = Constants.BASE_URL + "/api/unknown/{id}";

    @Step("Get single resource")
    public void getSingleResource(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Get single resource not found")
    public void getSingleResourceNotFound(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
}
