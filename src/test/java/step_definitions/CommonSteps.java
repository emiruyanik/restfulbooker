package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import org.assertj.core.api.Assertions;

public class CommonSteps extends BaseStep{

    @Given("The user is on the correct Base URI")
    public void theUserIsOnTheCorrectBaseURI() {
        request= new RequestSpecBuilder().setBaseUri(baseURI).build();
    }
    @Then("The status code should be as {int}")
    public void theStatusCodeShouldBeAs(int statusCode) {
        int actualStatusCode = response.getStatusCode();
        Assertions.assertThat(actualStatusCode).isEqualTo(statusCode);

    }

}
