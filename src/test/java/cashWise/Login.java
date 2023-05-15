package cashWise;

import entities.CustomResponse;
import entities.RequestBody;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.lang.runtime.ObjectMethods;
import java.util.Collections;
import java.util.List;

public class Login {

    @Test
    public void authorization() throws JsonProcessingException {

        RequestBody requestBody = new RequestBody();
        requestBody.setEmail("user99@gmail.com");
        requestBody.setPassword("123456");

        Response response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post("https://backend.cashwise.us/api/myaccount/auth/login");
        System.out.println(response.statusCode());
        //System.out.println();
        //System.out.println(response.asString());

        ObjectMapper mapper = new ObjectMapper();
        CustomResponse customResponse=mapper.readValue((response.asString()), CustomResponse.class);

        System.out.println(customResponse.getJwt_token());
        System.out.println((customResponse.getMessage()));


    }


    @Test
    public void getIncomeCategories() {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyOTlAZ21haWwuY29tIiwiZXhwIjoxNjgxMzI1MTQyLCJpYXQiOjE2ODA3MjAzNDJ9.R76RUGjXiz-lO2CelaQpHuahsXaXRUuLEtFJThaoPNTtBCb4i6iQHAzf3AkjRdJ4JXjC7uVL4TZaCv6cK6UbEg";
        Response response = RestAssured.given().contentType(ContentType.JSON).auth().oauth2(token).get("https://backend.cashwise.us/api/myaccount/categories/income");
        System.out.println(response.statusCode());
        System.out.println();
        // System.out.println(response.asString());
        String title = response.jsonPath().get("[0].category_title");
        System.out.println(title);

        for(int i=0; i<5; i++){
            String path="["+i+"].flag";
            String path2="["+i+"].category_title";

            //System.out.println(path2);
            boolean flag=response.jsonPath().get(path);
            Assert.assertTrue(flag);
            String title2=response.jsonPath().get(path2);
            //System.out.println(title2);
            if(title2.isEmpty()){
                System.out.println(i+ " it's' title is empty");
            }
        }

        for(int i=0; i<2; i++){
            String path="["+i+"].flag";
            boolean flag=response.jsonPath().get(path);
            Assert.assertTrue(flag);
        }


        List<Boolean> flags = response.jsonPath().get("flag");
        //System.out.println(flags.size());
        for (Boolean flag : flags) {

                Assert.assertTrue(flag);
            }

    }
}
