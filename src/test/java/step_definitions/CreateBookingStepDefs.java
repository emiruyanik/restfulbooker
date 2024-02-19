package step_definitions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import pojo.request.Bookingdates;
import pojo.request.CreateBookingReq;
import pojo.response.CreateBookingRes;
import utils.APIUtils;

import java.io.File;
import java.util.Map;

public class CreateBookingStepDefs extends BaseStep{
    Map<String,String> mapRequest;
    CreateBookingReq createBookingReq;
    Bookingdates bookingdates;

    @When("The user sends a POST request to the create booking endpoint with following details:")
    public void theUserSendsAPOSTRequestToTheCreateBookingEndpointWithFollowingDetails(DataTable dataTable) {
        mapRequest=dataTable.asMap(String.class, String.class);
        bookingdates =new Bookingdates(mapRequest.get("checkin"), mapRequest.get("checkout"));
        createBookingReq= new CreateBookingReq();
        createBookingReq.setFirstname(mapRequest.get("firstname"));
        createBookingReq.setLastname(mapRequest.get("lastname"));
        createBookingReq.setTotalprice(Integer.parseInt(mapRequest.get("totalprice")));
        createBookingReq.setDepositpaid(Boolean.parseBoolean(mapRequest.get("depositpaid")));
        createBookingReq.setAdditionalneeds(mapRequest.get("additionalneeds"));
        createBookingReq.setBookingdates(bookingdates);

        response= APIUtils.sendPostRequest(request,createBookingEndpoint,createBookingReq);
        bookingId= response.jsonPath().getInt("bookingid");
    }

    @And("The booking id should not be empty or null")
    public void theBookingIdShouldNotBeEmptyOrNull() {
        Assertions.assertThat(bookingId).isNotNull();
        Assertions.assertThat(bookingId).isGreaterThan(0);
    }

    @And("The booking object in response should match with given datas")
    public void theBookingObjectInResponseShouldMatchWithGivenDatas() {
        SoftAssertions softAssertions=new SoftAssertions();
        CreateBookingRes createBookingRes=response.as(CreateBookingRes.class);

        softAssertions.assertThat(createBookingRes.getBooking().getFirstname()).isEqualTo(createBookingReq.getFirstname());
        softAssertions.assertThat(createBookingRes.getBooking().getLastname()).isEqualTo(createBookingReq.getLastname());
        softAssertions.assertThat(createBookingRes.getBooking().getAdditionalneeds()).isEqualTo(createBookingReq.getAdditionalneeds());
        softAssertions.assertThat(createBookingRes.getBooking().getBookingdates().getCheckin()).isEqualTo(createBookingReq.getBookingdates().getCheckin());
        softAssertions.assertThat(createBookingRes.getBooking().getBookingdates().getCheckout()).isEqualTo(createBookingReq.getBookingdates().getCheckout());
        softAssertions.assertThat(createBookingRes.getBooking().getTotalprice()).isEqualTo(createBookingReq.getTotalprice());
        softAssertions.assertThat(createBookingRes.getBooking().isDepositpaid()).isEqualTo(createBookingReq.isDepositpaid());
        softAssertions.assertAll();
    }
}
