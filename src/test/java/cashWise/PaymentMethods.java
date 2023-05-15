package cashWise;

import com.github.javafaker.Faker;
import entities.CustomResponse;
import entities.RequestBody;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class PaymentMethods {

    @Test
    public  void createPaymentMMethod(){

        String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyOTlAZ21haWwuY29tIiwiZXhwIjoxNjgxOTIwNjU4LCJpYXQiOjE2ODEzMTU4NTh9.VdxOJJAJ7aZY_fw9dqP9RurCG95j1ikVq9NysmFXQVLGSrkaL81lUvqr8N8n3ZD1hvrAfukGh2ChdYwBMABvnw";
        RequestBody requestBody=new RequestBody();
        requestBody.setType_of_pay("BANK");
        requestBody.setBank_account_name("Bank of America");
        requestBody.setBalance(140000);
        requestBody.setDescription("BofA account");

        Response response= RestAssured.given().auth().oauth2(token).contentType((ContentType.JSON)).body(requestBody).post("https://backend.cashwise.us/api/myaccount/bankaccount");
        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());
    }

    @Test
    public void createFakerPayment(){
        String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyOTlAZ21haWwuY29tIiwiZXhwIjoxNjgxOTIwNjU4LCJpYXQiOjE2ODEzMTU4NTh9.VdxOJJAJ7aZY_fw9dqP9RurCG95j1ikVq9NysmFXQVLGSrkaL81lUvqr8N8n3ZD1hvrAfukGh2ChdYwBMABvnw";

Random random=new Random();
Faker faker=new Faker();



        for(int i=0; i<=13; i++){


            List<String> paymentTypes=new ArrayList<>();
            paymentTypes.add("ELECTRONIC_MONEY_TRANSFER");
            paymentTypes.add("BANK");
            paymentTypes.add("CASH");
            RequestBody requestBody=new RequestBody();

            requestBody.setType_of_pay(paymentTypes.get(random.nextInt(0,2)));
            requestBody.setBank_account_name(faker.company().name()+random.nextInt(1,10000));
            requestBody.setBalance(random.nextInt(200,5000));

            Response response=RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(requestBody).post("https://backend.cashwise.us/api/myaccount/bankaccount");
            System.out.println(response.statusCode());
            System.out.println(response.asPrettyString());
        }
    }

    @Test
    public void deleteAccounts() throws JsonProcessingException {

        String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyOTlAZ21haWwuY29tIiwiZXhwIjoxNjgxOTIwNjU4LCJpYXQiOjE2ODEzMTU4NTh9.VdxOJJAJ7aZY_fw9dqP9RurCG95j1ikVq9NysmFXQVLGSrkaL81lUvqr8N8n3ZD1hvrAfukGh2ChdYwBMABvnw";
        Response response= RestAssured.given().auth().oauth2(token).get("https://backend.cashwise.us/api/myaccount/bankaccount");
        System.out.println(response.statusCode());
       // System.out.println(response.asPrettyString());


        ObjectMapper mapper=new ObjectMapper();
        CustomResponse [] customResponse=mapper.readValue(response.asString(), CustomResponse[].class);
        int before=customResponse.length;
        List <String> listOfId = new ArrayList<>();

        for(int i=0; i< customResponse.length; i++){
            if( customResponse[i].getBalance()<1000){
               listOfId.add(customResponse[i].getId());
           }
        }
        System.out.println(listOfId);

        for(int i=0; i<listOfId.size(); i++){
            String id=listOfId.get(i);
            String  url="https://backend.cashwise.us/api/myaccount/bankaccount/"+id;
            Response response1=RestAssured.given().auth().oauth2(token).delete(url);
            System.out.println("Deletion status: "+response1.statusCode());
        }
        int after= customResponse.length;
        System.out.println(before);
        System.out.println(after);

        //Assert.assertTrue();
    }






    }

