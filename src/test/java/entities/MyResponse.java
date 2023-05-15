package entities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class MyResponse {

    @Test
    public void authRequest(){
        String body="{\n" +
                "  \"email\": \"user99@gmail.com\",\n" +
                "  \"password\": \"123456\"\n" +
                "}";
        String b="{\n" +
                "  \"email\": \"cashwise@gmail.com\",\n" +
                "  \"password\": \"123123\"\n" +
                "}";
        Response response=RestAssured.given().contentType(ContentType.JSON).body(b).post("https://backend.cashwise.us/api/myaccount/auth/login");
        System.out.println(response.asString());
    }

    @Test
    public void logIn(){
        Response response=RestAssured.post("https://backend.cashwise.us/api/myaccount/auth/login");
        System.out.println(response.asString());
       // RestAssured.given().contentType(ContentType.JSON).auth().oauth2()get("https://backend.cashwise.us/api/myaccount/auth/login").
    }
}
