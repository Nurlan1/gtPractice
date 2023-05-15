package cashWise;

import com.github.javafaker.Faker;
import entities.CustomResponse;
import entities.RequestBody;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utilities.APIRunner;
import utilities.Config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientsTests {

    @Test
    public void createClients() {
        String path = "/feature/api/myaccount/clients";
        RequestBody requestBody = new RequestBody();
        Faker faker = new Faker();

        for (int i = 0; i <= 5; i++) {
            requestBody.setCompany_name(faker.company().name());
            requestBody.setClient_name(faker.name().fullName());
            requestBody.setPhone_number(faker.phoneNumber().phoneNumber());
            requestBody.setAddress(faker.address().city());

            List<Integer> tags = new ArrayList<>();
            tags.add(81);
            tags.add(89);

            requestBody.setTags_id(tags);

            APIRunner.runPOST(path, requestBody);

        }

    }

    @Test
    public void getClient() {
        String path = "/feature/api/myaccount/clients/1058";
        APIRunner.runGET(path);
        System.out.println(APIRunner.getCustomResponse().getCompany_name());
        System.out.println(APIRunner.getCustomResponse().getClient_name());
        System.out.println(APIRunner.getCustomResponse().getEmail());

        for (int i = 0; i < APIRunner.getCustomResponse().getTags().size(); i++) {
            System.out.println(APIRunner.getCustomResponse().getTags().get(i).getNameTag());
            System.out.println("Company name of Tag: " + APIRunner.getCustomResponse().getTags().get(i).getCompany().getCompanyName());
        }
    }

    @Test
    public void getAllClient() {
        String path = "https://backend.cashwise.us/api/myaccount/clients";
        String token = Config.getValue("cashWiseToken");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("isArchived", false);
        parameters.put("page", 1);
        parameters.put("size", 10);

        Response response = RestAssured.given().auth().oauth2(token).params(parameters).get(path);
        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());


    }

    List<Integer> listOfId = new ArrayList<>();

    @Test
    public void practice() {

        String path = "/feature/api/myaccount/clients?isArchived=false&page=1&size=10";
        APIRunner.runGET(path);
        // System.out.println(APIRunner.getCustomResponse());
        for (int i = 0; i < APIRunner.getCustomResponse().getResponses().size() - 5; i++) {
            String id = APIRunner.getCustomResponse().getResponses().get(i).getClient_id();
            Integer idInInt = Integer.parseInt(id);
            listOfId.add(idInInt);
        }
        for (Integer id : listOfId) {
            System.out.println(id);
        }
    }

    @Test
    public void practice2() {

        String path = "https://backend.cashwise.us/api/myaccount/clients/archive/unarchive";
        String token = Config.getValue("cashWiseToken");
        Map<String, Object> params = new HashMap<>();

        params.put("clientsIdsForArchive", 1052);
        params.put("archive", true);
        params.put("language", "en-GB");
        Response response = RestAssured.given().auth().oauth2(token).params(params).post(path);
        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());

    }

    @Test
    public void practice3() {
        List<Integer> ids = new ArrayList<>();
        String path = "/api/myaccount/clients?isArchived=false&page=1&size=10";
        APIRunner.runGET(path);
        CustomResponse customResponse = APIRunner.getCustomResponse();
        System.out.println(customResponse.getResponses().size());

        for (int i = 0; i < customResponse.getResponses().size(); i++) {
            String id = customResponse.getResponses().get(i).getClient_id();
            Integer idInInt = Integer.parseInt(id);
            ids.add(idInInt);
        }
        for (Integer id : ids) {
            System.out.println(id);
        }
        System.out.println(ids.size());


        String path2 = "https://backend.cashwise.us/api/myaccount/clients/archive/unarchive";
        String token = Config.getValue("cashWiseToken");
        Map<String, Object> params = new HashMap<>();
        for (int i = 0; i < ids.size(); i++) {

            params.put("clientsIdsForArchive", ids.get(i));
            params.put("archive", true);
            params.put("language", "en-GB");
            Response response = RestAssured.given().auth().oauth2(token).params(params).post(path2);
            System.out.println(response.statusCode());
            System.out.println(response.asPrettyString());

        }
    }


}
