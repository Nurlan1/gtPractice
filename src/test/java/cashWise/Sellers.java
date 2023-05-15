package cashWise;

import com.github.javafaker.Faker;
import entities.RequestBody;
import org.junit.jupiter.api.Test;
import utilities.APIRunner;

public class Sellers {

    @Test
    public void createSeller(){
        String path= "/feature/api/myaccount/sellers";
        RequestBody requestBody=new RequestBody();
        Faker faker=new Faker();
        requestBody.setCompany_name(faker.company().name());
        requestBody.setSeller_name(faker.name().fullName());
        requestBody.setEmail(faker.internet().emailAddress());
        requestBody.setPhone_number(faker.phoneNumber().cellPhone());
        requestBody.setAddress(faker.address().city());

        APIRunner.runPOST(path,requestBody);

    }
    @Test
    public  void createSellersFaker(){
        String path= "/feature/api/myaccount/sellers";
        RequestBody requestBody=new RequestBody();
        Faker faker=new Faker();

        for(int i=0; i<=10; i++){

            requestBody.setCompany_name(faker.company().name());
            requestBody.setSeller_name(faker.name().fullName());
            requestBody.setEmail(faker.internet().emailAddress());
            requestBody.setPhone_number(faker.phoneNumber().cellPhone());
            requestBody.setAddress(faker.address().city());
            APIRunner.runPOST(path,requestBody);

        }

    }




}
