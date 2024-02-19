package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import utils.APIUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UpdateBookingStepDefs extends BaseStep{
    String body;
    @When("The user sends a PUT request to the update endpoint with details and specific id")
    public void theUserSendsAPUTRequestToTheUpdateEndpointWithDetailsAndSpecificId() throws FileNotFoundException {
        File file=new File("src/test/resources/features/test_data/update_booking.json");
        Scanner input=new Scanner(file);
        body="";
        while (input.hasNext()){
            body += input.nextLine();
        }


        response= APIUtils.sendPutRequest(request,createBookingEndpoint,accessToken,bookingId,body);

    }

    @And("The information updated as expected")
    public void theInformationUpdatedAsExpected() {
        response=APIUtils.sendGetRequest(request,createBookingEndpoint,bookingId);
        String actualInformation= response.body().asString();
        actualInformation=actualInformation.replaceAll(" ","");
        body=body.replaceAll(" ","");
        System.out.println(actualInformation);
        Assertions.assertThat(body).isEqualTo(actualInformation);
    }
}
