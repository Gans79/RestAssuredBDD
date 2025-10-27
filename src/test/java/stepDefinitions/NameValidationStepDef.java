package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.Utils;

public class NameValidationStepDef extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;





    @Given("User calls {string} with get request")
    public void call_url(String url) throws IOException {
        response = given().get(url);
    }

    @Then("the API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer int1) {
        assertEquals(response.getStatusCode(), 200);
    }

    @And("{string} and {string} exist in response body")
    public void assert_response_body(String name, String altName) {
        assertEquals(getJsonResponseValue(response, "name"), name);

        String alternateName = getJsonResponseValue(response, "alternate_names");
        assertThat(alternateName, containsString(altName));
    }

}
