package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class Mouse {


    @Test
    public  void signIn(){
        Response response=RestAssured.get("https://reqres.in/api/users/2");
        System.out.println(response.statusCode());
        //System.out.println(response.asString());
        String email=response.jsonPath().get("data.email");
        System.out.println(email);
        String avatar=response.jsonPath().get("data.avatar");
        System.out.println(avatar);
        int id=response.jsonPath().get("data.id");

        System.out.println(id);
        String text=response.jsonPath().get("support.text");

        Assert.assertFalse("Email is empty",email.trim().isEmpty());
        Assert.assertTrue(email.trim().endsWith("reqres.in"));

        Assert.assertTrue(id>0);
        Assert.assertTrue(avatar.trim().endsWith(".jpeg")||avatar.trim().endsWith(".png")||avatar.endsWith(".jpg"));
        String expectedText="To keep RegRes free,contributions towards server costs are appreciated!";
        Assert.assertEquals(expectedText,text);





    }
    /*
    @Test
    public void listOfUsers(){
        Response response= RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
        // System.out.println(response.asString());

        String email = response.jsonPath().get("data.email").toString();

        System.out.println(email);

        int id = response.jsonPath().get("data.id");
        System.out.println(id);

        String avatar= response.jsonPath().get("data.avatar");
        System.out.println(avatar);

        String text = response.jsonPath().get("support.text");
        System.out.println(email);
        System.out.println(id);
        System.out.println(avatar);
        System.out.println(text);


        Assert.assertFalse("Email is empty",email.trim().isEmpty());
        Assert.assertTrue(email.trim().endsWith("regres.in"));

        Assert.assertTrue(id>0);

        Assert.assertTrue(avatar.trim().endsWith(".jpeg") ||
                avatar.trim().endsWith(".png") || avatar.trim().endsWith(".jpg"));

        // String expectedText = "To keep RegRes free,contributions towards server costs are appreciated!";
        // Assert.assertEquals(expectedText,text);

    }

    @Test

    public void listOfUser(){

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
        //System.out.println(response.asString());

        String url  = response.jsonPath().get("support.url");
        System.out.println(url);




        int  size = response.jsonPath().get("per_page");

        for (int i = 0; i < size; i++){
            String path = "data[" + i + "].first_name";
            String name = response.jsonPath().get(path);
            System.out.println(name);
            Assert.assertFalse("Name is empty. Index: " + i, name.trim().isEmpty());
        }
    }

     */

}
