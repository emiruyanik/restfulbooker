package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import pojo.request.AccessToken;

public class CreateTokenStepDefs extends BaseStep{
    private static final Logger logger = LogManager.getLogger(CreateTokenStepDefs.class);



    @When("The user sends a POST request {string} as username and {string} as password to the create token endpoint")
    public void theUserSendsAPOSTRequestAsUsernameAndAsPasswordToTheCreateTokenEndpoint(String username, String password) {
        AccessToken token=new AccessToken(username,password);
        response= RestAssured.given().spec(request).contentType("application/json").body(token).when().post(authTokenEndpoint);
        accessToken= response.jsonPath().getString("token");
    }


    @And("The access token should not be empty or null")
    public void theAccessTokenShouldNotBeEmptyOrNull() {
        Assertions.assertThat(accessToken).isNotEmpty();
        Assertions.assertThat(accessToken).isNotNull();
        System.out.println(accessToken);
    }
}
