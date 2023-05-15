package cashWise;

import com.github.javafaker.Faker;
import entities.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import utilities.APIRunner;
import utilities.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankAccountTests {

    @Test
    public void creatingBankAccount() {

        String path = "/feature/api/myaccount/bankaccount";
        RequestBody requestBody = new RequestBody();
        Faker faker = new Faker();
        Random random = new Random();
        for (int i = 0; i <= 2; i++) {
            List<String> paymentTypes = new ArrayList<>();
            paymentTypes.add("ELECTRONIC_MONEY_TRANSFER");
            paymentTypes.add("BANK");
            paymentTypes.add("CASH");
            requestBody.setType_of_pay(paymentTypes.get(random.nextInt(0, 2)));
            requestBody.setBank_account_name(faker.company().name());
            requestBody.setBalance(random.nextInt(100, 5000));
            APIRunner.runPOST(path, requestBody);
            System.out.println(APIRunner.getCustomResponse().getBank_account_name());

        }
    }

    @Test
    public void createBankAccountVerification(){

        String path = "/feature/api/myaccount/bankaccount";
        RequestBody requestBody=new RequestBody();
        APIRunner.runPOST(path,requestBody);
        Assert.assertEquals("200", APIRunner.getCustomResponse().getStatusCode());

        

    }

    @Test
    public void updateBalanceAndDescription(){
    //TASK 2 abd 3
    String token=Config.getValue("cashWiseToken");
        String path= "/feature/api/myaccount/bankaccount";
      APIRunner.runGetList(path);
      APIRunner.getResponseList();
      RequestBody requestBody=new RequestBody();
        Faker faker = new Faker();

      for(int i=0; i<APIRunner.getResponseList().length; i++){
          String id=APIRunner.getResponseList()[i].getId();
          String url="https://backend.cashwise.us/api/myaccount/bankaccount/"+id;

          requestBody.setType_of_pay(APIRunner.getResponseList()[i].getType_of_pay());
          requestBody.setBank_account_name(APIRunner.getResponseList()[i].getBank_account_name());
          requestBody.setBalance(0);

          String description=APIRunner.getResponseList()[i].getDescription();
          if(description==null){
              requestBody.setDescription(faker.shakespeare().romeoAndJulietQuote());
          }
          Response response= RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(requestBody).put(url);
          System.out.println(response.statusCode());
          System.out.println(response.asPrettyString());
      }
    }

    @Test
    public void add5000$(){
        //TASK 4
        String token=Config.getValue("cashWiseToken");
        String path= "/feature/api/myaccount/bankaccount";
        APIRunner.runGetList(path);
        APIRunner.getResponseList();
        RequestBody requestBody=new RequestBody();

        for(int i=0; i<APIRunner.getResponseList().length; i++){
            String id=APIRunner.getResponseList()[i].getId();
            String url="https://backend.cashwise.us/api/myaccount/bankaccount/"+id;

            requestBody.setType_of_pay(APIRunner.getResponseList()[i].getType_of_pay());
            requestBody.setBank_account_name(APIRunner.getResponseList()[i].getBank_account_name());
            requestBody.setBalance(APIRunner.getResponseList()[i].getBalance()+5000);
            Response response= RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(requestBody).put(url);
            System.out.println(response.statusCode());
            System.out.println(response.asPrettyString());
        }
    }

    @Test
    public void deleteBankAccount(){
        String path= "/feature/api/myaccount/bankaccount/7";
        APIRunner.runDELETE(path);
    }
    @Test
    public void deleteBankAccounts(){

        String path= "/feature/api/myaccount/bankaccount";
        APIRunner.runGetList(path);
        System.out.println(APIRunner.getResponseList().length);

       for(int i=0; i<APIRunner.getResponseList().length; i++){
           if(APIRunner.getResponseList()[i].getBalance()>1000 && APIRunner.getResponseList()[i].getBalance()<2000){
              String id= APIRunner.getResponseList()[i].getId();
               //System.out.println(id);
               String path2= "/feature/api/myaccount/bankaccount/" +id;
               APIRunner.runDELETE(path2);
           }
       }
        System.out.println("After deletion");
       APIRunner.runGetList(path);
        System.out.println(APIRunner.getResponseList().length);
        for(int i=0; i<APIRunner.getResponseList().length; i++){
            System.out.println("Bank name: "+ APIRunner.getResponseList()[i].getBank_account_name());
            System.out.println("Balance: "+ APIRunner.getResponseList()[i].getBalance());
            System.out.println();
        }
    }




}
