package utilities;

import entities.CustomResponse;
import entities.RequestBody;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class APIRunner {

    private  static CustomResponse customResponse;

    private static  CustomResponse [] responseList;

    public  static void runGET(String path){
       String token= Config.getValue("cashWiseToken");
       String url=Config.getValue("cashWiseBackEnd")+path;
        Response response= RestAssured.given().auth().oauth2(token).get(url);
        System.out.println("GET Status code "+ response.statusCode());
        ObjectMapper mapper=new ObjectMapper();
        try {
             customResponse =mapper.readValue(response.asPrettyString(), CustomResponse.class);
             customResponse.setJsonString(response.asPrettyString());
             customResponse.setStatusCode(response.statusCode());
        } catch (JsonProcessingException e) {
            System.out.println("Couldn't map JSON to CustomResponse");
        }
    }

    public static CustomResponse getCustomResponse(){

        return customResponse;
    }
    public static void runGetList(String path){
        String token= Config.getValue("cashWiseToken");
        String url=Config.getValue("cashWiseBackEnd")+path;
        Response response= RestAssured.given().auth().oauth2(token).get(url);
        System.out.println("GET Status code "+ response.statusCode());
        ObjectMapper mapper=new ObjectMapper();
        try {
           responseList =mapper.readValue(response.asPrettyString(), CustomResponse[].class);

        } catch (JsonProcessingException e) {
            System.out.println("Couldn't map JSON to CustomResponse");
        }
    }

    public  static CustomResponse [] getResponseList(){
        return responseList;
    }

    public static void runPOST(String path, RequestBody requestBody){

        String url=Config.getValue("cashWiseBackEnd")+path;
        String token=Config.getValue("cashWiseToken");
        Response response=RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(requestBody).post(url);
        System.out.println("POST Status: "+response.statusCode());
        System.out.println(response.asPrettyString());
        ObjectMapper mapper=new ObjectMapper();
        try {
            customResponse=mapper.readValue(response.asString(), CustomResponse.class);
            customResponse.setJsonString(response.asString());
            customResponse.setStatusCode(response.statusCode());
        } catch (JsonProcessingException e) {
            System.out.println("Couldn't map to CustomResponse");
        }
    }

    public  static void runDELETE(String path){
        String token= Config.getValue("cashWiseToken");
        String url=Config.getValue("cashWiseBackEnd")+path;
        Response response= RestAssured.given().auth().oauth2(token).delete(url);
        System.out.println("DELETE Status code "+ response.statusCode());
        ObjectMapper mapper=new ObjectMapper();
        try {
            customResponse =mapper.readValue(response.asPrettyString(), CustomResponse.class);
            customResponse.setJsonString(response.asPrettyString());
            customResponse.setStatusCode(response.statusCode());
        } catch (JsonProcessingException e) {
            System.out.println("Couldn't map JSON to CustomResponse");
        }
    }

    public static void runPUT(String path, RequestBody requestBody){

        String token= Config.getValue("cashWiseToken");
        String url=Config.getValue("cashWiseBackEnd")+path;
        Response response= RestAssured.given().auth().oauth2(token).contentType((ContentType.JSON)).body(requestBody).put(url);
        System.out.println("Update Status code "+ response.statusCode());
        ObjectMapper mapper=new ObjectMapper();
        try {
            customResponse =mapper.readValue(response.asPrettyString(), CustomResponse.class);
            customResponse.setJsonString(response.asPrettyString());
            customResponse.setStatusCode(response.statusCode());
        } catch (JsonProcessingException e) {
            System.out.println("Couldn't map JSON to CustomResponse");
        }
    }

    public  static void runGET(String path, Map<String,Object> params){
        String token= Config.getValue("cashWiseToken");
        String url=Config.getValue("cashWiseBackEnd")+path;
        Response response= RestAssured.given().auth().oauth2(token).params(params).get(url);
        System.out.println("GET Status code "+ response.statusCode());
        ObjectMapper mapper=new ObjectMapper();
        try {
            customResponse =mapper.readValue(response.asPrettyString(), CustomResponse.class);
            customResponse.setJsonString(response.asPrettyString());
            customResponse.setStatusCode(response.statusCode());
        } catch (JsonProcessingException e) {
            System.out.println("Couldn't map JSON to CustomResponse");
        }
    }
}


