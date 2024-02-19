package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pojo.response.BookingRes;
import utils.APIUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAllBookingIdsStepDefs extends BaseStep {
    Map<String,String> queryParameters=new HashMap<>();
    List<Integer> ids;
    BookingRes bookingRes;
    @When("The user sends a GET request to get all booking endpoint with {string} as {string} and {string} as {string}")
    public void theUserSendsAGETRequestToGetAllBookingEndpointWithAsAndAs(String firstname, String firstnameOfUser, String lastname, String lastnameOfUser) {
        queryParameters.put(firstname,firstnameOfUser);
        queryParameters.put(lastname,lastnameOfUser);
        System.out.println(queryParameters);
        response= APIUtils.sendGetRequest(request,createBookingEndpoint,queryParameters);
    }

    @And("The user should get only an id")
    public void theUserShouldGetOnlyAnId() {
        ids= response.jsonPath().getList("bookingid");
        Assertions.assertThat(ids.size()).isGreaterThan(0);
    }

    @And("The user's firstname and lastname which has getting id should match with specified {string} and {string}")
    public void theUserSFirstnameAndLastnameWhichHasGettingIdShouldMatchWithSpecifiedAnd(String firstname, String lastname) {
        ids.forEach(id-> {
            response=APIUtils.sendGetRequest(request,createBookingEndpoint,id);
            bookingRes = response.as(BookingRes.class);
            Assertions.assertThat(bookingRes.getFirstname()).isEqualTo(firstname);
            Assertions.assertThat(bookingRes.getLastname()).isEqualTo(lastname);
        });
    }
}
