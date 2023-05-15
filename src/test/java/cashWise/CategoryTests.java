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
import utilities.APIRunner;
import utilities.Config;

public class CategoryTests {

    @Test
    public void deleteCategories() throws JsonProcessingException {

        String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyOTlAZ21haWwuY29tIiwiZXhwIjoxNjgxOTIwNjU4LCJpYXQiOjE2ODEzMTU4NTh9.VdxOJJAJ7aZY_fw9dqP9RurCG95j1ikVq9NysmFXQVLGSrkaL81lUvqr8N8n3ZD1hvrAfukGh2ChdYwBMABvnw";
        Response response= RestAssured.given().auth().oauth2(token).get("https://backend.cashwise.us/api/myaccount/categories/income");
        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());
        ObjectMapper mapper=new ObjectMapper();
        CustomResponse customResponse=mapper.readValue(response.asString(), CustomResponse.class);

        System.out.println(response.asPrettyString());

    }

    @Test
    public void createCategories(){
        String path= "/feature/api/myaccount/categories";
        RequestBody requestBody=new RequestBody();
        Faker faker=new Faker();
        for(int i=0; i<=8; i++){
            requestBody.setCategory_title(faker.name().title());
            requestBody.setCategory_description(faker.commerce().productName());
            requestBody.setFlag(true);
            APIRunner.runPOST(path,requestBody);
        }

        for(int i=0; i<=8; i++){
            requestBody.setCategory_title(faker.name().title());
            requestBody.setCategory_description(faker.chuckNorris().fact());
            requestBody.setFlag(false);
            APIRunner.runPOST(path,requestBody);
        }
        String path2= "/feature/api/myaccount/categories";
        APIRunner.runGetList(path2);
        for(int i=0; i< APIRunner.getResponseList().length; i++){
            Assert.assertNotNull(APIRunner.getResponseList()[i].getCategory_title());
            Assert.assertFalse(APIRunner.getResponseList()[i].getCategory_title().trim().isEmpty());

        }
    }

    @Test
    public void changeCategoryType(){
        String path= "/feature/api/myaccount/categories/income";
        String token= Config.getValue("cashWiseToken");
        APIRunner.runGetList(path);
        RequestBody requestBody=new RequestBody();
        for(int i=0; i<APIRunner.getResponseList().length; i++){
            String id=APIRunner.getResponseList()[i].getCategory_id();
            String url="https://backend.cashwise.us/api/myaccount/categories/"+id;
            requestBody.setCategory_title(APIRunner.getResponseList()[i].getCategory_title());
            requestBody.setCategory_description(APIRunner.getResponseList()[i].getCategory_description());
            requestBody.setFlag(false);
            Response response=RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(requestBody).put(url);
            System.out.println(response.statusCode());
            System.out.println(response.asPrettyString());
        }
    }

    @Test
    //TASK 8
    public void updateCategoryTitle(){
        String path= "/feature/api/myaccount/categories";
        String token= Config.getValue("cashWiseToken");
        APIRunner.runGetList(path);
        RequestBody requestBody=new RequestBody();

        System.out.println(APIRunner.getResponseList().length);
        for(int i=0; i<APIRunner.getResponseList().length; i++){
            String title=APIRunner.getResponseList()[i].getCategory_title();
            String [] words=title.split("\\s+");
            System.out.println(words.length);
            if(words.length>=1){
                requestBody.setCategory_title(words[0]);
                requestBody.setDescription(APIRunner.getResponseList()[i].getDescription());
                requestBody.setFlag(false);
                String id=APIRunner.getResponseList()[i].getCategory_id();
                String url="https://backend.cashwise.us/api/myaccount/categories/"+id;
                Response response=RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(requestBody).put(url);
                System.out.println(response.statusCode());
                System.out.println(response.asPrettyString());
            }
        }
    }

        @Test
        public void deleteCategory(){
        String pathGet= "/feature/api/myaccount/categories";
        APIRunner.runGetList(pathGet);
        for(int i=0; i<APIRunner.getResponseList().length; i++){
            String id=APIRunner.getResponseList()[i].getCategory_id();
            String path2= "/feature/api/myaccount/categories/" +id;
            APIRunner.runDELETE(path2);
        }
    }

    @Test
    public void updateCategoryDescription(){
        String path= "/feature/api/myaccount/categories";
        String token= Config.getValue("cashWiseToken");
        APIRunner.runGetList(path);
        RequestBody requestBody=new RequestBody();
        Faker faker=new Faker();
        System.out.println(APIRunner.getResponseList().length);
        for(int i=0; i<APIRunner.getResponseList().length; i++){
            String id=APIRunner.getResponseList()[i].getCategory_id();
            String url="https://backend.cashwise.us/api/myaccount/categories/"+id;
            requestBody.setCategory_description(faker.shakespeare().romeoAndJulietQuote());
            requestBody.setFlag(false);
            requestBody.setCategory_title(APIRunner.getResponseList()[i].getCategory_title());

            Response response=RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(requestBody).put(url);
            System.out.println(response.statusCode());
            System.out.println(response.asPrettyString());
        }

    }

    @Test
    public void createIncomeCategory(){
        String path= "/feature/api/myaccount/categories";
        RequestBody requestBody=new RequestBody();
        Faker faker=new Faker();
        for(int i=0; i<=5; i++){
            requestBody.setCategory_title(faker.name().title());
            requestBody.setCategory_description(faker.shakespeare().romeoAndJulietQuote());
            requestBody.setCategory_description(faker.commerce().productName());
            requestBody.setFlag(true);
            APIRunner.runPOST(path,requestBody);
        }


}
    @Test
    public void updateIncomeDescription(){
      String path= "/feature/api/myaccount/categories/income";
      RequestBody requestBody=new RequestBody();
      APIRunner.runGetList(path);

      for(int i=0; i<APIRunner.getResponseList().length; i++){
          System.out.println(APIRunner.getResponseList().length);
          String id=APIRunner.getResponseList()[i].getCategory_id();
          String url= "/feature/api/myaccount/categories/" +id;
          requestBody.setCategory_title(APIRunner.getResponseList()[i].getCategory_title());
          requestBody.setFlag(true);
          requestBody.setCategory_description("For income purpose");
          APIRunner.runPUT(url,requestBody);
      }





    }


}


