package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class Register {
    public static String DIR = System.getProperty("user.dir");
    public static String POST_REGISTER_SUCCESSFUL = Constants.BASE_URL + "/api/register";
    public static String POST_REGISTER_UNSUCCESSFUL = Constants.BASE_URL + "/api/register";

    @Step("Post register successful")
    public void postRegisterSuccessful(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register unsuccessful")
    public void postRegisterUnsuccessful(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

}
