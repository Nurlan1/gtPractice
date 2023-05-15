package cashWise;

import com.github.javafaker.Faker;
import entities.RequestBody;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import utilities.APIRunner;

public class TagTests {

    @Test
    public void createTag() {
        String path = "/feature/api/myaccount/tags";
        RequestBody requestBody = new RequestBody();
        Faker faker = new Faker();

        String pathForGet= "/feature/api/myaccount/tags/all";
        APIRunner.runGetList(pathForGet);
        int sizeBefore=APIRunner.getResponseList().length;
        System.out.println(sizeBefore);

        for (int i = 0; i <= 1; i++) {
            requestBody.setName_tag(faker.name().title());
            requestBody.setDescription(faker.commerce().color());

            APIRunner.runPOST(path, requestBody);
        }
        APIRunner.runGetList(pathForGet);
        int sizeAfter=APIRunner.getResponseList().length;
        System.out.println(APIRunner.getResponseList().length);
        Assert.assertTrue(sizeAfter>sizeBefore);
    }
}