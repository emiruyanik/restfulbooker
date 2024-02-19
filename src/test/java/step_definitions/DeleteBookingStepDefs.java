package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import utils.APIUtils;

import java.util.List;

public class DeleteBookingStepDefs extends BaseStep {
    @When("The user sends a DELETE request to the delete booking endpoint with valid authorization and id")
    public void theUserSendsADELETERequestToTheDeleteBookingEndpointWithValidAuthorizationAndId() {
        response= APIUtils.sendDeleteRequest(request,createBookingEndpoint,accessToken,bookingId);


    }

    @And("Validate that specified user is deleted")
    public void validateThatSpecifiedUserIsDeleted() {
        response=APIUtils.sendGetRequest(request,createBookingEndpoint);
        List<Integer> listOfIds= response.jsonPath().getList("bookingid");
        Assertions.assertThat(listOfIds.contains(bookingId)).isFalse();
    }
}
