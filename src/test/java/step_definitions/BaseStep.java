package step_definitions;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigManager;

public abstract class BaseStep {
    static protected Response response;
    static protected RequestSpecification request;
    protected String baseURI;
    protected String authTokenEndpoint;
    protected String createBookingEndpoint;
    protected String getBookingEndpoint;
    protected static String accessToken;
    protected static Integer bookingId;


    public BaseStep(){
        baseURI= ConfigManager.getProperty("baseURI");
        authTokenEndpoint=ConfigManager.getProperty("auth.token.endpoint");
        createBookingEndpoint=ConfigManager.getProperty("create.booking.endpoint");
        getBookingEndpoint=ConfigManager.getProperty("get.booking.endpoint");

    }
}
