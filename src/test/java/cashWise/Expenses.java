package cashWise;

import entities.CustomResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import utilities.APIRunner;

public class Expenses {

    @Test
    public void seller(){
        String path= "/feature/api/myaccount/sellers/77";

        APIRunner.runGET(path);
        APIRunner.getCustomResponse();

        CustomResponse myResponse=APIRunner.getCustomResponse();
       // System.out.println(myResponse.getCompany_name());
        //System.out.println(myResponse.getSeller_name());
        //System.out.println(myResponse.getPhone_number());

        Assert.assertNotNull(myResponse.getCompany_name());
        Assert.assertNotNull(myResponse.getSeller_name());
        Assert.assertNotNull(myResponse.getPhone_number());
        Assert.assertNotNull(myResponse.getEmail());

        Assert.assertTrue(myResponse.getSeller_name().trim().isEmpty());
        Assert.assertTrue(myResponse.getCompany_name().trim().isEmpty());
        Assert.assertTrue(myResponse.getEmail().trim().isEmpty());
        Assert.assertTrue(myResponse.getPhone_number().trim().isEmpty());

          Assert.assertTrue(myResponse.getEmail().trim().contains("@")&&myResponse.getEmail().trim().contains("."));

        String phoneNumber= APIRunner.getCustomResponse().getPhone_number();
        phoneNumber=phoneNumber.replace("+","");
        phoneNumber=phoneNumber.replace(" ","");
        phoneNumber=phoneNumber.replace("_","");
        Assert.assertTrue(phoneNumber.length()==10||phoneNumber.length()==11);

       /*
        boolean email=false;
        if(myResponse.getEmail().contains("@")&& myResponse.getEmail().contains(".")){
             email=true;
            Assert.assertTrue(email);
        }


        String phoneNumber= myResponse.getPhone_number();
        boolean phoneNum=false;
        for(int i=0; i<phoneNumber.length(); i++){
            Character c=phoneNumber.charAt(i);
            if(c.isDigit(c));
            if(phoneNumber.contains("+")){
                phoneNum=true;
                Assert.assertTrue(phoneNum);
            }
        }
        */

    }
    @Test
    public void singleBankAccount(){

        String path= "/feature/api/myaccount/bankaccount/7";
        APIRunner.runGET(path);
        //System.out.println(APIRunner.getCustomResponse().getBank_account_name());
        //System.out.println(APIRunner.getCustomResponse().getType_of_pay());
        //System.out.println(APIRunner.getCustomResponse().getBalance());
        //System.out.println(APIRunner.getCustomResponse().getJsonString());

        Assert.assertEquals(200, APIRunner.getCustomResponse().getStatusCode());

    }

    @Test
    public void verifySellers(){

        String path= "/feature/api/myaccount/sellers/all";
        APIRunner.runGetList(path);
        System.out.println(APIRunner.getResponseList().length);

        for(int i=0; i<APIRunner.getResponseList().length; i++){
            System.out.println(APIRunner.getResponseList()[i].getSeller_name());

            Assert.assertNotNull(APIRunner.getResponseList()[i].getSeller_name());
            Assert.assertNotNull(APIRunner.getResponseList()[i].getCompany_name());

        }
    }





}
