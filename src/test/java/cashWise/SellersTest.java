package cashWise;

import com.github.javafaker.Faker;
import entities.CustomResponse;
import entities.RequestBody;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.tr.Fakat;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SellersTest {

    @Test
    public void getSingleSeller() throws JsonProcessingException {
        String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyOTlAZ21haWwuY29tIiwiZXhwIjoxNjgxODMxOTc2LCJpYXQiOjE2ODEyMjcxNzZ9.K7OQ8w-GBgjz9bB-3B_o6lhFFh7k9p3fW2ddrb2BqMSNxPy1oaXZNdxZZS7IjU1xO5OwQ5vFwVDz6CrZ2QXLvw";

        Response response= RestAssured.given().auth().oauth2(token).get("https://backend.cashwise.us/api/myaccount/sellers/77");
        //System.out.println(response.statusCode());
        //System.out.println(response.asString());

        Assert.assertEquals("Connecting to API  failed", 200, response.statusCode());

        ObjectMapper mapper=new ObjectMapper();
        CustomResponse customResponse=mapper.readValue((response.asString()), CustomResponse.class);

        Assert.assertNotNull("Company name is null",customResponse.getCompany_name());
        Assert.assertNotNull("Seller name ii null", customResponse.getSeller_name());
        Assert.assertFalse(customResponse.getCompany_name().trim().isEmpty());
        Assert.assertFalse(customResponse.getSeller_name().trim().isEmpty());
        Assert.assertFalse(customResponse.isIncome());


        System.out.println(customResponse.getCompany_name());
        System.out.println(customResponse.getSeller_name());
        System.out.println(customResponse.isIncome());

    }

    @Test
    public void createSeller(){
        String token=
                "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyOTlAZ21haWwuY29tIiwiZXhwIjoxNjgxODMxOTc2LCJpYXQiOjE2ODEyMjcxNzZ9.K7OQ8w-GBgjz9bB-3B_o6lhFFh7k9p3fW2ddrb2BqMSNxPy1oaXZNdxZZS7IjU1xO5OwQ5vFwVDz6CrZ2QXLvw";

        Faker faker=new Faker();
        String companyName=faker.company().name();
        String sellerName=faker.name().fullName();
        String phoneNumber=faker.phoneNumber().phoneNumber();
        String email=faker.internet().emailAddress();
        String address=faker.address().city();

        RequestBody requestBody=new RequestBody();

        requestBody.setCompany_name(companyName);
        requestBody.setSeller_name(sellerName);
        requestBody.setEmail(email);
        requestBody.setPhone_number(phoneNumber);
        requestBody.setAddress(address);

        Response response= RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).
                body(requestBody).post("https://backend.cashwise.us/api/myaccount/sellers");

        //System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());

        Assert.assertEquals(200, response.statusCode());
        int id=response.jsonPath().get("seller_id");
        String url="https://backend.cashwise.us/api/myaccount/sellers/"+id;


       Response response1=RestAssured.given().auth().oauth2(token).get(url);
       Assert.assertEquals(200,response1.statusCode());

        System.out.println("Get one seller");
        System.out.println(response1.asPrettyString());



    }

    @Test
    public void deleteSeller(){
        String token=
                "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyOTlAZ21haWwuY29tIiwiZXhwIjoxNjgxODMxOTc2LCJpYXQiOjE2ODEyMjcxNzZ9.K7OQ8w-GBgjz9bB-3B_o6lhFFh7k9p3fW2ddrb2BqMSNxPy1oaXZNdxZZS7IjU1xO5OwQ5vFwVDz6CrZ2QXLvw";
        int id=200;
        String url="https://backend.cashwise.us/api/myaccount/sellers/"+id;
        Response response=RestAssured.given().auth().oauth2(token).delete(url);
        Assert.assertEquals(200,response.statusCode());
        
    }



}
