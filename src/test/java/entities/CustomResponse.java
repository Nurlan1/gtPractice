package entities;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.response.Response;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class CustomResponse {
    private  String jwt_token;
    private  String message;
    private  String company_name;
    private String seller_name;
    private String phone_number;
    private boolean income;

    private String  category_id;

    private  String bank_account_name;
    private String id;
    private int balance;
    private String email;

    private String type_of_pay;

    private String jsonString;
    private  int statusCode;

    private  String description;
    private  String category_title;
    private  String category_description;
    private  boolean flag;
    private  String client_name;
    private List<Universal> tags;
    private List<Universal> responses;




}
