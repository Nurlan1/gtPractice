package steps;

import entities.RequestBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apiguardian.api.API;
import utilities.APIRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E2ECreateClient {


    Map<String, String> apiMapData=new HashMap<>();
    @Given("User hit and POST a client {string}")
    public void user_hit_and_post_a_client(String endpoint, io.cucumber.datatable.DataTable dataTable) {

        List<Integer> tagsId=new ArrayList<>();
        tagsId.add(Integer.parseInt(apiMapData.get("tags_id")));
       apiMapData=dataTable.asMap(String.class,String.class);
        RequestBody requestBody=new RequestBody();
        requestBody.setCompany_name(apiMapData.get("company_name"));
        requestBody.setClient_name(apiMapData.get("client_name"));
        requestBody.setEmail(apiMapData.get("email"));
        requestBody.setPhone_number(apiMapData.get("phone_number"));
        requestBody.setAddress(apiMapData.get("address"));
      //  requestBody.setTags_id(tagsId.get(0));
        APIRunner.runPOST(endpoint,requestBody);

    }


    @When("User navigate to cahwise home page")
    public void user_navigate_to_cahwise_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User navigate to Client page")
    public void user_navigate_to_client_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User verify data from Backend and Frontend")
    public void user_verify_data_from_backend_and_frontend() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




}
