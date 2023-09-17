package starter.reqres;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class DelayedResponse {
    public static String GET_DELAYED_RESPONSE = Constants.BASE_URL + "/api/users?delay={id}";

    @Step("Get delayed response")
    public void setGetDelayedResponse(int id) throws InterruptedException {
        SerenityRest.given().pathParam("id", id);
        Thread.sleep(3000);
    }
}
