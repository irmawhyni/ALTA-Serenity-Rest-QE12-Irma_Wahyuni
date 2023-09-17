package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class PostLoginReqresAPI {
    public static String POST_LOGIN_SUCCESSFUL = Constants.BASE_URL + "/api/login";
    public static String POST_LOGIN_UNSUCCESSFUL = Constants.BASE_URL + "/api/login";

    @Step("Post login user")
    public void postLoginSuccessful(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post login unsuccessful user")
    public void postLoginUnsuccessful(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
