package step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import pojo.response.BookingRes;
import utils.APIUtils;

import java.util.Map;

public class GetBookingStepDefs extends BaseStep {

    @When("The user send a GET request to the get booking endpoint with id as {int}")
    public void theUserSendAGETRequestToTheGetBookingEndpointWithIdAs(int bookingId) {
        response= APIUtils.sendGetRequest(request,getBookingEndpoint,bookingId);
    }


}
