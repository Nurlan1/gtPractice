package steps;

import entities.CustomResponse;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.APIRunner;
import utilities.Config;

import java.util.HashMap;
import java.util.Map;

public class GetAllClientsAPI {

    @Given("User hits all clients API {string} {string} {string} {string}")
    public void user_hits_all_clients_api(String path, String isArchived, String page, String size) {
       Map<String,Object> parameters=new HashMap<>();
       parameters.put("isArchived", isArchived);
       parameters.put("size", size);
       parameters.put("page", page);

        APIRunner.runGET(path, parameters);


    }
    @Then("User verifies that the total number of clients should be {string}")
    public void user_verifies_that_the_total_number_of_clients_should_be(String totalExpected) {
       int size= APIRunner.getCustomResponse().getResponses().size();

        Assert.assertEquals(totalExpected,size+"");
    }

}
